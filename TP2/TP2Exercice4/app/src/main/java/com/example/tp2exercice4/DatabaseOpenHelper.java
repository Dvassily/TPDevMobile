package com.example.tp2exercice4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
    public static final String CONTACT_TABLE = "CONTACT";
    public static final String CONTACT_NAME_COLUMN = "name";
    public static final String CONTACT_FIRSTNAME_COLUMN = "firstname";
    public static final String CONTACT_PHONENUMBER_COLUMN = "phonenumber";

    private static final String CREATION_REQUEST =
            "CREATE TABLE " + CONTACT_TABLE +  "(" +
                    CONTACT_NAME_COLUMN + " text not null, " +
                    CONTACT_FIRSTNAME_COLUMN + " text not null, " +
                    CONTACT_PHONENUMBER_COLUMN + " text not null);";

    private static final String DROP_REQUEST = "DROP TABLE " + CONTACT_TABLE + ";";

    public DatabaseOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATION_REQUEST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_REQUEST);

        onCreate(db);
    }
}
