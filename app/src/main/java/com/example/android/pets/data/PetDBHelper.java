package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import  com.example.android.pets.data.PetsContract.PetEntry;

/**
 * Created by DELL on 26-07-2017.
 */


public class PetDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="shelter.db";
    public static final int DATABASE_VERSION=1;
    public static final String LOG_TAG = PetDBHelper.class.getSimpleName();
    String SQL_CREATE_PETS_TABLE;
    Context context;

    public PetDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {



      //string that contains sql statement

//        CREATE TABLE tablename ( _id INTEFETR AUTO INCREMENT , name TEXT, breed TEXT, gender INTEGER,weight INTEGER);


        SQL_CREATE_PETS_TABLE =  "CREATE TABLE " + PetEntry.TABLE_NAME + " ("
                + PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, "
                + PetEntry.COLUMN_PET_BREED + " TEXT, "
                + PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL, "
                + PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";



//        String SQL_CRETET_PETS_TABLE="CREATE TABLE" + PetEntry.TABLE_NAME +
//                "(" + PetEntry._ID  + "INTEGER PRIMARY KEY AUTOINCREMENT,"
//                + PetEntry.COLUMN_PET_NAME + "TEXT NOT NULL,"
//        + PetEntry.COLUMN_PET_BREED + "TEXT,"
//        + PetEntry.COLUMN_PET_GENDER + "INTEGEGR NOT NULL,"
//        + PetEntry.COLUMN_PET_WEIGHT + "INTEGER NOT NULL DEFAULT 0" + ");";


    //EXECUTE SQL STATEMENET
        db.execSQL(SQL_CREATE_PETS_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
