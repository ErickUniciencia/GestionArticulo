package com.example.gestionarticulo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2,et3;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);

        listView = findViewById(R.id.lv1);



    }

    public void grabar(View v){
        AdminSqliteOpenHelper admin =  new AdminSqliteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        String descri = et2.getText().toString();
        String pre = et3.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        registro.put("descripcion", descri);
        registro.put("precio", pre);

        db.insert("articulos", null, registro);
        db.close();

        et1.setText("");
        et2.setText("");
        et3.setText("");

        Toast.makeText(this, "Se cargaron los datos del articulo", Toast.LENGTH_SHORT).show();
    }

    public void getArticulos(View v){
        AdminSqliteOpenHelper admin =  new AdminSqliteOpenHelper(this, "administracion", null, 1);


        List<HashMap<String, String>> articulos = admin.obtenerArticulos();
        ArrayAdapter<HashMap<String, String>> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, articulos);
        listView.setAdapter(adapter);
    }
}