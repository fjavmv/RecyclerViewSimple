package com.fjavmvazquez.recyclerviewsimple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<String> mArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerDatos);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
     //   mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        mArrayList = new ArrayList<>();
        llenar();
        AdapterDatos adapterDatos = new AdapterDatos(mArrayList);
        mRecyclerView.setAdapter(adapterDatos);
    }


  private void llenar(){
        for (int i= 0; i <= 100; i++){
            mArrayList.add("Elemento: " + i);
        }
    }

}