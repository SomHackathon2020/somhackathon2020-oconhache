package com.example.oconh;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    private UserService user_service = new UserService();
    private EditText user_name;
    private EditText user_password;
    private Button singIn;
    private Button singUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Mostrar logo
        singUp=findViewById(R.id.singup);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        if(b==null) {
            Intent intent = new Intent(getApplicationContext(), Logo.class);
            startActivity(intent);
        }


        setContentView(R.layout.activity_main);
        singIn = (Button) findViewById(R.id.singin);
        singUp = (Button) findViewById(R.id.singup);
        user_name = (EditText) findViewById(R.id.name);
        user_password = (EditText) findViewById(R.id.password);

        singIn.setOnClickListener( new View.OnClickListener(){
            public void onClick (View v){
                try{
                    user_service.singIn(user_name.getText().toString(), user_password.getText().toString());
                    //Faltaria un intent aqui para cambiar de activity
                }catch(Exception e){
                    System.out.println('f');
                    //Credentials are not valid, show a message with it and try again
                }
            }
        });
        /*
        singUp.setOnClickListener( new View.OnClickListener(){
            public void onClick (View v){
                Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });
         */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
               System.out.println("Click first item");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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

  //Posible ayuda para busqueda,caldria trasladar la lista de usuarioa aqui
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
