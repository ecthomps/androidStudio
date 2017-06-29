package booklist.example.christianthompson.custombooklist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Christian Thompson on 6/29/2017.
 */

public class CustomListViewAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<HashMap<String, String>> books;
    //A LayoutInflater allows us to go and inflate or
    // get xml files created in android and spit it out
    // in our view or any view
    private static LayoutInflater inflater = null;


    public CustomListViewAdapter(Context context, ArrayList<HashMap<String, String>> data) {

        mContext = context;
        books = data;
        inflater = (LayoutInflater) context.getSystemService
                                        (Context.LAYOUT_INFLATER_SERVICE);
        //we tell android to go and get our LayoutInflater class ready to
        //inflate our xml files (our views)
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(view == null){

            //takes back the listView (list_row in layout) and
            //brings it to the current activity to be used
            //gives you access to all id's in the list_row layout
            view = inflater.inflate(R.layout.list_row, null);

            TextView title = (TextView) view.findViewById(R.id.titleId);
            TextView author = (TextView) view.findViewById(R.id.authorId);
            TextView pages = (TextView) view.findViewById(R.id.pagesId);
            ImageView images = (ImageView) view.findViewById(R.id.imageId);

            HashMap<String, String> mBooks = new HashMap<>();

            mBooks = books.get(position);

            title.setText(mBooks.get("title"));
            author.setText(mBooks.get("author"));
            pages.setText(mBooks.get("pages"));
            images.setImageDrawable(mContext.getResources().getDrawable(R.drawable.blue_swirl));


        }

        return view;
    }
}
