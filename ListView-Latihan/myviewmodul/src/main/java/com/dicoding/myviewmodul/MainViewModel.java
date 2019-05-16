package com.dicoding.myviewmodul;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainViewModel extends ViewModel{
    private static final String API_KEY = "5946e4b1fc465c6b21705e612aa05280\n";
    //alternatif API_KEY
    //private static final String API_KEY = "2adbb675bdd05bfd3b547a01f9938462";

    //url to get weather info
    //String url = "https://api.openweathermap.org/data/2.5/group?id=" + cities + "&units=metric&appid=" + API_KEY;

    private MutableLiveData<ArrayList<WeatherItems>> listWeathers = new MutableLiveData<>();

    public static String getApiKey(){
        return API_KEY;
    }

    public MutableLiveData<ArrayList<WeatherItems>> getListWeathers(){
        return listWeathers;
    }

    public void setListWeathers(MutableLiveData<ArrayList<WeatherItems>> listWeathers) {
        this.listWeathers = listWeathers;
    }

    void setWeather(final String cities){
        //Request via web API
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<WeatherItems> listItems = new ArrayList<>();
        String url = "https://api.openweathermap.org/data/2.5/group?id=" + cities + "&units=metric&appid=" + API_KEY;

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray list = responseObject.getJSONArray("list");
                    for (int i = 0; i<list.length(); i++){
                        JSONObject weather = list.getJSONObject(i);
                        WeatherItems weatherItems = new WeatherItems(weather);
                        listItems.add(weatherItems);
                    }
                    listWeathers.postValue(listItems);
                } catch (Exception e){
                    Log.d("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure", error.getMessage());

            }
        });
    }
}
