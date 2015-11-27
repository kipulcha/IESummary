package com.focustoweb.bishnu.myfirstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Bishnu on 11/26/2015.
 */

public class IESummary extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String CATEGORY_TABLE_NAME = "category";
    private static final String CATKEY_ID = "Id";
    private static final String CATKEY_TITLE = "Title";
    private static final String CATKEY_PARENTID = "ParentId";
    private static final String CATKEY_STATUS = "Status";
    private static final String CATKEY_CREATEDDATE = "CreatedDate";
    private static final String CATKEY_MODIFIEDDATE = "ModifiedDate";
    private static final String CATKEY_DESCRIPTION = "Description";
    private static final String DICTIONARY_TABLE_CREATE =
            "CREATE TABLE " + CATEGORY_TABLE_NAME + " ("+CATKEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT" +
                    CATKEY_TITLE + " TEXT, " +
                    CATKEY_DESCRIPTION + " TEXT, "+
                    CATKEY_PARENTID + "INTEGER, " +
                    CATKEY_STATUS + "INTEGER, " +
                    CATKEY_CREATEDDATE + "DATE, "+
                    CATKEY_MODIFIEDDATE + "DATE" +
                    ");";
    private static final String DATABASE_NAME = "IESummary";

    IESummary(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DICTIONARY_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public  void CategoryAdd(String title, String description, int parentId){

        //try {
            ContentValues cv = new ContentValues();
            cv.put(CATKEY_TITLE, title);
            cv.put(CATKEY_DESCRIPTION, description);
            cv.put(CATKEY_PARENTID, parentId);
            cv.put(CATKEY_STATUS, 1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            cv.put(CATKEY_CREATEDDATE, sdf.format(new Date()));
            cv.put(CATKEY_MODIFIEDDATE, sdf.format(new Date()));
            getWritableDatabase().insert(CATEGORY_TABLE_NAME, null, cv);

    }


}