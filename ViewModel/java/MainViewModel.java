package unhas.informatika.myviewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainViewModel extends ViewModel {
    private static final String API_KEY = "c62ba897fef010bea8ebf378ac2f71d9";
    //alternatif API_KEY
    //private static final String API_KEY = "2adbb675bdd05bfd3b547a01f9938462";

    //url to get weather info
    //String url = "https://api.openweathermap.org/data/2.5/group?id=" + cities + "&units=metric&appid=" + API_KEY;

    private MutableLiveData<ArrayList<WeatherItems>> listWeathers = new MutableLiveData<>();

    
}
