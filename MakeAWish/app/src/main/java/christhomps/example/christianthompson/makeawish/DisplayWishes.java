package christhomps.example.christianthompson.makeawish;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;

import data.DatabaseHandler;
import model.MyWish;

public class DisplayWishes extends AppCompatActivity {

    private DatabaseHandler dba;
    private ArrayList<MyWish> dbWishes = new ArrayList<>();
    private WishAdapter wishAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_wishes);

        listView = (ListView) findViewById(R.id.list);

        refreshData();
    }

    //TODO: FIXME
    private void refreshData() {
        dbWishes.clear();
        dba = new DatabaseHandler(getApplicationContext());
        Log.v("dba initialization", "successful");

        //collects all wishes an assigns it to wishesFromDb
        ArrayList<MyWish> wishesFromDb = dba.getWishes();
        Log.v("dba initialization", "successful");

        //create a loop to collect title, dateText, and content
        for (int i = 0; i < wishesFromDb.size(); i++) {

            String title = wishesFromDb.get(i).getTitle();
            String content = wishesFromDb.get(i).getContent();
            String dateText = wishesFromDb.get(i).getRecordDate();

            //creating a new wish to store title, content, and dateText
            MyWish myWish = new MyWish();
            myWish.setTitle(title);
            myWish.setContent(content);
            myWish.setRecordDate(dateText);

            dbWishes.add(myWish);
            Log.v("dba added", "successful");
        }
        dba.close();

        //setUp Adapter
        wishAdapter = new WishAdapter(DisplayWishes.this, R.layout.wish_row, dbWishes);
        Log.v("wAdapter initialization", "successful");

        listView.setAdapter(wishAdapter);
        Log.v("listView adapter", "successful");

        wishAdapter.notifyDataSetChanged();
        Log.v("wAdapter notify", "successful");
    }

    //TODO: FIXME
    public class WishAdapter extends ArrayAdapter<MyWish> {
        Activity activity;
        int layoutRes;
        MyWish wish;
        ArrayList<MyWish> mData = new ArrayList<>();

        public WishAdapter(Activity act, int resource,
                           ArrayList<MyWish> data) {
            super(act, resource, data);

            activity = act;
            layoutRes = resource;
            mData = data;

            //syncs all data up correctly when you scroll up n down
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            //return size of array holding all wishes
            return mData.size();
        }


        @Override
        public MyWish getItem(int position) {
            return mData.get(position);
        }

        @Override
        public int getPosition(MyWish item) {
            return super.getPosition(item);
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }

        //heart of ArrayAdapter where our listView and
        //arrayList is created
        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            View row = convertView;
            ViewHolder holder = null;

            //checks to see if no row is created and creates a row
            if( row == null || (row.getTag()) == null){

                LayoutInflater inflater = LayoutInflater.from(activity);
                row = inflater.inflate(layoutRes, null);
                holder = new ViewHolder();

                holder.mTitle = (TextView) findViewById(R.id.mainWish);
                holder.mDate = (TextView) findViewById(R.id.userWishDate);

                row.setTag(holder);
            } else {
                holder = (ViewHolder) row.getTag();
            }

            holder.wish = getItem(position);

            holder.mTitle.setText(holder.wish.getTitle());
            holder.mDate.setText(holder.wish.getRecordDate());

            return row;
        }

        class ViewHolder{

            MyWish wish;
            TextView mTitle;
            TextView mId;
            TextView mContent;
            TextView mDate;
        }
    }




}
