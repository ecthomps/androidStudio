package andoridactivities.example.christianthompson.androidactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        showText = (TextView) findViewById(R.id.secondViewID);

        //gets content from another activity
        Bundle extras = getIntent().getExtras();

        if(extras != null){

            //must match up the key from the previous activity
            String myString = extras.getString("activityOne");
            showText.setText(myString);
        }
    }
}
