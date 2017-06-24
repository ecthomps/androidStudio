package tempconverter.example.christianthompson.tempconverter;

import android.icu.text.DecimalFormat;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText tempEditText;
    private Button celsiusButton;
    private Button fahrenheitButton;
    private TextView displayTemp;
    private double celVal, farVal, tempOut;
    private String showTempVal, decimalFormat;
    //private DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempEditText = (EditText) findViewById(R.id.tempHint);
        celsiusButton = (Button) findViewById(R.id.celsiusButton);
        fahrenheitButton = (Button) findViewById(R.id.fButton);
        displayTemp = (TextView) findViewById(R.id.tempOut);

        //Set up button onClickListener
        celsiusButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String editTextVal = tempEditText.getText().toString();

                if(editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter a temp Value",
                                   Toast.LENGTH_LONG).show();
                } else{
                    celVal = Double.parseDouble(editTextVal);
                    tempOut = convert2Cel(celVal);
                    showTempVal = String.valueOf(tempOut + " C");
                    displayTemp.setText(showTempVal);
                }
            }
        });

        fahrenheitButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String editTextVal = tempEditText.getText().toString();

                if(editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter a temp Value",
                                   Toast.LENGTH_LONG).show();
                } else {
                    farVal = Double.parseDouble(editTextVal);
                    tempOut = convert2Far(farVal);
                    showTempVal = String.valueOf(tempOut + " F");
                    displayTemp.setText(showTempVal);
                }
            }
        });
    }

    public double convert2Cel(double farVal){
        //[C] = ([F] - 32) * (5/9)

        tempOut = (farVal - 32) * 5/9;
        return tempOut;
    }

    public double convert2Far(double celVal){
        //[F] = [C] * (9/5) + 32

        tempOut = celVal * (9/5) + 32;
        return tempOut;
    }
}
