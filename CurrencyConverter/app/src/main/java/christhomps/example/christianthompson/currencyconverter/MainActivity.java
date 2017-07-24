package christhomps.example.christianthompson.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button usCurrencyBtn, kshCurrencyBtn, engCurrencyBtn;
    private Button nigCurrencyBtn, eurCurrencyBtn;
    private EditText currencyValue;
    private TextView currency1, currency2, result;
    private double value;
    private Boolean isUS, isKSH, isENG, isNIG, isEUR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();

    }

    public void setUp(){

        value = 0.0;
        isUS = false; isKSH = false; isENG = false;
        isNIG = false; isEUR = false;

        usCurrencyBtn = (Button) findViewById(R.id.usBtn);
        kshCurrencyBtn = (Button) findViewById(R.id.kshBtn);
        engCurrencyBtn = (Button) findViewById(R.id.engBtn);
        nigCurrencyBtn =( Button) findViewById(R.id.nigBtn);
        eurCurrencyBtn = (Button) findViewById(R.id.eurBtn);

        currencyValue = (EditText) findViewById(R.id.currencyValue1);
        result = (TextView) findViewById(R.id.resultId);
        currency1 = (TextView) findViewById(R.id.currency1Id);
        currency2 = (TextView) findViewById(R.id.currency2Id);

        usCurrencyBtn.setOnClickListener(this);
        kshCurrencyBtn.setOnClickListener(this);
        engCurrencyBtn.setOnClickListener(this);
        nigCurrencyBtn.setOnClickListener(this);
        eurCurrencyBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.usBtn:
                currency2.setText(getResources().getString(R.string.usa));
                value = Double.parseDouble(currencyValue.getText().toString());
                result.setText("" + (value * 1));
                break;
            case R.id.kshBtn:
                currency2.setText(getResources().getString(R.string.ken));
                value = Double.parseDouble(currencyValue.getText().toString());
                result.setText("" + (value * 103.95));
                break;
            case R.id.engBtn:
                currency2.setText(getResources().getString(R.string.eng));
                value = Double.parseDouble(currencyValue.getText().toString());
                result.setText("" + (value * 0.77));
                break;
            case R.id.nigBtn:
                currency2.setText(getResources().getString(R.string.nig));
                value = Double.parseDouble(currencyValue.getText().toString());
                result.setText("" + (value * 315.25));
                break;
            case R.id.eurBtn:
                currency2.setText(getResources().getString(R.string.eur));
                value = Double.parseDouble(currencyValue.getText().toString());
                result.setText("" + (value * 0.86));
                break;
        }
    }


}



