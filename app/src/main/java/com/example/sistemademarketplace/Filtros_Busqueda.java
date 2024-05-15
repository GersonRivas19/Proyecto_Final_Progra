package com.example.sistemademarketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Filtros_Busqueda extends AppCompatActivity {

    String categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtros_busqueda);

        categoria = getIntent().getStringExtra("categoria");
        Toast.makeText(this, "Se selecciono el filtro de: " + categoria, Toast.LENGTH_SHORT).show();
    }
}