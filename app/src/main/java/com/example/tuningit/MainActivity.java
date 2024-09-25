package com.example.tuningit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvNombreUsuario;
    private TextView tvContrasena;
    private Button btnIngresar;
    private Button btnRegistrar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNombreUsuario = findViewById(R.id.tvNombreUsuario);
        tvContrasena = findViewById(R.id.tvContrasena);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ir_login();
            }
        });
        
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ir_menu();
            }
        });
    }

    private void ir_menu() {
        String usuario = tvNombreUsuario.getText().toString();
        String contra = tvContrasena.getText().toString();
        Intent intent = new Intent(this, Menu.class);
        intent.putExtra("usuario",usuario);
        startActivity(intent);
        finish();
    }

    public void ir_login(){
        Intent intent=new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
}