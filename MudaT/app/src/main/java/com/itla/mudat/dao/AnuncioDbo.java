package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.Entity.Anuncio;
import com.itla.mudat.Entity.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 11/28/2017.
 */

public class AnuncioDbo {

    public  DbConnection connection;

    public AnuncioDbo(Context context) { connection = new DbConnection(context);}

    public void crear( Anuncio anuncio){

        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("fecha", String.valueOf(anuncio.getFecha()));
        cv.put("condicion", anuncio.getCondicion());
        cv.put("precio", anuncio.getPrecio());
        cv.put("titulo", anuncio.getTitulo());
        cv.put("ubicacion", anuncio.getUbicacion());
        cv.put("detalle", anuncio.getDetalle());
        cv.put("idCategoria", String.valueOf(anuncio.getCategoria()));
        cv.put("idUsuario", String.valueOf(anuncio.getUsuario()));

        db.insert("anuncio", null, cv);
        db.close();
    }

    public List<Anuncio> buscar(){
        List<Anuncio> anuncios = new ArrayList<>();

        SQLiteDatabase db = connection.getWritableDatabase();

        String columnas[] = new String[]{"id", "fecha", "condicion", "precio", "titulo", "ubicacion", "detalle" };

        Cursor cursor = db.query("anuncio", columnas, null, null, null, null, null );

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            Anuncio a = new Anuncio();
            a.setId(cursor.getInt(cursor.getColumnIndex("id")));
           // a.setFecha(cursor.getString(cursor.getColumnIndex("fecha")));
            a.setCondicion(cursor.getString(cursor.getColumnIndex("condicion")));
           // a.setPrecio(cursor.getString(cursor.getColumnIndex("precio")));
            a.setTitulo(cursor.getString(cursor.getColumnIndex("titulo")));
            a.setUbicacion(cursor.getString(cursor.getColumnIndex("ubicacion")));
            a.setDetalle(cursor.getString(cursor.getColumnIndex("detalle")));

            cursor.moveToNext();
            anuncios.add(a);
        }
        cursor.close();
        db.close();
        return anuncios;
    }
}
