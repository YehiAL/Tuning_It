package com.example.tuningit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    private TextView tvNombreUsuario;
    private TextView tvNombreCompleto;
    private TextView tvCorreo;
    private TextView tvContrasena;
    private TextView tvConfirmarContrasena;
    private Button btnRegistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvNombreUsuario = findViewById(R.id.tvNombreUsuarioLogin);
        tvNombreCompleto = findViewById(R.id.tvNombreCompletoLogin);
        tvCorreo = findViewById(R.id.tvCorreoLogin);
        tvContrasena = findViewById(R.id.tvContrasenaLogin);
        tvConfirmarContrasena = findViewById(R.id.tvConfirmarContrasena);
        btnRegistrar = findViewById(R.id.btnRegistrarLogin);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validarContrasena()){
                    registrar();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void registrar() {
        try {
            //Obtengo los datos de los widgets del layout
            String nombre_usuario = tvNombreUsuario.getText().toString();
            String nombre_completo = tvNombreCompleto.getText().toString();
            String correo = tvCorreo.getText().toString();
            String contrasena = tvContrasena.getText().toString();

            //Utilizo este metodo para abrir la base de datos, el mismo se encargara de crear una db en caso de que no exista
            //el contexto en private hace que solo la app que la creo pueda acceder a la base.
            SQLiteDatabase db = openOrCreateDatabase("BD_TuningIt", Context.MODE_PRIVATE,null);

            //Ejjecuto una sentencia sql para crear la tabla con los datos de los usuarios
            db.execSQL("CREATE TABLE IF NOT EXISTS usuario(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre_usuario VARCHAR, nombre_completo VARCHAR, correo VARCHAR, contrasena VARCHAR)");

            //Se realiza un insert con parametros para evitar las inyecciones sql, esta almacena los datos el las columnas correspondientes
            String sql = "insert into usuario(nombre_usuario,nombre_completo,correo,contrasena)values(?,?,?,?)";
            SQLiteStatement statement = db.compileStatement(sql);

            //Para asignar lo ingresado a la interfaz con los parametros de la sentencia sql se usa el bindstring
            statement.bindString(1,nombre_usuario);
            statement.bindString(2,nombre_completo);
            statement.bindString(3,correo);
            statement.bindString(4,contrasena);

            //finalmente se ejecuta la sentencia
            statement.execute();

            Toast.makeText(this,"Datos ingresados a la base de datos.",Toast.LENGTH_LONG).show();

        }catch (Exception ex) {
            Toast.makeText(this,"Error no se pudieron guardar los datos.",Toast.LENGTH_LONG).show();
        }
    }

    private boolean validarContrasena(){
        String contra1 = tvContrasena.getText().toString();
        String contra2 = tvConfirmarContrasena.getText().toString();
        if (tvContrasena.length()<4) {
            Toast.makeText(Login.this, "La contraseña debe tener minimo 4 caracteres", Toast.LENGTH_SHORT).show();
            return false;
        } else if(contra1.equals(contra2) ){
            return true;
        }else {
            Toast.makeText(Login.this,"Las contraseñas ingresadas deben coincidir",Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}