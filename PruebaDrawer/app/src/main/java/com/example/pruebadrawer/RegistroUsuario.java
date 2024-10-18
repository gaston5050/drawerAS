package com.example.pruebadrawer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.BreakIterator;

public class RegistroUsuario extends AppCompatActivity {

    TextView tNombre;
    TextView tEmail;
    TextView tPass;
    TextView tConfirmaPass;
    // Button btnRegistrarse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro_usuario);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tNombre = findViewById(R.id.txtNombre);
        tEmail = findViewById(R.id.txtEmail);
        tPass = findViewById(R.id.txtPass);
        tConfirmaPass = findViewById(R.id.txtConfirmaPass);
        //btnRegistrarse = findViewById(R.id.btnRegistrarse);

    }


    public void passwordCoincide() {


        if (!tPass.getText().toString().equals(tConfirmaPass.getText().toString())) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }

    }

    public void registrarse(View view) {

        passwordCoincide();
        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
    }

}