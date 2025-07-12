package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerPersonas;
    PersonaAdapter adapter;
    ArrayList<Persona> listaPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2); // Este es tu layout con RecyclerView

        recyclerPersonas = findViewById(R.id.recyclerPersonas);

        // Obtener la lista que llega desde el intent
        listaPersonas = (ArrayList<Persona>) getIntent().getSerializableExtra("listaPersonas");

        // Configurar RecyclerView
        adapter = new PersonaAdapter(listaPersonas);
        recyclerPersonas.setLayoutManager(new LinearLayoutManager(this));
        recyclerPersonas.setAdapter(adapter);
    }
}
