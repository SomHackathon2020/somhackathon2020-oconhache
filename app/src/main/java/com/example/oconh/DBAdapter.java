package com.example.oconh;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Simple notes database access helper class. Defines the basic CRUD operations
 * for the notepad example, and gives the ability to list all notes as well as
 * retrieve or modify a specific note.
 */
public class DBAdapter {

    public static abstract class User implements BaseColumns {
        public static final String KEY_ID = "_id";
        public static final String KEY_NAME = "name";
        public static final String KEY_PASSWORD = "password";
        public static final String KEY_AGE = "age";
        public static final String KEY_EDUCATION = "education";
        public static final String KEY_PHONE = "phone";
        public static final String KEY_MAIL = "mail";

        private static final String TABLE_NAME = "users";

        private static final String CREATE =
                "CREATE TABLE " + TABLE_NAME + "( " +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + KEY_NAME + " TEXT NOT NULL,"
                        + KEY_PASSWORD + "TEXT NOT NULL,"
                        + KEY_AGE + "INT NOT NULL,"
                        + KEY_EDUCATION + "TEXT NOT NULL,"
                        + KEY_PHONE + "INT NOT NULL,"
                        + KEY_MAIL + "TEXT NOT NULL UNIQUE" +
                        ")";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

        public static final String GET_COUNT = "SELECT count(*) FROM " + TABLE_NAME + ";";
    }

    private static DBAdapter instance = null;

    private static final String TAG = "UserDbAdapter";
    private DatabaseHelper mDbHelper = null;
    private SQLiteDatabase mDb;

    private static final String DATABASE_NAME = "data";
    private static final int DATABASE_VERSION = 4;

    private final Context mCtx;

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(User.CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL(User.DELETE_TABLE);
            onCreate(db);
        }
    }

    //implements the abstract factory pattern
    public static DBAdapter getInstance(Context ctx) {
        if (instance == null) {
            instance = new DBAdapter(ctx);
        }
        return instance;
    }

    /**
     * Constructor - takes the context to allow the database to be
     * opened/created
     *
     * @param ctx the Context within which to work
     */
    private DBAdapter(Context ctx) {
        this.mCtx = ctx;
        mDbHelper = null;
    }

    /**
     * Open the notes database. If it cannot be opened, try to create a new
     * instance of the database. If it cannot be created, throw an exception to
     * signal the failure
     *
     * @return this (self reference, allowing this to be chained in an
     * initialization call)
     * @throws SQLException if the database could be neither opened or created
     */
    public DBAdapter open() throws SQLException {
        if (mDbHelper == null) {
            mDbHelper = new DatabaseHelper(mCtx);
            mDb = mDbHelper.getWritableDatabase();
        }
        return this;
    }

    public void close() {
        mDbHelper.close();
        mDbHelper = null;
    }

    public void upgrade() {
        mDbHelper.onUpgrade(mDb, 1, 2);
    }


    public long createUser(com.example.oconh.User current) {
        ContentValues initialValues = new ContentValues();

        initialValues.put(User.KEY_NAME, current.getName());
        initialValues.put(User.KEY_PASSWORD, current.getPassword());
        initialValues.put(User.KEY_AGE, current.getAge());
        initialValues.put(User.KEY_EDUCATION, current.getEducation());
        initialValues.put(User.KEY_PHONE, current.getPhone());
        initialValues.put(User.KEY_MAIL, current.getMail());

        return mDb.insert(User.TABLE_NAME, null, initialValues);
    }

    /**
     * Delete the note with the given rowId
     *
     * @param mail id of note to delete
     * @return true if deleted, false otherwise
     */
    public boolean deleteUser(String mail) {

        return mDb.delete(User.TABLE_NAME, User.KEY_MAIL + "=" + mail, null) > 0;
    }

   public Cursor getUser(com.example.oconh.User user){

       String[] whereArgs = new String[] {
               user.getMail()
       };

       String queryString = "SELECT * FROM users WHERE mail = ?";

       return  mDb.rawQuery(queryString, whereArgs);
   }


}

