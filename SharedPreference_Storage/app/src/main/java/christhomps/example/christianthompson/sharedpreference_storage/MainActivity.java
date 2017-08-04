package christhomps.example.christianthompson.sharedpreference_storage;

import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText textPersonName;
    private TextView showPersonName;
    private Button saveButton;

    //variable to be used to save our shared_preference file
    private static final String Prefs_Name = "MyPrefsFiles";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textPersonName = (EditText) findViewById(R.id.getUserName);
        showPersonName = (TextView) findViewById(R.id.savedText);
        saveButton = (Button) findViewById(R.id.saveBtn);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences myPrefs = getSharedPreferences(Prefs_Name, 0);

                //the editor is what we use to share or add items
                //to our shared preferences
                SharedPreferences.Editor editor = myPrefs.edit();

                if(textPersonName.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "[Please enter a name",
                                    Toast.LENGTH_LONG).show();
                } else {
                    //takes value from editText and puts it in editor
                    editor.putString("name", textPersonName.getText().toString());
                    //important that you commit after editor
                    editor.commit();
                }
            }
        });

        //getData back
        SharedPreferences prefs = getSharedPreferences(Prefs_Name, 0);

        if(prefs.contains("name")){
            String userName = prefs.getString("name", "not found");
            showPersonName.setText("You are " + userName);
        } else{
            showPersonName.setText("");
        }
    }
}
