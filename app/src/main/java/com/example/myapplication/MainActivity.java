package com.example.myapplication;

import androidx.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etApellido, etEdad;
    Button btnEnviar;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etEdad = findViewById(R.id.etEdad);
        btnEnviar = findViewById(R.id.btnEnviar);

        //  inicializa correctamente la variable de clase `db`
        db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "mi_base_de_datos")
                .allowMainThreadQueries()
                .build();
    }

    public void enviar(View view) {
        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        int edad = Integer.parseInt(etEdad.getText().toString());

        Persona persona = new Persona(nombre, apellido, edad);

        db.personaDao().insertar(persona);

        ArrayList<Persona> lista = new ArrayList<>(db.personaDao().obtenerTodas());

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("listaPersonas", lista);
        startActivity(intent);
    }
}
