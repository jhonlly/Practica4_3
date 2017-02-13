package com.majada.jhona.practica4_3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ConsultaCodigo extends AppCompatActivity {
    private EditText codigo, descripcion, precio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_codigo);
        codigo=(EditText) findViewById(R.id.et_codigo_consultaC);
        descripcion = (EditText)findViewById(R.id.et_descrip_consultaC);
        precio = (EditText) findViewById(R.id.et_precio_consultaC);
    }
    public void consultaporcodigo(View v) {
        AdminSQLite admin = new AdminSQLite(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = codigo.getText().toString();
        Cursor fila = bd.rawQuery(
                "select descripcion,precio from articulos where codigo=" + cod, null);
        if (fila.moveToFirst()) {
            descripcion.setText(fila.getString(0));
            precio.setText(fila.getString(1));
        } else
            Toast.makeText(this, "No existe un artículo con dicho código",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }

    public void salir(View v){
        finish();
    }

}
