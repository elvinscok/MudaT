package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.Entity.Anuncio;
import com.itla.mudat.Entity.Categoria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 11/28/2017.
 */

public class CategoriaDbo {

    public  DbConnection connection;

    public CategoriaDbo(Context context) { connection = new DbConnection(context);}

    public void crear( Categoria categoria) {

        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("descripcion", categoria.getDescripcion());

        db.insert("categoria", null, cv);
        db.close();
    }

    public List<Categoria> buscar(){
        List<Categoria> categorias = new ArrayList<>();

        SQLiteDatabase db = connection.getWritableDatabase();

        String columnas[] = new String[]{"id", "descripcion" };

        Cursor cursor = db.query("categoria", columnas, null, null, null, null, null );

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            Categoria c = new Categoria();
            c.setId(cursor.getInt(cursor.getColumnIndex("id")));
            c.setDescripcion(cursor.getString(cursor.getColumnIndex("descripcion")));


            cursor.moveToNext();
            categorias.add(c);
        }
        cursor.close();
        db.close();
        return categorias;
    }
}
