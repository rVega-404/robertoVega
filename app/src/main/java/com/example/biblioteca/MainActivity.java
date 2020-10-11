package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.FileUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ProgressBar pgrLogin;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pgrLogin = (ProgressBar)findViewById(R.id.pgrLogin);
        pgrLogin.setVisibility(View.INVISIBLE);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task().execute();
            }
        });
    }

    class Task extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            pgrLogin.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            for(int i = 1; i <= 5; i ++) {
                try {
                    Thread.sleep(1000);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            pgrLogin.setVisibility(View.INVISIBLE);
            Intent intent = new Intent(getBaseContext(), Home_act.class);
            startActivity(intent);
        }
    }

    public void GitHub(View view) {
        ArrayList<String> libros = new ArrayList<String>();
        libros.add("Farenheith");
        libros.add("Revival");
        libros.add("El Alquimista");
        libros.add("El Poder");
        libros.add("Despertar");

        Intent intent = new Intent(this, Github_act.class);
        intent.putExtra("listaLibros", libros);
        startActivity(intent);
    }
}