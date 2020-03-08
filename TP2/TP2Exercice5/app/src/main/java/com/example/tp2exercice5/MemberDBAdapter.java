package com.example.tp2exercice5;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.example.tp2exercice5.DatabaseOpenHelper.*;

public class MemberDBAdapter {
    private static final String BASE_NAME = "exo4db";
    private static final int BASE_VERSION = 1;
    private DatabaseOpenHelper baseHelper;
    private SQLiteDatabase database;

    public MemberDBAdapter(Context ctx) {
        baseHelper = new DatabaseOpenHelper(ctx, BASE_NAME, null, BASE_VERSION);
    }

    public SQLiteDatabase open() {
        database = baseHelper.getWritableDatabase();
        return database;
    }

    public ArrayList<Contact> findAll() {
        ArrayList<Contact> contacts = new ArrayList<>();

        Cursor c = database.query(CONTACT_TABLE, null, null, null, null, null, null);

        while (c.moveToNext()) {
            String name = c.getString(0);
            String firstName = c.getString(1);
            String phoneNumber = c.getString(2);

            contacts.add(new Contact(name, firstName, phoneNumber));
        }

        return contacts;
    }

    public Contact find(Contact contact) {
        ArrayList<Contact> contacts = new ArrayList<>();

        Cursor c = database.query(CONTACT_TABLE, new String[]{ CONTACT_NAME_COLUMN, CONTACT_FIRSTNAME_COLUMN, CONTACT_PHONENUMBER_COLUMN},
        CONTACT_NAME_COLUMN + " like '%" + contact.getName() + "%' AND " +
                CONTACT_FIRSTNAME_COLUMN + " like '%" + contact.getFirstName() + "%' AND " +
                CONTACT_PHONENUMBER_COLUMN + " like '%" + contact.getPhoneNumber() + "%'", null, null, null, null);

        if (c.moveToNext()) {
            String name = c.getString(0);
            String firstName = c.getString(1);
            String phoneNumber = c.getString(2);

            return new Contact(name, firstName, phoneNumber);
        }

        return null;
    }

    public void insert(Contact contact) {
        ContentValues values = new ContentValues();
        values.put(CONTACT_NAME_COLUMN, contact.getName());
        values.put(CONTACT_FIRSTNAME_COLUMN, contact.getFirstName());
        values.put(CONTACT_PHONENUMBER_COLUMN, contact.getPhoneNumber());

        database.insert(CONTACT_TABLE, null, values);
    }

}
