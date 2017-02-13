package com.majada.jhona.practica4_3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class VerRegistros extends AppCompatActivity {
    private ListView listaR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_registros);
        listaR =(ListView) findViewById(R.id.listado_registros);
        AdminSQLite admin = new AdminSQLite(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery("select codigo, descripcion,precio from articulos ", null);

        ArrayList registros = new ArrayList();
        if (fila.moveToFirst()) {
            do {
                registros.add("Codigo:"+fila.getString(0) + " Descripción: " +fila.getString(1) + " Precio: "+
                        fila.getString(2));
            } while (fila.moveToNext());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, registros);
        listaR.setAdapter(adapter);
        bd.close();
    }
    public void salir(View v){
        finish();
    }

}
