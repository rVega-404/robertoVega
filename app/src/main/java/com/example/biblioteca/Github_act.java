package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.PrecioLibros;

public class Github_act extends AppCompatActivity {
    private Spinner spnLibros;
    private TextView txtSeleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_act);

        spnLibros = (Spinner)findViewById(R.id.spnLibros);

        ArrayList<String> listaLibros = (ArrayList<String>) getIntent().getSerializableExtra("listaLibros");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaLibros);
        spnLibros.setAdapter(adapter);

        txtSeleccion = (TextView)findViewById(R.id.txtSeleccion);
    }

    public void Seleccionar(View view) {
        PrecioLibros precioLibros = new PrecioLibros();

        String libro = spnLibros.getSelectedItem().toString();

        if(libro.equals("Farenheith")){
            txtSeleccion.setText("El valor de " + libro + " es: " + precioLibros.getFarenheith());
        }
        else if (libro.equals("Revival")) {
            txtSeleccion.setText("El valor de " + libro + " es: " + precioLibros.getRevival());
        }
        else if (libro.equals("El Alquimista")) {
            txtSeleccion.setText("El valor de " + libro + " es: " + precioLibros.getElAlquimista());
        }
        else if (libro.equals("El Poder")) {
            txtSeleccion.setText("El valor de " + libro + " es: " + precioLibros.getElPoder());
        }
        else if (libro.equals("Despertar")) {
            txtSeleccion.setText("El valor de " + libro + " es: " + precioLibros.getDespertar());
        }
    }
}