package com.fjavmvazquez.recyclerviewsimple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<String> mArrayList;
    private CheckBox mCheckBox1, mCheckBox2;
    private TextView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerDatos);
        mCheckBox1 = findViewById(R.id.checkbox1);
        mCheckBox2 = findViewById(R.id.checkbox2);
        mensaje = findViewById(R.id.mensaje);

//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
     //   mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
      //  mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        mensaje.setText("No hay elementos por mostrar");


        mCheckBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCheckBox1.isChecked()){
                    mCheckBox2.setChecked(false);
                    mensaje.setText(" ");
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
                    mArrayList = new ArrayList<>();
                    llenar();
                    AdapterDatos adapterDatos = new AdapterDatos(mArrayList);
                    mRecyclerView.setAdapter(adapterDatos);

                }else {
                    mRecyclerView.setAdapter(null);
                    mensaje.setText("No hay elementos por mostrar");
                }
            }
        });

        mCheckBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCheckBox2.isChecked()){
                    mCheckBox1.setChecked(false);
                    mensaje.setText(" ");
                    mRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
                    mArrayList = new ArrayList<>();
                    llenar();
                    AdapterDatos adapterDatos = new AdapterDatos(mArrayList);
                    mRecyclerView.setAdapter(adapterDatos);
                }else{
                    mRecyclerView.setAdapter(null);
                    mensaje.setText("No hay elementos por mostrar");
                }
            }
        });




    }


  private void llenar(){
        for (int i= 0; i <= 100; i++){
            mArrayList.add("Elemento: " + i);
        }
    }

}