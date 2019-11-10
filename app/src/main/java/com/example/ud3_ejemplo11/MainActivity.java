package com.example.ud3_ejemplo11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText nombre = findViewById(R.id.editTextNombre);
                EditText apellido = findViewById(R.id.editTextApellido);

                // Creamos el objeto de la clase Persona.
                Persona persona = new Persona(nombre.getText().toString(), apellido.getText().toString());

                // Creamos el objeto de la clase Bundle y le asignamos el par (clave, valor).
                Bundle bundle = new Bundle();
                bundle.putSerializable("Persona", persona);

                // Creamos el Intent, le añadimos el objeto bundle y lo enviamos.
                Intent intent = new Intent(MainActivity.this, Actividad2.class);
                intent.putExtra(Intent.EXTRA_TEXT, bundle);

                startActivity(intent);
            }
        });
    }
}
