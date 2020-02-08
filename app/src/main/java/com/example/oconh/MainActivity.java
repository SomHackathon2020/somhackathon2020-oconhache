package com.example.oconh;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private UserService user_service = new UserService();
    private EditText user_name;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private View.OnClickListener loginListener = new View.OnClickListener() {
        public void onClick(View v) {
           try{
               user_service.register(user_name.getText().toString(),password.getText().toString());
           }catch(Exception e){
               e.getMessage();
           }

        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }



    //METODOS BASE DE DATOS

    public void writeSQLite(User user) {

        ContentValues contentValues = new ContentValues();
       // contentValues.put(MiBBDD.EntradaBBDD.COLUMNA1, user.getName());
       // contentValues.put(MiBBDD.EntradaBBDD.COLUMNA2, user.getPassword());

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
