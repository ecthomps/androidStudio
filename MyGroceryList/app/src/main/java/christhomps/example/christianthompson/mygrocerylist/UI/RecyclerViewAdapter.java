package christhomps.example.christianthompson.mygrocerylist.UI;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import christhomps.example.christianthompson.mygrocerylist.Model.Grocery;
import christhomps.example.christianthompson.mygrocerylist.R;

/**
 * Created by Christian Thompson on 8/20/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Grocery> groceryItem;

    public RecyclerViewAdapter(Context context, List<Grocery> groceryItem) {
        this.context = context;
        this.groceryItem = groceryItem;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_row, parent, false);

        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {

        Grocery grocery = groceryItem.get(position);
    }

    @Override
    public int getItemCount() {
        return groceryItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView groceryItemName;
        public TextView groceryItemQty;
        public TextView dateAdded;
        public Button editButton, deleteButton;

        public ViewHolder(View view, Context ctx) {
            super(view);

            //stop here
            context = ctx;
        }

        @Override
        public void onClick(View v) {

        }
    }
}
