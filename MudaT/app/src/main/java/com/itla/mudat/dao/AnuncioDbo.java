package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.Entity.Anuncio;
import com.itla.mudat.Entity.Categoria;
import com.itla.mudat.Entity.Usuario;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 11/28/2017.
 */

public class AnuncioDbo {

    public  DbConnection connection;
    private static final SimpleDateFormat DF = new SimpleDateFormat("dd-MM-yyyy");

    public AnuncioDbo(Context context) { connection = new DbConnection(context);}


    public void crear( Anuncio anuncio){

        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("fecha", DF.format(anuncio.getFecha()));
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

        String columnas[] = new String[]{"id", "fecha", "condicion", "precio", "titulo", "ubicacion", "detalle" ,"categoria"};

        //Cursor cursor = db.query("anuncio", columnas, null, null, null, null, null );

        //Cursor cursor = db.rawQuery("SELECT a.*, u.nombre, c.descripcion FROM anuncio a, usuario u, categoria c WHERE a.idUsuario= u.id AND a.idCategoria= c.id",null);
        Cursor cursor = db.rawQuery("SELECT a.*,ifnull((SELECT usuario.nombre from usuario where usuario.id=a.idUsuario),'') nombre,ifnull((select categoria.descripcion from categoria where categoria.id=a.idCategoria),'') descripcion FROM anuncio a",null);
        //SELECT a.*,ifnull((SELECT nombre from usuario where id=a.id),'') nombre,ifnull((select descripcion from categoria where id=a.id),'') descripcion FROM anuncio a
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            Anuncio anuncio = new Anuncio();
            Usuario usuario= new Usuario();
            Categoria categoria = new Categoria();

            usuario.setId(cursor.getInt(cursor.getColumnIndex("idUsuario")));
            usuario.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            categoria.setDescripcion(cursor.getString(cursor.getColumnIndex("descripcion")));

            anuncio.setUsuario(cursor.getInt(cursor.getColumnIndex("idUsuario")));
            anuncio.setId(cursor.getInt(cursor.getColumnIndex("id")));
           // a.setFecha(cursor.getString(cursor.getColumnIndex("fecha")));
            anuncio.setCondicion(cursor.getString(cursor.getColumnIndex("condicion")));
            anuncio.setPrecio(cursor.getString(cursor.getColumnIndex("precio")));
            anuncio.setTitulo(cursor.getString(cursor.getColumnIndex("titulo")));
            anuncio.setUbicacion(cursor.getString(cursor.getColumnIndex("ubicacion")));
            anuncio.setDetalle(cursor.getString(cursor.getColumnIndex("detalle")));
            anuncio.setCategoria(cursor.getColumnIndex("Categoria"));

            cursor.moveToNext();
            anuncios.add(anuncio);
        }
        cursor.close();
        db.close();
        return anuncios;
    }


   /* public void actualizar (Anuncio usuario){

        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nombre",usuario.getNombre());
        //  cv.put("tipoUsuario", String.valueOf(usuario.getTipoUsuario()));
        cv.put("identificacion", usuario.getIdentificacion());
        cv.put("telefono", usuario.getTelefono());
        cv.put("email", usuario.getEmail());
        cv.put("clave", usuario.getClave());
        cv.put("estatus", usuario.getEstatus());

        db.update("usuario", cv, "id=?", new String[] {" " +  usuario.getId()} );
        // db.endTransaction();
        db.close();
    }*/
}
