package com.majada.jhona.practica4_3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ConsultarDescripcion extends AppCompatActivity {
    private EditText codigo, descripcion, precio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_descripcion);
        codigo=(EditText) findViewById(R.id.et_codigo_consultarD);
        descripcion = (EditText)findViewById(R.id.et_descrip_consultarD);
        precio = (EditText) findViewById(R.id.et_precio_consultarD);
    }
    public void consultapordescripcion(View v) {
        AdminSQLite admin = new AdminSQLite(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String descri = descripcion.getText().toString();
        Cursor fila = bd.rawQuery(
                "select codigo,precio from articulos where descripcion='" + descri +"'", null);
        if (fila.moveToFirst()) {
             codigo.setText(fila.getString(0));
             precio.setText(fila.getString(1));
        } else
            Toast.makeText(this, "No existe un artículo con dicha descripción",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }

    public void salir(View v){
        finish();
    }
}
