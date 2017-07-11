package christhomps.example.christianthompson.famlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CustomListViewAdapter customListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] memberNames= new String[]{
                "Christian", "Mary", "CT", "Ashley",
                "Faith", "Cil", "Emmanuel", "Cecilia"
        };

        final String[] relationType= new String[]{
                "Myself", "Girlfriend", "Brother",
                "Sister-in-law", "Sister", "Brother",
                "Nephew", "Mother"
        };

        final String[] contactType= new String[]{
                "Mobile", "Facebook", "Mobile",
                "Mobile", "Facebook", "Mobile",
                "Mobile", "Facebook"
        };

        ArrayList<HashMap<String, String>> familyList = new ArrayList<>();

        for(int i = 0; i < 10; i++){

            HashMap<String, String> data = new HashMap<>();
            data.put("member", memberNames[i]);
            data.put("relation", relationType[i]);
            data.put("contact", contactType[i]);

            familyList.add(data);
        }

        listView = (ListView) findViewById(R.id.listId);

        //setUp Adapter
        customListViewAdapter = new CustomListViewAdapter(getApplicationContext(), familyList);
        listView.setAdapter(customListViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int myPosition = position;
                String itemClicked = listView.getItemAtPosition(myPosition).toString();
                Toast.makeText(getApplicationContext(), "Item Clicked: " +
                                    itemClicked, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
