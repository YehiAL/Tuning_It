package com.example.tuningit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class p_RecyclerViewAdapter extends RecyclerView.Adapter<p_RecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<modeloProductos>modelosProductos;

    public p_RecyclerViewAdapter(Context context, ArrayList<modeloProductos> modelosProductos ){
        this.context = context;
        this.modelosProductos = modelosProductos;
    }

    @NonNull
    @Override
    public p_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Aqui es donde se completa el layout
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate((R.layout.recyclerviewcolumnas), parent, false);
        return new p_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull p_RecyclerViewAdapter.MyViewHolder holder, int position) {
        //Asignar valores a las vistas creadas en el recycler_view
        // basado en la posicion del recycler view
        holder.tvNombreProductos.setText(modelosProductos.get(position).getNombreProducto());
        holder.tvDescripcionProductos.setText(modelosProductos.get(position).getDescripcionProducto());
        holder.imagenProductos.setImageResource(modelosProductos.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        //Obtendra el numeros de items que se quieren mostrar
        return modelosProductos.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{
        //Asigna variables a los views
        //como el onCreate

        ImageView imagenProductos;
        TextView tvNombreProductos, tvDescripcionProductos;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imagenProductos = itemView.findViewById(R.id.ivProductos);
            tvNombreProductos = itemView.findViewById(R.id.tvNomProductos);
            tvDescripcionProductos = itemView.findViewById(R.id.tvDescProductos);
        }
    }
}
