package com.example.philippe.projecte_pmm;
//http://www.hermosaprogramacion.com/2016/01/base-de-datos-sqlite-en-android-con-multiples-tablas/
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

/**
 * Created by philippe on 24/01/17.
 */

public class BaseDades extends SQLiteOpenHelper {
    private static final String NomBaseDades="estudi";
    private static final int Version = 1;
    private final Context contexto;

    interface  Tablas {
        String Usuaris= "Usuaris";
        String Clases = "Clases";
        String Joc = "Joc";
    }
    public BaseDades(Context contexto){
        super(contexto,NomBaseDades,null,Version);
        this.contexto=contexto;
    }
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                db.setForeignKeyConstraintsEnabled(true);
            } else {
                db.execSQL("PRAGMA foreign_keys=ON");
            }
        }
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
