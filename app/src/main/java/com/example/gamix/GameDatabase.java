package com.example.gamix;

import java.sql.SQLClientInfoException;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class GameDatabase extends SQLiteOpenHelper {
    public GameDatabase(Context context){
        super(context,"GameDetail.db",null,1);
    }
    String DB_NAME = "GameDetails";
    String TABLE_NAME = "detailsList";
    String ATR1 = "gameId";
    String ATR2 = "gameName";
    String ATR3 = "reqs";
    String ATR4 = "genre";
    String ATR5 = "website";

    public void addSetting(String gameid,String gamename,String reqs,String genre,String website){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] cols = {ATR1};
        String[] v = {gameid};
        Cursor cur = db.query(TABLE_NAME,cols,ATR1+"=?",v,null,null,null);
        if (!cur.moveToFirst()) {
            ContentValues cv = new ContentValues();
            cv.put(ATR1, gameid);
            cv.put(ATR2, gamename);
            cv.put(ATR3, reqs);
            cv.put(ATR4, genre);
            cv.put(ATR5, website);
            db.insert(TABLE_NAME, null, cv);
        }
        cur.close();
        db.close();
    }

    public String getGameName(String gameId){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {ATR1,ATR2};
        String[] v={gameId};
        String name = null;
        Cursor cur = db.query(TABLE_NAME,cols,ATR1+"=?",v,null,null,null);
        if (cur.moveToFirst()) {
            name = cur.getString(1);
        }
        cur.close();
        db.close();
        return name;
    }
    public String getRequirement(String gameId){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {ATR1,ATR3};
        String[] v={gameId};
        String name = null;
        Cursor cur = db.query(TABLE_NAME,cols,ATR1+"=?",v,null,null,null);
        if (cur.moveToFirst()) {
            name = cur.getString(1);
        }
        cur.close();
        db.close();
        return name;
    }
    public String getGenre(String gameId){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {ATR1,ATR4};
        String[] v={gameId};
        String name = null;
        Cursor cur = db.query(TABLE_NAME,cols,ATR1+"=?",v,null,null,null);
        if (cur.moveToFirst()) {
            name = cur.getString(1);
        }
        cur.close();
        db.close();
        return name;
    }
    public String getWebsite(String gameId){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {ATR1,ATR5};
        String[] v={gameId};
        String name = null;
        Cursor cur = db.query(TABLE_NAME,cols,ATR1+"=?",v,null,null,null);
        if (cur.moveToFirst()) {
            name = cur.getString(1);
        }
        cur.close();
        db.close();
        return name;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String query="create table "+ TABLE_NAME +"("
                + ATR1 + " text,"
                + ATR2 + " text,"
                + ATR3 + " text,"
                + ATR4 + " text,"
                + ATR5 + " text)";
        db.execSQL(query);
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }
}
