package com.itla.mudat.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Usuario on 11/25/2017.
 */

public class DbConnection extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "mudat.db";
    public static String LOG_T = "DbConnection";


    public DbConnection(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SqlHelperSchema.USUARIO_TABLE);
        db.execSQL(SqlHelperSchema.ANUNCIO_TABLE);
        db.execSQL(SqlHelperSchema.CATEGORIA_TABLE);
        insertdefault(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private void insertdefault(SQLiteDatabase sd)
    {
        try
        {
            sd.execSQL("insert or replace into Categoria (id,descripcion) values(1,'Apartamento');");
            sd.execSQL("insert or replace into Categoria (id,descripcion) values(2,'Casa');");
            sd.execSQL("insert or replace into Categoria (id,descripcion) values(3,'PenHouse');");
            sd.execSQL("INSERT or replace INTO Usuario (id,nombre,tipoUsuario,identificacion,email,telefono,clave,estatus) values(1,'massiel',1,'40221112085','Massiel@gmail.com','809-873-9895','1234',1);");


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
