package com.example.pruebadrawer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import ConexionBD.DataMainActivity;

public class listadoUsuarios extends AppCompatActivity {


    private Button btnConectar;
    private ListView lvUsuarios;
    private TextView txtMensa;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_usuarios);

        btnConectar = findViewById(R.id.btnConectar);
        lvUsuarios = findViewById(R.id.lvusuarios);
        txtMensa = findViewById(R.id.txtMensaje);

        btnConectar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Conectar();


            }


        });

    }
        public void Conectar(){

            DataMainActivity data = new DataMainActivity(lvUsuarios, this);
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
