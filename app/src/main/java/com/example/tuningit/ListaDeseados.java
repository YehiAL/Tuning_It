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

public class ListaDeseados extends AppCompatActivity {

    private Button btnRegresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_deseados);

        btnRegresar = findViewById(R.id.btnRegresarLista);

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
}