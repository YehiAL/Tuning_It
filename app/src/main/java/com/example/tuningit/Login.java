package com.example.tuningit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    private TextView tvNombreUsuario;
    private TextView tvNombre;
    private TextView tvCorreo;
    private TextView tvContrasena;
    private TextView tvValidarContrasena;
    private Button btnRegistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvNombreUsuario = findViewById(R.id.tvNombreUsuarioLogin);
        tvNombre = findViewById(R.id.tvNombreCompletoLogin);
        tvContrasena = findViewById(R.id.tvContrasenaLogin);
        tvValidarContrasena = findViewById(R.id.tvConfirmarContrasena);
        btnRegistrar = findViewById(R.id.btnRegistrarLogin);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Login.this,"Usuario Registrado",Toast.LENGTH_SHORT).show();
                explicito_main();
            }
        });


    }

    private void explicito_main() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}