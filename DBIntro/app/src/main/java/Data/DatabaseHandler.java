package Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import Model.Contact;
import Utils.Util;

/**
 * Created by Christian Thompson on 8/10/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    //create tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQL language
        String CREATE_CONTACT_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "("
                + Util.KEY_ID + " INTEGER PRIMARY KEY," + Util.KEY_NAME + " TEXT,"
                + Util.KEY_PHONE_NUMBER + " TEXT," + ");";

        //script to create table
        db.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Dropping is deleting the table
        db.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_NAME);

        //CREATE TABLE AGAIN
        onCreate(db);
    }

    /**
     *  CRUD Operations - Create, Read, Update, Delete
     */

    //Add Contact
    public void addContact(Contact contact) {

        //call to write Database
        SQLiteDatabase db = this.getWritableDatabase();

        //works eactly as HASH_MAP
        ContentValues value = new ContentValues();
        value.put(Util.KEY_NAME, contact.getName());
        value.put(Util.KEY_PHONE_NUMBER, contact.getPhoneNumber());

        //Insert into row
        db.insert(Util.TABLE_NAME, null, value);
        db.close(); //close db connection
    }

    //Get a Contact
    public Contact getContact(int id) {

        //call to get Database
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Util.TABLE_NAME, new String[] { Util.KEY_ID,
                Util.KEY_NAME, Util.KEY_PHONE_NUMBER}, Util.KEY_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        //goes through through the columns --> id colPos == 0, name colPos == 1 ...
        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        return contact;
    }
}
