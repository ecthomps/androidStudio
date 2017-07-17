package christhomps.example.christianthompson.dogorcatperson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup canineRadioGroup, droolRadioGroup;
    private RadioButton canineRadioButton, droolRadioButton;
    private SeekBar seekBar;
    private TextView seekBarTextView;
    private CheckBox cutestCheckBoxDog, cutestCheckBoxCat, cutestCheckBoxParrot;
    private Button showResultButton;
    private int dogCounter, catCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();
    }

    public void setUp(){

        dogCounter = 0; catCounter = 0;
        canineRadioGroup = (RadioGroup) findViewById(R.id.radioGroupCanine);
        droolRadioGroup = (RadioGroup) findViewById(R.id.radioGroupDrool);
        seekBar = (SeekBar) findViewById(R.id.seekBarFelineId);
        seekBarTextView = (TextView) findViewById(R.id.seekBarProgressId);

        cutestCheckBoxDog = (CheckBox) findViewById(R.id.checkBoxCutestDog);
        cutestCheckBoxCat = (CheckBox) findViewById(R.id.checkBoxCutestCat);
        cutestCheckBoxParrot = (CheckBox) findViewById(R.id.checkBoxCutestParrot);

        showResultButton = (Button) findViewById(R.id.showResult);

    }
}
