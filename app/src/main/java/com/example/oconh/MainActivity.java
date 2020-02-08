package com.example.oconh;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private UserService user_service = new UserService();
    private EditText user_name;
    private EditText user_password;
    private Button singIn;
    private Button singup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        singIn = (Button) findViewById(R.id.singin);
        user_name = (EditText) findViewById(R.id.name);
        user_password = (EditText) findViewById(R.id.password);

        singIn.setOnClickListener( new View.OnClickListener(){
            public void onClick (View v){
                user_service.singIn(user_name.getText().toString(), user_password.getText().toString());
            }
        });


    }



    //METODOS BASE DE DATOS

    public void writeSQLite(User user) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(MiBBDD.EntradaBBDD.COLUMNA1, user.getName());
        contentValues.put(MiBBDD.EntradaBBDD.COLUMNA2, user.getPassword());

        MiBBDD_Helper dbHelper = new MiBBDD_Helper(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        sqLiteDatabase.insert(MiBBDD.EntradaBBDD.TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
    }

  //Posible ayuda para
/*
    public void searchSQLite(String columna, String valor) {
        MiBBDD_Helper dbHelper = new MiBBDD_Helper(getApplicationContext());


        // Query a SQLite
        Log.i("SQLite", "cercar_nom_bbdd");
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        users = new ArrayList<>();
        String[] columnas = {
                MiBBDD.EntradaBBDD.COLUMNA2,
                MiBBDD.EntradaBBDD.COLUMNA1,
                 };
        Cursor cursor = db.query( MiBBDD.EntradaBBDD.TABLE_NAME,
                columnas,
                columna + "=?",
                new String[]{valor},
                null,
                null,
                null);


        while ( cursor.moveToNext() ) {
            User users =  new User(
                    cursor.getString(cursor.getColumnIndex(
                            MiBBDD.EntradaBBDD.COLUMNA1)),
                    cursor.getString(cursor.getColumnIndex(MiBBDD.EntradaBBDD.COLUMNA1)),
                    cursor.getString(cursor.getColumnIndex(MiBBDD.EntradaBBDD.COLUMNA2));
            users.add(user);
        }
        db.close();
    }
*/
}
