# Ud3_Ejemplo11
_Ejemplo 11 de la Unidad 3._ Paso de objetos entre Actividades.

Vamos a enviar objetos desde una Actividad a otra usando _Intets_ explícitos con datos extras. Para ello crearemos una clase Persona, 
rellenaremos sus datos y los enviaremos para que los muestre otra Atividad.

## _Persona.java_
Creamos la clase Persona con solo dos atributos. Ésta tiene que implementar la interfaz _Serializable_ de tal forma que pueda ser 
convertida y enviada a través del _Intent_. Como podéis ver, no es necesario implementar ningún método asociado.
```
public class Persona implements Serializable {
    private String nombre;
    private String apellido;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

}
```
## _activity_main.xml_ y _actividad2.xml_
Creamos los layout de las dos Actividades:

_activity_main.xml_:
```
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/textNombre"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/nombre"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.236"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.358" />

    <EditText
        android:id="@+id/editTextNombre"
        android:layout_width="220dp"
        android:layout_height="wrap_content"
        android:hint="@string/nombre"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.4"
        app:layout_constraintStart_toEndOf="@+id/textNombre"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.354" />

    <TextView
        android:id="@+id/textApellido"
        android:layout_width="56dp"
        android:layout_height="24dp"
        android:text="@string/apellido"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="@+id/textNombre"
        app:layout_constraintStart_toStartOf="@+id/textNombre"
        app:layout_constraintTop_toBottomOf="@+id/textNombre"
        app:layout_constraintVertical_bias="0.22000003" />

    <EditText
        android:id="@+id/editTextApellido"
        android:layout_width="220dp"
        android:layout_height="wrap_content"
        android:hint="@string/apellido"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="@+id/editTextNombre"
        app:layout_constraintStart_toStartOf="@+id/editTextNombre"
        app:layout_constraintTop_toBottomOf="@+id/editTextNombre"
        app:layout_constraintVertical_bias="0.17000002" />

    <Button
        android:id="@+id/boton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/enviar"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editTextApellido" />
</androidx.constraintlayout.widget.ConstraintLayout>
```
_actividad2.xml_:
```
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Actividad2">

    <TextView
        android:id="@+id/nombreAct2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.36"
        tools:text="@string/nombre" />

    <TextView
        android:id="@+id/apellidoAct2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/nombreAct2"
        app:layout_constraintVertical_bias="0.26"
        tools:text="@string/apellido" />

</androidx.constraintlayout.widget.ConstraintLayout>
```
## _MainActivity.java_
En el fichero _MainActivity.java_ creamos el objeto de la clase Bundle y le asignamos el par (clave, valor) siendo la 
clave _Persona_ y el valor el obejto _persona_, añadimos los datos extra que el _Intent_ pasará y lo enviamos.
```
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

```
## _Actividad2.java_
Por último, Actividad2 recogerá el objeto Bundle y obtendrá el valor a partir de la clase _Persona_ y lo mostrará en los TextViews.
```
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
```
