package com.example.ud3_ejemplo11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Actividad2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad2);


        if (getIntent() != null && getIntent().hasExtra(Intent.EXTRA_TEXT)) {

            // Recogemos el objeto bundle y obtenemos el objeto persona usando la clave "Persona".
            Bundle bundle = getIntent().getBundleExtra(Intent.EXTRA_TEXT);

            Persona persona = (Persona) bundle.getSerializable("Persona");

            // Buscamos y rellenamos los TextView para mostrar los datos.
            TextView nombre = findViewById(R.id.nombreAct2);
            TextView apellido = findViewById(R.id.apellidoAct2);

            nombre.setText(persona.getNombre());
            apellido.setText(persona.getApellido());
        }
    }
}
