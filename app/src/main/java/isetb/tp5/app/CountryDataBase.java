package isetb.tp5.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CountryDataBase extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "country_db";
    public static final String TCountry = "country";
    public static final String CID = "id";
    public static final String CNAME = "name";
    public static final String CIMAGE = "image";

    public static final String CREATE_COUNTRY_TABLE = "CREATE TABLE " + TCountry + "("
            + CID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CNAME + " VARCHAR(20) NOT NULL, "
            + CIMAGE + " BLOB)";
    private SQLiteDatabase db;
    public CountryDataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public CountryDataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public CountryDataBase(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addcountry(Country c){
        ContentValues values=new ContentValues();
        values.put(CNAME,c.getName());
        values.put(CIMAGE,c.getImage());
        long x=db.insert(TCountry,null,values);
        return x!=-1;

    }
}
