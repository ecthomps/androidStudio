package scorekeeper.example.christianthompson.radiobutton;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

    private RadioGroup radioGroup;
    private RadioButton radioChoiceButton;
    private Button showChoice;
    private TextView displayChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupId);
        showChoice = (Button) findViewById(R.id.choiceId);
        displayChoice = (TextView) findViewById(R.id.choiceId);

        showChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOption = radioGroup.getCheckedRadioButtonId();
                radioChoiceButton = (RadioButton) findViewById(selectedOption);

                displayChoice.setText(radioChoiceButton.getText());
            }
        });
    }
}
