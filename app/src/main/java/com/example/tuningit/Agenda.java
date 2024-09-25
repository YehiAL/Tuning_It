package com.example.tuningit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Agenda extends AppCompatActivity {

    private EditText etHora;
    private Button btnRegresarAgenda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);


        etHora = findViewById(R.id.etHoraAgenda);
        btnRegresarAgenda = findViewById(R.id.btnRegresarAgenda);

        btnRegresarAgenda.setOnClickListener(new View.OnClickListener() {
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