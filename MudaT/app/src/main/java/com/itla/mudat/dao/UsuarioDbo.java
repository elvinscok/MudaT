package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.Entity.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 11/29/2017.
 */

public class UsuarioDbo {

    private DbConnection con;

    public UsuarioDbo(Context context) {
        con = new DbConnection(context);
    }

    public void crear (Usuario usuario) {

        SQLiteDatabase db = con.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nombre",usuario.getNombre());
        cv.put("tipoUsuario", String.valueOf(usuario.getTipoUsuario()));
        cv.put("identificacion", usuario.getIdentificacion());
        cv.put("telefono", usuario.getTelefono());
        cv.put("email", usuario.getEmail());
        cv.put("clave", usuario.getClave());
        cv.put("estatus", usuario.getEstatus());

        db.insert("usuario", null, cv);
        db.close();
    }
    public List<Usuario> buscar(){
        List<Usuario> usuarios = new ArrayList<>();

        SQLiteDatabase db = con.getWritableDatabase();

        String columnas[] = new String[]{"id", "nombre", "email", "identificacion", "telefono" };

        Cursor cursor = db.query("usuario", columnas, null, null, null, null, null );

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            Usuario u = new Usuario();
            u.setId(cursor.getInt(cursor.getColumnIndex("id")));
            u.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            // u.setTipoUsuario(TipoDeUsuario.valueOf(cursor.getString(cursor.getColumnIndex("tipoUsuario"))));
            u.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            u.setIdentificacion(cursor.getString(cursor.getColumnIndex("identificacion")));
            u.setTelefono(cursor.getString(cursor.getColumnIndex("telefono")));

            cursor.moveToNext();
            usuarios.add(u);
        }
        cursor.close();
        db.close();
        return usuarios;
    }

    public void Editar(Usuario usuario)
    {
        SQLiteDatabase db = con.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nombre", usuario.getNombre());
        cv.put("identificacion", usuario.getIdentificacion());
        cv.put("telefono", usuario.getTelefono());
        cv.put("clave", usuario.getClave());
        cv.put("estado", usuario.getEstatus());
        cv.put("email", usuario.getEmail());

        db.update("usuario", cv, "id = ?", new String[] {" " + usuario.getId()});
        db.close();
    }
}
