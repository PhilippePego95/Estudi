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
    String usuaris= "create table usuarios(codigo integer primary key autoincrement,usuario text,contrasena text)";
    String insertAdmin="insert into usuarios values(1,'admin','admin')";
    //Tabla classes
    String clases= "create table clases(codigo integer primary key autoincrement,clase text,pwd text,nPro text)";
    String insertClases="insert into clases values(2,'2Dam','admin','Jonh')";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(usuaris);
        db.execSQL(insertAdmin);

        db.execSQL(clases);
        db.execSQL(insertClases);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("DROP TABLE IF EXISTS clases");

        db.execSQL(usuaris);
        db.execSQL(insertAdmin);

        db.execSQL(clases);
        db.execSQL(insertClases);
       // db.execSQL("insert into usuarios values('admin','admin')");
    }
}
