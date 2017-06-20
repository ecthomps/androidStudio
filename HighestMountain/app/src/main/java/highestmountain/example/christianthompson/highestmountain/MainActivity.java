package highestmountain.example.christianthompson.highestmountain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button button, carButton, nameButton;
    private TextView textView, carTextView, nameView;
    private EditText editName;
    Random random = new Random();
    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] mountains = {"Everest", "kILIMANJARO", "Makulu",
                                    "Trivor", "K12", "Ultar", "Mana"};
        final String[] cars = {"GM Traverse", "Ford Focus", "Lincoln",
                               "Buick", "Cardillac", "Audi A8"};

        button = (Button) findViewById(R.id.buttonID);
        carButton = (Button) findViewById(R.id.carButtonID);
        textView = (TextView) findViewById(R.id.textViewID);
        carTextView = (TextView) findViewById(R.id.carViewID);
        nameButton = (Button) findViewById(R.id.nameID);
        nameView = (TextView) findViewById(R.id.nameTextID);
        editName =(EditText) findViewById(R.id.editTextID);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                randomNumber = random.nextInt(mountains.length);
                textView.setText(mountains[randomNumber]);
            }
        });

        carButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                randomNumber = random.nextInt(cars.length);
                carTextView.setText(cars[randomNumber]);
            }
        });

        nameButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                nameView.setText(editName.getText().toString());
            }
        });
    }
}
