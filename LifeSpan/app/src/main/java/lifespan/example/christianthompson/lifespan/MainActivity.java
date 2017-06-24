package lifespan.example.christianthompson.lifespan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText userAge;
    private Button daysAlive, weeksAlive, monthsAlive;
    private TextView showAlive;
    private double daysVal, weeksVal, monthsVal, timeLived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userAge = (EditText) findViewById(R.id.userAgdId);
        daysAlive = (Button) findViewById(R.id.daysBtnID);
        weeksAlive = (Button) findViewById(R.id.weekBtnId);
        monthsAlive = (Button) findViewById(R.id.monthBtnId);
        showAlive = (TextView) findViewById(R.id.timeLivedId);

        //set up days onClickListener
        daysAlive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getUserAge = userAge.getText().toString();
                String daysLived;

                if(getUserAge.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter Your Age",
                                    Toast.LENGTH_SHORT).show();
                }
                else{
                    daysVal = Double.parseDouble(getUserAge);
                    timeLived = calcDaysAlive(daysVal);
                    daysLived = String.valueOf("You've lived roughly for "
                                                + timeLived + " days");
                    showAlive.setText(daysLived);
                }
            }
        });

        //set up weeks onClickListener
        weeksAlive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getUserAge = userAge.getText().toString();
                String weeksLived;

                if(getUserAge.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter Your Age",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    weeksVal = Double.parseDouble(getUserAge);
                    timeLived = calcWeeksAlive(weeksVal);
                    weeksLived = String.valueOf("You've lived roughly for "
                            + timeLived + " weeks");
                    showAlive.setText(weeksLived);
                }
            }
        });

        //set up days onClickListener
        monthsAlive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getUserAge = userAge.getText().toString();
                String monthsLived;

                if(getUserAge.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter Your Age",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    monthsVal = Double.parseDouble(getUserAge);
                    timeLived = calcMonthsAlive(monthsVal);
                    monthsLived = String.valueOf("You've lived roughly for "
                            + timeLived + " months");
                    showAlive.setText(monthsLived);
                }
            }
        });
    }

    public double calcDaysAlive(double userAge){
        return userAge * 365.25;
    }

    public double calcWeeksAlive(double userAge){
        return userAge * 12.25;
    }

    public double calcMonthsAlive(double userAge){
        return userAge * 52.25;
    }
}
