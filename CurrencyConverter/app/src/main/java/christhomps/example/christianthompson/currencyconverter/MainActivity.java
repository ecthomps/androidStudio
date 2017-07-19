package christhomps.example.christianthompson.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button usCurrencyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void setUp(){

        usCurrencyBtn = (Button) findViewById(R.id.usBtn);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.usBtn: break;
        }
    }
}
