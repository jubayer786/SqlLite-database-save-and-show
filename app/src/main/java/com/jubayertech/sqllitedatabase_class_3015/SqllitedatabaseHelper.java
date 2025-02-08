package com.jubayertech.sqllitedatabase_class_3015;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SqllitedatabaseHelper extends SQLiteOpenHelper {
    public  static final String Db_name="my_database";
    public static final int Db_version=1;


    public SqllitedatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context,Db_name, null,Db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table my_table(ID INTEGER primary key autoincrement,name text,email text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {

        db.execSQL("drop table if exists my_table");
    }
    //=================
    public void insertData (String name,String email){
        SQLiteDatabase database=this.getWritableDatabase();

        ContentValues conval=new ContentValues();
        conval.put("name",name);
        conval.put("email",email);

        database.insert("my_table",null,conval);

    }




}
