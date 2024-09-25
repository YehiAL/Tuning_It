package com.example.tuningit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Menu extends AppCompatActivity {
    private TextView tvNombreUsuario_menu;
    private Button btnIrProductos;
    private Button btnIrLista;
    private Button btnIrPerfil;
    private Button btnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tvNombreUsuario_menu = findViewById(R.id.tvNombreUsuarioMenu);
        btnIrProductos = findViewById(R.id.btnIrProductos);
        btnIrLista = findViewById(R.id.btnIrLista);
        btnIrPerfil = findViewById(R.id.btnIrAgenda);
        btnSalir = findViewById(R.id.btnSalir);

        Intent intent = getIntent();
        String usuario = intent.getExtras().getString("usuario");

        tvNombreUsuario_menu.setText("Hola "+usuario);

        btnIrProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ir_productos();
            }
        });

        btnIrLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ir_lista();
            }
        });

        btnIrPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ir_agenda();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void ir_lista() {
    }

    private void ir_agenda() {
        Intent intent = new Intent(this, Agenda.class);
        startActivity(intent);
    }

    private void ir_productos() {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }
}