package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.Entity.Anuncio;
import com.itla.mudat.Entity.Categoria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<Map<String,String>> Llenarspinner(){
        List<Map<String,String>>categorias = new ArrayList<Map<String,String>>();

        SQLiteDatabase db = connection.getWritableDatabase();

        String columnas[] = new String[]{"id", "descripcion" };

        Cursor cursor = db.query("categoria", columnas, null, null, null, null, null );

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            Map v=new HashMap();
            v.put("id",cursor.getInt(cursor.getColumnIndex("id")));
            v.put("descripcion",cursor.getString(cursor.getColumnIndex("descripcion")));
            categorias.add(v);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return categorias;
    }
}
