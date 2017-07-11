package christhomps.example.christianthompson.famlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.Inflater;

/**
 * Created by Christian Thompson on 7/11/2017.
 */

public class CustomListViewAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<HashMap<String, String>> family;
    private static LayoutInflater inflater = null;

    public CustomListViewAdapter(Context context, ArrayList<HashMap<String, String>> family) {
        this.context = context;
        this.family = family;
        inflater = (LayoutInflater) context.getSystemService
                                        (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return family.size();
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

        if(view != null){

            view = inflater.inflate(R.layout.list_row, null);

            TextView member = (TextView) view.findViewById(R.id.memberId);
            TextView relation = (TextView) view.findViewById(R.id.relationId);
            TextView contact = (TextView) view.findViewById(R.id.contactId);
            ImageView images = (ImageView) view.findViewById(R.id.imageId);

            HashMap<String, String> memList = new HashMap<>();

            memList = family.get(position);

            member.setText(memList.get("member"));
            relation.setText(memList.get("relation"));
            contact.setText(memList.get("contact"));
            images.setImageDrawable(context.getResources().getDrawable(R.drawable.tman));
        }

        return view;
    }
}
