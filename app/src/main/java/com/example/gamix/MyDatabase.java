package com.example.gamix;

import java.sql.SQLClientInfoException;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDatabase extends SQLiteOpenHelper {
    public MyDatabase(Context context){
        super(context,"LoginDetail.db",null,1);
    }
    String DB_NAME = "LoginDetail";
    String TABLE_NAME = "loginDetails";
    String ATR1 = "emailId";
    String ATR2 = "username1";
    String ATR3 = "password1";
    public void insert(String email,String uname,String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(ATR1,email);
        cv.put(ATR2,uname);
        cv.put(ATR3,pass);
        db.insert(TABLE_NAME,null,cv);
        db.close();
    }
    public boolean doublEntryEmail(String emailid){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {ATR1};
        String[] v = {emailid};
        Boolean exists = false;
        Cursor cur = db.query(TABLE_NAME,cols,ATR1+"=?",v,null,null,null);
        if (cur.moveToFirst()) {
            do {
                if (cur.getString(0).equals(emailid)) {
                    exists = true;
                    break;
                }
            } while (cur.moveToNext());
            cur.close();
            db.close();
        }
        return exists;
    }
    public boolean doublEntryUser(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {ATR2};
        String[] v = {username};
        Boolean exists = false;
        Cursor cur = db.query(TABLE_NAME,cols,ATR2+"=?",v,null,null,null);
        if (cur.moveToFirst()) {
            do {
                if (cur.getString(0).equals(username)) {
                    exists = true;
                    break;
                }
            } while (cur.moveToNext());
            cur.close();
            db.close();
        }
        return exists;
    }
    public boolean check(String user,String pass){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {ATR2,ATR3};
        String[] v={user};
        String truePass;
        boolean res = false;
        Cursor cur = db.query(TABLE_NAME,cols,ATR2+"=?",v,null,null,null);
        if (cur.moveToFirst()) {
            truePass = cur.getString(1);
            if (truePass.equals(pass))
                res = true;
        }
        cur.close();
        db.close();
        return res;
    }
    public void addSetting(String email,String uname,String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] cols = {ATR1,ATR2};
        String[] v = {uname};
        Cursor cur = db.query(TABLE_NAME,cols,ATR2+"=?",v,null,null,null);
        if (!cur.moveToFirst()) {
            ContentValues cv = new ContentValues();
            cv.put(ATR1, email);
            cv.put(ATR2, uname);
            cv.put(ATR3, pass);
            db.insert(TABLE_NAME, null, cv);
        }
        cur.close();
        db.close();
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String query="create table "+ TABLE_NAME +"("
                + ATR1 + " text,"
                + ATR2 + " text,"
                + ATR3 + " text)";
        db.execSQL(query);
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }
}
