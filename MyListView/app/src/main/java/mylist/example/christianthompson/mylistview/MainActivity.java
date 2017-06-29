package mylist.example.christianthompson.mylistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //ArrayAdapter converts an ArrayList of objects into
    // View items loaded into the ListView container
    //An Adapter is responsible for creatinge between our
    //data source and our listview

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listId);

        final String[] values = new String[] {"The Complete ANdroid and Java Course",
                                 "@ecthomps", "Hello Firends", "Android is Great",
                                 "@ecthomps", "Hello Firends", "Android is Great",
                                 "@ecthomps", "Hello Firends", "Android is Great",
                                 "@ecthomps", "Hello Firends", "Android is Great",
                                 "@ecthomps", "Hello Firends", "Android is Great",
                                 "@ecthomps", "Hello Firends", "Android is Great",
                                 "@ecthomps", "Hello Firends", "Android is Great"};

        //setUp ArrayAdapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                                                android.R.layout.simple_list_item_1,
                                                android.R.id.text1, values);

        //assign listView to adapter
        listView.setAdapter(arrayAdapter);

        //set onClick
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //enables us to fetch whatever was click and show something
                int intPosition = position; //keeps position of each item in the listView
                String clickedValue = listView.getItemAtPosition(intPosition).toString();

                Toast.makeText(getApplication(), clickedValue,
                                Toast.LENGTH_LONG).show();
            }
        });
    }
}
