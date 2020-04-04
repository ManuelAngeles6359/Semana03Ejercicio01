package com.example.semana03ejercicio01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaActividad extends AppCompatActivity {

    private EditText txtNombre, txtCorreo, txtPassword;
    private CheckBox chkTeatro, chkCine, chkCenar;
    private RadioButton rbtMasculino, rbtFemenino;
    private SeekBar sbEntrada;
    private TextView txtEntrada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

        chkCine = (CheckBox) findViewById(R.id.chkCine);
        chkTeatro = (CheckBox) findViewById(R.id.chkTeatro);
        chkCenar = (CheckBox) findViewById(R.id.chkCenar);

        rbtMasculino = (RadioButton) findViewById(R.id.rbtMasculino);
        rbtFemenino = (RadioButton) findViewById(R.id.rbtFemenino);

        sbEntrada = (SeekBar) findViewById(R.id.sbEntradas);
        txtEntrada = (TextView) findViewById(R.id.lblEntradas);

        sbEntrada.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtEntrada.setText(progress + "Entradas");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        }

    }


    public void eventoAnterior(View view){
        Intent anterior = new Intent(this,MainActivity.class);
        startActivity(anterior);

    }

    private boolean validarCorreo(){
        String correo = txtCorreo.getText().toString();

        if(correo.isEmpty())
        {
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(correo).matches()){
            txtCorreo.setError("Correo incorrecto.");
            return false;
        }else{
            txtCorreo.setError(null);
            return true;
        }


    }


    public void eventoEnviar(View view){

        String nombre = txtNombre.getText().toString();
        String correo = txtCorreo.getText().toString();
        String password = txtPassword.getText().toString();

        String resultado ="";

        if(nombre.length()==0){
            resultado = "Falta nombre.";
        }

        if(!validarCorreo()){
            resultado = resultado + "Observación en correo.";
        }

        if(password.length()==0){
            resultado = resultado + "Falta password.";
        }

        if(resultado.length()==0){
            resultado = "Información enviada.";
        }


        Toast.makeText(this,resultado,Toast.LENGTH_LONG).show();


    }

    public void EnviarEncuesta(View view){

        String resultado ="";

        if(chkTeatro.isChecked())
        {
            resultado  = "Se selecciono teatro." + "\n";
        }

        if(chkCine.isChecked())
        {
            resultado  = resultado + "Se selecciono cine." + "\n";
        }

        if(chkCenar.isChecked())
        {
            resultado  = resultado + "Se selecciono cenar." + "\n";
        }

        if(rbtMasculino.isChecked())
        {
            resultado  = resultado + "Se selecciono masculino." + "\n";
        }else if(rbtFemenino.isChecked()){
            resultado  = resultado + "Se selecciono femenino." + "\n";
        }

        Toast.makeText(this,resultado,Toast.LENGTH_LONG).show();

    }


}
