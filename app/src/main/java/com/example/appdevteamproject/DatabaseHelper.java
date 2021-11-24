package com.example.appdevteamproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Restaurant.db";
    public DatabaseHelper(Context context) {
        super(context, "Restaurant.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("Create Table User(userId INTEGER primary key autoincrement, username TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("Drop Table if exists User");
    }

    public Boolean insertUser(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("User", null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Boolean validateLogin(String username, String password, String userId){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from User where username = ? and password = ? and userId = ?", new String[] {username,password,userId});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public boolean addData(String name, int price, String category){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MenuItemName", name);
        contentValues.put("MenuItemPrice", price);
        contentValues.put("MenuItemCategory", category);

        long result  = sqLiteDatabase.insert(DBNAME, null, contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }

    public void deleteData(String username){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(DBNAME, username + " = ? ", new String[]
               {username});

        sqLiteDatabase.close();

    }

    public void updateData(String name, int price, String category){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("menuItemName", name);
        values.put("menuItemPrice", price);
        values.put("menuItemCategory", category);

        sqLiteDatabase.update(DBNAME, values, "name=?", new String[] {name} );


    }
}