package com.example.gestionarticulo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.Nullable;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdminSqliteOpenHelper extends SQLiteOpenHelper {


    public AdminSqliteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS articulos(codigo int primary key, descripcion text, precio real)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public List<HashMap<String, String>> obtenerArticulos() {
        List<HashMap<String, String>> articulos = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT codigo, descripcion, precio FROM articulos", null);


        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String codigo = cursor.getString(cursor.getColumnIndex("codigo"));
                    String descripcion = cursor.getString(cursor.getColumnIndex("descripcion"));
                    String precio = cursor.getString(cursor.getColumnIndex("precio"));

                    HashMap<String, String> articulo = new HashMap<>();
                    articulo.put("codigo", codigo);
                    articulo.put("descripcion", descripcion);
                    articulo.put("precio", precio);

                    articulos.add(articulo);
                } while (cursor.moveToNext());
            }
        }


        cursor.close();
        return articulos;
    }
}
