package com.majada.jhona.practica4_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void verRegistro(View v){
        Intent intent = new Intent(this, VerRegistros.class);
        startActivity(intent);
    }
    public void alta(View v) {
        Intent intent = new Intent(this, Alta.class);
        startActivity(intent);
    }
    public void consultaC(View v){
        Intent intent = new Intent(this, ConsultaCodigo.class);
        startActivity(intent);
    }
    public void consultaD(View v){
        Intent intent = new Intent(this, ConsultarDescripcion.class);
        startActivity(intent);
    }
    public void bajaCodigo(View v){
        Intent intent = new Intent(this, BajaCodigo.class);
        startActivity(intent);
    }
    public void modificar(View v){
        Intent intent = new Intent(this, Modificar.class);
        startActivity(intent);
    }
}
