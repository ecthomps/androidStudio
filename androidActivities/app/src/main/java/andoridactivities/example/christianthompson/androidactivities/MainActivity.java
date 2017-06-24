package andoridactivities.example.christianthompson.androidactivities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = (Button) findViewById(R.id.mainBtnId);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("activityOne", "I am from Main Activity");

                startActivity(intent);
            }
        });
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        Toast.makeText(getApplicationContext(), "OnStart Method Call",
//                       Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//
//        Toast.makeText(getApplicationContext(), "OnRestart Method Call",
//                       Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        Toast.makeText(getApplicationContext(), "OnResume Method Call",
//                Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        Toast.makeText(getApplicationContext(), "OnPause Method Call",
//                Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//
//        Toast.makeText(getApplicationContext(), "OnStop Method Call",
//                Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//        Toast.makeText(getApplicationContext(), "OnDestroy Method Call",
//                Toast.LENGTH_SHORT).show();
//    }
}
