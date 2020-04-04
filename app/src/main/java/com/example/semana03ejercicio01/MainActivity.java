package com.example.semana03ejercicio01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen = (ImageView) findViewById(R.id.Img_usuario);

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Hice clic en la imagen.",Toast.LENGTH_LONG).show();
            }
        });

    }


    public void eventoBoton(View view){
        Toast.makeText(this,"Hice clic en el botón grabar.",Toast.LENGTH_LONG).show();
    }

    public void eventoBotonCasa(View view){
        Toast.makeText(this,"Clic en el botón imagen.",Toast.LENGTH_LONG).show();
    }

    public void eventoSiguiente(View view){
        Intent siguiente = new Intent(this, SegundaActividad.class);
        startActivity(siguiente);
    }

}
