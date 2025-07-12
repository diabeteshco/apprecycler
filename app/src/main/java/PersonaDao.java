package com.example.myapplication;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
import com.example.myapplication.Persona;

@Dao
public interface PersonaDao {

    @Insert
    void insertar(Persona persona);

    @Query("SELECT * FROM Persona")
    List<Persona> obtenerTodas();
}
