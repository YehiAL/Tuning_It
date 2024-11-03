package com.example.tuningit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvNombreUsuario;
    private TextView tvContrasena;
    private Button btnIngresar;
    private Button btnRegistrar;


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
                String usuario = tvNombreUsuario.getText().toString();
                String contra = tvContrasena.getText().toString();

                if(validarUsuario(usuario,contra)){
                    Intent intent = new Intent(getApplicationContext(), Menu.class);
                    //Le pasamos un intent con el nombre de usuario
                    intent.putExtra("usuario",usuario);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"Los datos ingresados son incorrectos",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private boolean validarUsuario(String usuario, String contra) {
        boolean validacion = false;
        try{
            SQLiteDatabase db = openOrCreateDatabase("BD_TuningIt", Context.MODE_PRIVATE,null);

            //Se realiza la consulta a la base de datos
            String sql = "SELECT * FROM usuario WHERE nombre_usuario = ? AND contrasena = ?";
            SQLiteStatement statement = db.compileStatement(sql);
            //metodos bind para pasar parametros
            statement.bindString(1,usuario);
            statement.bindString(2,contra);

            //Se ejecuta la consulta usando la cadena string para pasarle los datos
            Cursor cursor = db.rawQuery(sql, new String[]{usuario,contra});
            if(cursor.moveToFirst()){
                validacion = true; //En caso de que haya una coincidencia
            }

            cursor.close();

        }catch (Exception e) {
            Toast.makeText(this, "Error en la conexion a la base de datos.", Toast.LENGTH_LONG).show();
        }
        return validacion;
    }

    public void ir_login(){
        Intent intent=new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
}