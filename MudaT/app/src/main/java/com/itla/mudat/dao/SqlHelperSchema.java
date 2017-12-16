package com.itla.mudat.dao;

/**
 * Created by Usuario on 11/25/2017.
 */

public class SqlHelperSchema {

    public static final  String USUARIO_TABLE = "CREATE TABLE   Usuario ( id INTEGER PRIMARY KEY AUTOINCREMENT  , nombre VARCHAR ( 60 ) NOT NULL, identificacion VARCHAR ( 30 ) NOT NULL UNIQUE, telefono VARCHAR ( 20 ) NOT NULL , email VARCHAR ( 50 ) NOT NULL , estatus BOOLEAN NOT NULL, clave  VARCHAR ( 50 ) NOT NULL,  tipoUsuario  INTEGER  ); ";

    public static final String ANUNCIO_TABLE = "CREATE TABLE Anuncio ( id	INTEGER PRIMARY KEY AUTOINCREMENT, fecha REAL NOT NULL, condicion TEXT NOT NULL, precio	DOUBLE NOT NULL, titulo	VARCHAR ( 50 ) NOT NULL ,ubicacion	VARCHAR ( 80 ) NOT NULL, detalle	TEXT NOT NULL, idCategoria	INTEGER NOT NULL, idUsuario	INTEGER NOT NULL); ";

    public static final String CATEGORIA_TABLE = " CREATE TABLE  Categoria ( id INTEGER  PRIMARY KEY AUTOINCREMENT, descripcion TEXT NOT NULL ); ";
}
