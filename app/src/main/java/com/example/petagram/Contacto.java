package com.example.petagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.petagram.R;
import com.google.android.material.textfield.TextInputEditText;

public class Contacto extends AppCompatActivity {


    TextInputEditText Nombre;
    TextInputEditText Correo;
    TextInputEditText Mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Nombre = findViewById(R.id.Nombre);
        Correo = findViewById(R.id.Correo);
        Mensaje = findViewById(R.id.Mensaje);

    }

    public void EnviarMail(View view) {

        Nombre.getText();
        Correo.getText();
        Mensaje.getText();
    }
}