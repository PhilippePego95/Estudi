package com.example.philippe.loginapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by philippe on 11/01/17.
 */

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuarios (codigo integer primary key autoincrement,usuaio text, contrasenya text",null);
        db.execSQL("insert into usuarios value ('admin','admin')",null);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("CREATE TABLE usuarios (codigo integer primary key autoincrement,usuaio text, contrasenya text",null);
        db.execSQL("insert into usuarios value ('admin','admin')",null);

    }
}
