package com.example.tuningit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Principal extends AppCompatActivity implements RecyclerViewInterface {

    //Crear un arrayList de productos
    ArrayList<modeloProductos> modelosProductos = new ArrayList<>();
    //ArrayList de imagenes de productos
    int[] imagen_productos = {R.drawable.vinilo_rojo,R.drawable.vinilo_azul,R.drawable.cinta_amarilla,R.drawable.cinta_bicolor,R.drawable.luces_led,
            R.drawable.tiras_led,R.drawable.palanca_burbuja,R.drawable.palanca_tornasol};

    private Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnRegresar = findViewById(R.id.btnRegresar);

        //asignar el id del recycler view a una variable
        RecyclerView recyclerView = findViewById(R.id.recyclerView_id);

        //llamamos al metodo que seteara los productos
        setearModeloProductos();

        //creamos el adapter hecho
        p_RecyclerViewAdapter adapter = new p_RecyclerViewAdapter(this,modelosProductos,this);
        recyclerView.setAdapter(adapter);
        //Se lo entregamos al recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ir_menu();
            }
        });
    }

    private void ir_menu() {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
        finish();
    }

    private void setearModeloProductos(){
        //Instanciamos arraylists con los nombres y descripcion de los productos
        String[]  nombre_productos = getResources().getStringArray(R.array.lista_productos);
        String[] descripcion_productos = getResources().getStringArray(R.array.lista_productos_descripcion);

        //Agregamos a la arraylist de productos objetos con los atributos de las listas anteriores
        for (int i = 0; i< nombre_productos.length; i++){
            modelosProductos.add(new modeloProductos(nombre_productos[i],
                    descripcion_productos[i],
                    imagen_productos[i]));
        }
    }

    @Override
    public void itemSeleccionado(int position) {
        Intent intent = new Intent(Principal.this, Productos.class);

        intent.putExtra("nombreProducto",modelosProductos.get(position).getNombreProducto());
        intent.putExtra("descripcionProductos",modelosProductos.get(position).getDescripcionProducto());
        intent.putExtra("imagen",modelosProductos.get(position).getImagen());

        startActivity(intent);
        finish();
    }
}