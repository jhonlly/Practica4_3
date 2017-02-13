package com.majada.jhona.practica4_3;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Alta extends AppCompatActivity {
private Button  salir;
    private EditText codigo, descripcion, precio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);
        codigo=(EditText) findViewById(R.id.et1_codigo_modificar);
        descripcion = (EditText)findViewById(R.id.et_descrip_modificar);
        precio = (EditText) findViewById(R.id.et_precio_modificar);
        salir =(Button) findViewById(R.id.btn_salir_alta);

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void guardar(View v){
        AdminSQLite admin = new AdminSQLite(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("codigo", codigo.getText().toString());
        registro.put("descripcion", descripcion.getText().toString());
        registro.put("precio", precio.getText().toString());
        bd.insert("articulos", null, registro);
        codigo.setText("");
        descripcion.setText("");
        precio.setText("");
        Toast.makeText(this, "Se cargaron los datos del artículo",
                Toast.LENGTH_SHORT).show();
    }

}
