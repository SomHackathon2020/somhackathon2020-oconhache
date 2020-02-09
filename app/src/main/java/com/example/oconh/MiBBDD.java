package com.example.oconh;

public class MiBBDD {

    static final String SQLCreate =
            "CREATE TABLE "+ EntradaBBDD.TABLE_NAME + " (" +
                    "_ID INTEGER PRIMARY KEY, " +
                    EntradaBBDD.COLUMNA1 + " TEXT, " +
                    EntradaBBDD.COLUMNA2 + " TEXT) ";

    static final String SQLUpgrade =
            "DROP TABLE IF EXISTS "+ EntradaBBDD.TABLE_NAME;

    private MiBBDD(){};

    public class EntradaBBDD {

        static final String TABLE_NAME = "USERS";
        static final String COLUMNA1 = "NOMBRE";
        static final String COLUMNA2 = "CONTRASEÑA";

    }
}
