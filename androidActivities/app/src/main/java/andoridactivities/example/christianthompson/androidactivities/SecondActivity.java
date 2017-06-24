package andoridactivities.example.christianthompson.androidactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView showText;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        showText = (TextView) findViewById(R.id.secondViewID);
        backButton = (Button) findViewById(R.id.retBtnId);

        //gets content from another activity
        Bundle extras = getIntent().getExtras();

        if(extras != null){
            //must match up the key from the previous activity
            String myString = extras.getString("activityOne");
            showText.setText(myString);
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent returnIntent = getIntent();
                returnIntent.putExtra("returnData", "From SecondActivity");
                //you can add more
                //returnIntent.putExtra("somethingElse", "This is something else");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

    }
}
