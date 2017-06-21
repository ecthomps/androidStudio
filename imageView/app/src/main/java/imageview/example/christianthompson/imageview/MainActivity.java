package imageview.example.christianthompson.imageview;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView androidImage;
    private TextView showText;

    //test to debug using logging
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidImage = (ImageView) findViewById(R.id.imageViewID);
        showText = (TextView) findViewById(R.id.textViewID);

//      Different ways to show a toast message
//        Toast.makeText(this, "Hey There", Toast.LENGTH_LONG).show();
//        Toast.makeText(getApplicationContext(), "Hey There",
//                       Toast.LENGTH_LONG).show();
//        Toast.makeText(MainActivity.this, "Hey There",
//                       Toast.LENGTH_LONG).show();

        androidImage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String textOut = "Android is AWESOME!!!";
                showText.setText(textOut);

//                Logging a program
//                Log.d(TAG, "debug Android");
//                Log.v(TAG, "verbose Android");
            }
        });
    }
}
