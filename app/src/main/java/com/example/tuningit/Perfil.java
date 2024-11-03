package com.example.tuningit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Perfil extends AppCompatActivity {

    private TextView nombreUsuarioPerfil;
    private TextView nombreCompletoPerfil;
    private TextView correoPerfil;
    private Button btnRegresar;
    private ImageButton btnEditarCorreoPerfil;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        nombreUsuarioPerfil = findViewById(R.id.nombreUsuarioPerfil);
        nombreCompletoPerfil = findViewById(R.id.nombreCompletoPerfil);
        correoPerfil = findViewById(R.id.correoPerfil);

        btnRegresar = findViewById(R.id.btnRegresarPerfil);
        btnEditarCorreoPerfil = findViewById(R.id.btnEditarCorreoPerfil);

        //Intent para cargar datos
        Intent intent = getIntent();
        String nombreUsuario_intent = intent.getStringExtra("usuario").toString();

        cargarDatos(nombreUsuario_intent);

        btnEditarCorreoPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correoPerfil.setEnabled(true);
                correoPerfil.requestFocus();
                //Cambiar el icono de la imagen en el imageButton
                btnEditarCorreoPerfil.setImageResource(R.drawable.guardar);

                //cuando se vuelva a presionar, desactivara el EditText, ejecutara el metodo editar y volvera al icono inicial
                btnEditarCorreoPerfil.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editar();
                        correoPerfil.setEnabled(false);
                        btnEditarCorreoPerfil.setImageResource(R.drawable.baseline_edit_24);

                    }
                });
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Perfil.this, Menu.class);
                startActivity(intent);
                finish();

            }
        });
    }

    private void editar() {
        try {
            //Pasar los datos de los widgets
            String nombreUsuario = nombreUsuarioPerfil.getText().toString();
            String correo = correoPerfil.getText().toString();
            //Abrir la base de datos
            SQLiteDatabase db = openOrCreateDatabase("BD_TuningIt",Context.MODE_PRIVATE,null);
            //Preparar la SENTENCIA
            String sql = "UPDATE usuario SET correo = ? WHERE nombre_usuario=?";
            SQLiteStatement statement = db.compileStatement(sql);
            //Se les asigna el parametro *NOTA: los index van en el orden de la consulta, en este caso primero va el correo y despues el nombre por el where*
            statement.bindString(1,correo);
            statement.bindString(2,nombreUsuario);
            //Se ejecuta la SENTENCIA
            statement.execute();
            //Toast para confirmar que va correctamente
            Toast.makeText(this,"Datos actualizados en la base de datos.",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(this, "Error en la conexion a la base de datos.", Toast.LENGTH_LONG).show();
        }
    }

    private void cargarDatos(String nombreUsuario_intent) {
        try {
            //Abrir la base de datos
            SQLiteDatabase db = openOrCreateDatabase("BD_TuningIt",Context.MODE_PRIVATE,null);
            //Prepapar la consulta sql
            String sql = "SELECT * FROM usuario WHERE nombre_usuario = ?";
            //Ejecutar la consulta
            Cursor cursor = db.rawQuery(sql,new String[]{nombreUsuario_intent});

            if (cursor.moveToFirst()){
                //Pasar los datos obtenidos de las columnas a string
                String nombreUsuario = cursor.getString(cursor.getColumnIndexOrThrow("nombre_usuario"));
                String nombreCompleto = cursor.getString(cursor.getColumnIndexOrThrow("nombre_completo"));
                String correo = cursor.getString(cursor.getColumnIndexOrThrow("correo"));

                nombreUsuarioPerfil.setText(nombreUsuario);
                nombreCompletoPerfil.setText(nombreCompleto);
                correoPerfil.setText(correo);
            }

        }catch (Exception e){
            Toast.makeText(this, "Error en la conexion a la base de datos.", Toast.LENGTH_LONG).show();
        }
    }
}