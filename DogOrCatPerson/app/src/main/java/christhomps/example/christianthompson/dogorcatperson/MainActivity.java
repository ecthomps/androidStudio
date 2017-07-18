package christhomps.example.christianthompson.dogorcatperson;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

        //call methods
        processCutest(cutestCheckBoxDog, cutestCheckBoxCat, cutestCheckBoxParrot);
        processDrool(droolRadioGroup);
        processCanines(canineRadioGroup);
        showSeekBar(seekBar, seekBarTextView);

        showResultButton = (Button) findViewById(R.id.showResult);
        showResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("catCounter", catCounter);
                intent.putExtra("dogCounter", dogCounter);
                startActivity(intent);
            }
        });

    }

    public void processCutest(CheckBox checkBoxDog, CheckBox checkBoxCat,
                              CheckBox checkBoxParrot){

        if(checkBoxDog.isChecked() && !checkBoxCat.isChecked() &&
                  !checkBoxParrot.isChecked()){
            dogCounter+=5;
        } else if(checkBoxCat.isChecked() && !checkBoxDog.isChecked() &&
                  !checkBoxParrot.isChecked()){
            catCounter+=5;
        }
    }

    public void processDrool(final RadioGroup radioGroup){

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int radioId = radioGroup.getCheckedRadioButtonId();
                droolRadioButton = (RadioButton) findViewById(radioId);

                if(droolRadioButton.getText().equals("Yes")){
                    dogCounter+= 5;
                }
            }
        });
    }

    public void processCanines(final RadioGroup radioGroup){

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int radioId = radioGroup.getCheckedRadioButtonId();
                canineRadioButton = (RadioButton) findViewById(radioId);

                if(canineRadioButton.getText().equals("Yes")){
                    dogCounter+=5;
                }
            }
        });
    }

    public void showSeekBar(SeekBar seekBar, final TextView textView){

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText("Comfortableness: " + progress + "/" + seekBar.getMax());
                catCounter+=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
