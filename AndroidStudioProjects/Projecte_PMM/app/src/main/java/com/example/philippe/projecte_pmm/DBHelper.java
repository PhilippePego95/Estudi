package com.example.philippe.projecte_pmm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DBHelper  extends SQLiteOpenHelper {
    // public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
    //      super(context, name, factory, version);
    //  }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //Tabla usuaris
    String usuaris= "CREATE TABLE USERS(usuari text primary key,nom text,pwd text,punts integer,root text,clase text)";
    String insertAdmin="INSERT INTO USERS  values('phil','philippe','qwerty',0,'false','2DAM')";
    //Tabla classes
    String clases= "CREATE TABLE CLASS(clase text  primary key,pwd text,nPro text)";
    String insertClases="INSERT INTO CLASS values('2Dam','admin','Jonh')";

    String joc= "CREATE TABLE GAME(codigo integer primary key autoincrement,inf text,ps text,part text,esp text)";
    String insertJoc="INSERT INTO GAME values(1,'BET','BET','BET','APOSTAR')";

    //nom,punts,root
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(usuaris);
        db.execSQL(insertAdmin);

        db.execSQL(clases);
        db.execSQL(insertClases);


        db.execSQL(joc);
        db.execSQL(insertJoc);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
        // db.execSQL("insert into usuarios values('admin','admin')");
    }
}
