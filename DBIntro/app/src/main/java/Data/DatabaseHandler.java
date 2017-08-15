package Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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
                + Util.KEY_PHONE_NUMBER + " TEXT" + ");";

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

    //Get all contacts
    public List<Contact> getAllContacts() {

        //call to get Database
        SQLiteDatabase db = this.getReadableDatabase();

        List<Contact> contactList = new ArrayList<>();

        String selectAll  = "SELECT * FROM " + Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll, null);

        //Loop through all contacts
        if (cursor.moveToFirst()){

            do {
                //constructing our contacts
                Contact myContact = new Contact();
                myContact.setId(Integer.parseInt(cursor.getString(0)));
                myContact.setName(cursor.getString(1));
                myContact.setPhoneNumber(cursor.getString(2));

                //add myContact object to our contactList
                contactList.add(myContact);

            } while(cursor.moveToNext());
        }

        return contactList;
    }

    //updateContact
    public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, contact.getName());
        values.put(Util.KEY_PHONE_NUMBER, contact.getPhoneNumber());

        //update row
        return db.update(Util.TABLE_NAME, values, Util.KEY_ID + "=?",
                new String[] {String.valueOf(contact.getId())});

    }

    //Delete single contact
    public void deleteContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util.TABLE_NAME, Util.KEY_ID + "=?",
                new String[] {String.valueOf(contact.getId())});

        db.close();
    }


    //Get contacts count
    public int getContactsCount() {
        String countQuery = "SELECT * FROM " + Util.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        //cursor.close();

        return cursor.getCount();
    }
}
