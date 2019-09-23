package com.example.databaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="Contact.db";

    private static final String CREATE_TABLE="create table "+ContactContract.ContactEntry.TABLE_NAME+"("+ContactContract.ContactEntry.ID+" number, "+ContactContract.ContactEntry.NAME+" text, " +ContactContract.ContactEntry.EMAIL+" text);";
    private static final String DROP_TABLE="drop table "+ContactContract.ContactEntry.TABLE_NAME;

    public ContactDbHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION );
        Log.d("Database Operations", "Database Created..");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.d("Database Operations", "Table Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void addContact(int id, String name, String email, SQLiteDatabase db){
        ContentValues contents=new ContentValues();
        contents.put(ContactContract.ContactEntry.ID, id);
        contents.put(ContactContract.ContactEntry.NAME, name);
        contents.put(ContactContract.ContactEntry.EMAIL, email);
        db.insert(ContactContract.ContactEntry.TABLE_NAME, null, contents);
        Log.d("Database Operations", "One row inserted");

    }

    public Cursor readContact(SQLiteDatabase database)
    {
        String[] projections={ContactContract.ContactEntry.ID, ContactContract.ContactEntry.NAME, ContactContract.ContactEntry.EMAIL};

        Cursor cursor=database.query(ContactContract.ContactEntry.TABLE_NAME, projections, null, null, null, null, null);
        return cursor;

    }

    public void updateContact(int id, String name, String email, SQLiteDatabase db){

        ContentValues contentValues=new ContentValues();
        contentValues.put(ContactContract.ContactEntry.EMAIL, email);
        contentValues.put(ContactContract.ContactEntry.NAME, name);

        String selection=ContactContract.ContactEntry.ID+" = "+id;

        db.update(ContactContract.ContactEntry.TABLE_NAME, contentValues, selection, null);
    }

    public void deleteContact(int id, SQLiteDatabase database){

        String selection= ContactContract.ContactEntry.ID+" = "+id;
        database.delete(ContactContract.ContactEntry.TABLE_NAME, selection, null );

    }
}
