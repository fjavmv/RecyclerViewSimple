package com.fjavmvazquez.recyclerviewsimple;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    private ArrayList<String> mArrayList;

   public AdapterDatos(ArrayList<String> mArrayList){
        this.mArrayList = mArrayList;
    }


    @NonNull
    @Override
    public AdapterDatos.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDatos.ViewHolderDatos holder, int position) {
        //Establece la comunicación entre el adaptador y ViewHolderDatos
        holder.asignarDatos(mArrayList.get(position));

    }

    @Override
    public int getItemCount() {
        //retorna el tamaño de la lista
        return mArrayList.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView data;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            data = itemView.findViewById(R.id.txtTexto);
        }

        public void asignarDatos(String s) {
            data.setText(s);
        }

    }
}
