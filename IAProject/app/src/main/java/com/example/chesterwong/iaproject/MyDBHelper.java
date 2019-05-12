package com.example.chesterwong.iaproject;

import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


    public class MyDBHelper  extends SQLiteOpenHelper {
        private final static int _DBVersion = 1;
        private final static String _DBName = "SampleList.db";
        private final static String _TableName = "binRecord";

        public MyDBHelper(Context context) {
            super(context, _DBName, null, _DBVersion);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            final String SQL = "CREATE TABLE IF NOT EXISTS " + _TableName + "( " +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "_date VARCHAR(50), " +
            "_time TEXT," +
            "_color TEXT," +
             "_shape TEXT," +
              "_quantity TEXT," +
              "_exercise TEXT" +
            ");";
            db.execSQL(SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            final String SQL = "DROP TABLE " + _TableName;
            db.execSQL(SQL);
            onCreate(db);
        }
    }