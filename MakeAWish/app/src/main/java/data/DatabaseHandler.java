package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;

import model.MyWish;

/**
 * Created by Christian Thompson on 8/7/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private final ArrayList<MyWish> wishList = new ArrayList<>();
    public DatabaseHandler(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create our table
        //create a String data to hold SQL cmd to create table
        String CREATE_WISHES_TABLE = "CREATE TABLE " + Constants.TABLE_NAME +
                "(" + Constants.KEY_ID + "INTEGER PRIMARY KEY " + Constants.TITLE_NAME +
                " TEXT, " + Constants.CONTENT_NAME + "TEXT, " + Constants.DATE_NAME +
                " LONG);";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);

        //create a new table
        onCreate(db);
    }

    public void addWish(MyWish wish){

        SQLiteDatabase db = this.getWritableDatabase();

        //ContentValues act as a HashMap data structure
        ContentValues values = new ContentValues();
        values.put(Constants.TITLE_NAME, wish.getTitle());
        values.put(Constants.CONTENT_NAME, wish.getContent());
        values.put(Constants.DATE_NAME, java.lang.System.currentTimeMillis());

        db.insert(Constants.TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<MyWish> getWishes() {

        //select everything from our tableName
        String selectQuery = "SELECT * FROM " + Constants.TABLE_NAME;

        //set things up to read from our DATABASE
        SQLiteDatabase db = this.getReadableDatabase();

        //order list by date modified
        Cursor cursor = db.query(Constants.TABLE_NAME, new String[]{Constants.KEY_ID,
                            Constants.TITLE_NAME, Constants.CONTENT_NAME, Constants.DATE_NAME,
                            }, null, null, null, null, Constants.DATE_NAME + "DESC");

        //loop through cursor if cursor has items to move to
        if(cursor.moveToFirst()) {

            do{
                MyWish wish = new MyWish();
                wish.setTitle(cursor.getString(cursor.getColumnIndex(Constants.TITLE_NAME)));
                wish.setContent(cursor.getString(cursor.getColumnIndex(Constants.CONTENT_NAME)));

                //use dateFormat to format our date
                java.text.DateFormat dateFormat = java.text.DateFormat.getDateInstance();
                String dateData = dateFormat.format(new Date(cursor.getLong
                                (cursor.getColumnIndex(Constants.DATE_NAME))).getTime());

                wish.setRecordDate(dateData);

                wishList.add(wish);
            } while (cursor.moveToNext());

        }

        return wishList;
    }
}
