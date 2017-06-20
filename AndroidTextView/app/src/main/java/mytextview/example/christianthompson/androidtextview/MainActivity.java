package mytextview.example.christianthompson.androidtextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = (Button) findViewById(R.id.heyButton);


        TextView textView = (TextView) findViewById(R.id.myTextView);
        textView.setText("Hey you changed");
    }
}
