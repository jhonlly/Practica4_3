package com.majada.jhona.practica4_3;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BajaCodigo extends AppCompatActivity {
    private EditText codigo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baja_codigo);
        codigo=(EditText) findViewById(R.id.et_codigo_bajaporcodigo);
    }
    public void bajaporcodigo(View v) {
        AdminSQLite admin = new AdminSQLite(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod= codigo.getText().toString();
        int cant = bd.delete("articulos", "codigo=" + cod, null);
        bd.close();
        codigo.setText("");

        if (cant == 1)
            Toast.makeText(this, "Se borró el artículo con código: "+ cod,
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe un artículo con dicho código",
                    Toast.LENGTH_SHORT).show();
    }
    public void salir(View v){
        finish();
    }
}
