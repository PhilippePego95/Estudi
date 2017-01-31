package com.example.philippe.basedades;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by philippe on 29/01/17.
 */

public class BaseDadesCotxe extends SQLiteOpenHelper {
    public BaseDadesCotxe(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //Tabla usuaris
    String usuaris= "CREATE TABLE USER(usuari text primary key,nom text,pwd text)";
    String insertAdmin="INSERT INTO USER  values('phil','philippe','qwerty')";
    //Tabla classes
    String marca= "CREATE TABLE MARCA(model text primary key)";
    String insertmarca="INSERT INTO MARCA values('Ford')";

    String cotxe= "CREATE TABLE COTXE(marca text ,model text primary key,preu integer,FOREIGN KEY (model) REFERENCES COTXE(marca))";
    String insertcotxe="INSERT INTO COTXE values('Ford','Fiesta','70')";

    String factu="CREATE TABLE FACTURA (ID INTEGER PRIMARY KEY AUTOINCREMENT, usuari text, dades text, preutotal text,FOREIGN KEY (usuari) REFERENCES USER(usuari))";
    String insertfactu="INSERT INTO FACTURA values(1,'phil','Ford Fiesta 70','200')";
    // /nom,punts,root
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(usuaris);
        db.execSQL(insertAdmin);

        db.execSQL(marca);
        db.execSQL(insertmarca);


        db.execSQL(cotxe);
        db.execSQL(insertcotxe);

        db.execSQL(factu);
        db.execSQL(insertfactu);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
        // db.execSQL("insert into usuarios values('admin','admin')");
    }
}



