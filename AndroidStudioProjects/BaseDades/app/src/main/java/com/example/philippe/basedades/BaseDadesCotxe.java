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

    String cotxe= "CREATE TABLE COTXE(marca text ,model text primary key,preu integer)";
    String insertcotxe="INSERT INTO COTXE values('Ford','Fiesta','70')";

    //nom,punts,root
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(usuaris);
        db.execSQL(insertAdmin);

        db.execSQL(marca);
        db.execSQL(insertmarca);


        db.execSQL(cotxe);
        db.execSQL(insertcotxe);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
        // db.execSQL("insert into usuarios values('admin','admin')");
    }
}



