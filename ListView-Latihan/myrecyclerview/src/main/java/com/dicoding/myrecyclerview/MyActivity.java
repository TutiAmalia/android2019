package com.dicoding.myrecyclerview;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MyActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private ArrayList<Hero> heroes;

    private ListHeroAdapter adapter;
    private RecyclerView rvHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        prepare();
        rvHeroes = findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);

        showListRecycler();
    }

    private void showListRecycler() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter adapter = new ListHeroAdapter(this);
        addItem();
        adapter.setHeroes(heroes);
        rvHeroes.setAdapter(adapter);
    }


    private void addItem(){
        heroes = new ArrayList<>();
        for(int i = 0; i < dataName.length; i++){
            Hero hero = new Hero();
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            hero.setPhoto(dataPhoto.getResourceId(i,-1));
            heroes.add(hero);
        }

    }

    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }
}
