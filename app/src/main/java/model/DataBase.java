package model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jambo on 15/02/17.
 */

public class DataBase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "base.sqlite";
    private static final int VERSION = 1;

    public DataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String request = "CREATE TABLE Magasins(" +
                " _id integer primary key autoincrement," +
                "name text not null," +
                "ville text not null," +
                "pays text not null);";
        db.execSQL(request);
        request = "CREATE TABLE Produits(" +
                "_id integer primary key autoincrement," +
                "categorie integer not null," +
                "nom text not null," +
                "code text not null);";
        db.execSQL(request);
        request = "CREATE TABLE Listes(" +
                " _id integer," +
                "id_produit integer," +
                "id_magasin integer," +
                "quantite float not null," +
                "achete float not null," +
                "FOREIGN KEY(id_produit) REFERENCES Produits(_id)," +
                "FOREIGN KEY(id_magasin) REFERENCES Magasins(_id)," +
                "PRIMARY KEY(_id,id_produit,id_magasin);";
        db.execSQL(request);
        request = "CREATE TABLE Vend(" +
                "id_produit integer," +
                "id_magasin integer," +
                "prix float not null," +
                "unité text not null," +
                "rayon text," +
                "promotion text," +
                "FOREIGN KEY(id_produit) REFERENCES Produits(_id)," +
                "FOREIGN KEY(id_magasin) REFERENCES Magasins(_id)," +
                "PRIMARY KEY(id_produit,id_magasin); ";
        db.execSQL(request);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
