package com.example.oconh;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DeveloperuDB extends SQLiteOpenHelper {

    private static final String NOMBRE_BD = "developers.bd";
    private static final int VERSION_BD = 12;
    private static final String TABLA_USUARIO = "CREATE TABLE users(" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Name TEXT," +
            "PASSWORD TEXT," +
            " AGE TEXT, " +
            "EDUCATION TEXT," +
            "PHONE INT," +
            " MAIL TEXT)";

    public DeveloperuDB (Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLA_USUARIO);
        db.execSQL(TABLA_USUARIO);
    }

    public void addUsuario(User user){
        SQLiteDatabase bd = getWritableDatabase();
        if(bd!=null){
            bd.execSQL("DROP TABLE users");
            bd.execSQL(TABLA_USUARIO);
            bd.execSQL("INSERT INTO users VALUES ("+user.getName()+","+user.getPassword()+","+user.getAge()+","+user.getEducation()+","+user.getPhone()+","+user.getMail()+","+user.getMail()+")");
            bd.close();
        }
    }

    public void fetchUsers(){
        SQLiteDatabase bd = getWritableDatabase();
        if(bd!=null){
            bd.execSQL("SELECT * FROM users");
            bd.close();
        }
    }




}
