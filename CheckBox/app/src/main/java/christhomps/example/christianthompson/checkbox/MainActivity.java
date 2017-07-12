package christhomps.example.christianthompson.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox dogPet, catPet, dragonPet;
    private Button showPet;
    private TextView displayPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dogPet = (CheckBox) findViewById(R.id.checkBoxDogId);
        catPet = (CheckBox) findViewById(R.id.checkBoxCatId);
        dragonPet = (CheckBox) findViewById(R.id.checkBoxDragonId);
        showPet = (Button) findViewById(R.id.showBtnId);
        displayPet = (TextView) findViewById(R.id.showPetId);

        showPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(dogPet.getText().toString() + " status is: "
                                     + dogPet.isChecked() + "\n");
                stringBuilder.append(catPet.getText().toString() + " status is: "
                                     + catPet.isChecked() + "\n");
                stringBuilder.append(dragonPet.getText().toString() + " status is: "
                                     + dragonPet.isChecked() + "\n");

                displayPet.setText(stringBuilder);
            }
        });
    }
}
