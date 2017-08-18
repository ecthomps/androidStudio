package christhomps.example.christianthompson.mygrocerylist.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.constraint.solver.widgets.ConstraintAnchor;

import java.util.List;

import christhomps.example.christianthompson.mygrocerylist.Model.Grocery;
import christhomps.example.christianthompson.mygrocerylist.Util.Constants;

/**
 * Created by Christian Thompson on 8/18/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private Context ctx;

    public DatabaseHandler(Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);

        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_GROCERY_TABLE = "CREATE TABLE " + Constants.TABLE_NAME + "("
                + Constants.KEY_ID + " INTEGER PRIMARY KEY," + Constants.KEY_GROCERY_ITEM
                + " TEXT," + Constants.KEY_QTY_NUMBER + " TEXT,"
                + Constants.KEY_DATE_NAME + " LONG);";

        db.execSQL(CREATE_GROCERY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + Constants.TABLE_NAME);

        onCreate(db);
    }

    /*
    * CRUD OPERATIONS: Create Read Update Delete
    * */

    //Add Grocery
    public void AddGrocery(Grocery grocery){


    }

    //Get a Grocery
    private Grocery getGrocery(int id){

        return null;
    }

    //Get all Groceries
    public List<Grocery> getAllGroceries () {

        return null;
    }

    //update grocery
    public int updateGrocery(Grocery grocery) {

        return 0;
    }

    //delete grocery
    public void deleteGrocery (int id) {

    }

    //get count
    public int getGroceriesCount() {

        return 0;
    }
}
