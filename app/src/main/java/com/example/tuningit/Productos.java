package com.example.tuningit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Productos extends AppCompatActivity {
    private TextView tvNombreProductos;
    private TextView tvDescripcionProductos;
    private ImageView ivProductos;
    private Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        tvNombreProductos = findViewById(R.id.tvNombreProducto_prod);
        tvDescripcionProductos = findViewById(R.id.tvDescProductos_prod);
        ivProductos = findViewById(R.id.ivProductos_prod);
        btnRegresar = findViewById(R.id.btnRegresarProductos);

        //Obtener valores de los extras y setearlos en los textviews
        String nombre = getIntent().getExtras().getString("nombreProducto");
        String descripcion = getIntent().getExtras().getString("descripcionProductos");
        int imagen = getIntent().getIntExtra("imagen",0);

        tvNombreProductos.setText(nombre);
        tvDescripcionProductos.setText(descripcion);
        ivProductos.setImageResource(imagen);


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ir_productos();
            }
        });


    }

    private void ir_productos() {
        Intent intent = new Intent(Productos.this, Principal.class);
        startActivity(intent);
        finish();
    }
}