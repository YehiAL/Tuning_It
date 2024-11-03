package com.example.tuningit;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Menu extends AppCompatActivity {

    private Button btnIrProductos;
    private Button btnIrLista;
    private Button btnIrPerfil;
    private Button btnIrAgenda;
    private Button btnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnIrPerfil = findViewById(R.id.btnIrPerfil);
        btnIrProductos = findViewById(R.id.btnIrProductos);
        btnIrLista = findViewById(R.id.btnIrLista);
        btnIrAgenda = findViewById(R.id.btnIrAgenda);
        btnSalir = findViewById(R.id.btnSalir);

        //Recibimos el intent para poder enviarlo al perfil
        Intent intent = getIntent();
        String nombreUsuario_intent = intent.getStringExtra("usuario").toString();


        btnIrPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ir_perfil(nombreUsuario_intent);
            }
        });

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

        btnIrAgenda.setOnClickListener(new View.OnClickListener() {
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
        Intent intent = new Intent(this, ListaDeseados.class);
        startActivity(intent);
    }
    private void ir_agenda() {
        Intent intent = new Intent(this, Agenda.class);
        startActivity(intent);
    }
    private void ir_productos() {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }
    private void ir_perfil(String nombreUsuario_intent) {
        Intent intent = new Intent(this, Perfil.class);
        intent.putExtra("usuario",nombreUsuario_intent);
        startActivity(intent);
    }
}