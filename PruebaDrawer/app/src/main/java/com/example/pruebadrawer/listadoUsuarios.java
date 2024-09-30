package com.example.pruebadrawer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ConexionBD.DataMainActivity;

public class listadoUsuarios extends AppCompatActivity {


    private Button btnConectar;
    private ListView lvUsuarios;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_usuarios);

        btnConectar = findViewById(R.id.btnConectar);
        lvUsuarios = findViewById(R.id.lista_usuarios);
        btnConectar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Conectar();


            }


        });

    }
        public void Conectar(){

            DataMainActivity data = new DataMainActivity(lista_usuarios, this);
            data.ListarUsuarios();
        }
    }
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listado_usuarios);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });





    }

     */
