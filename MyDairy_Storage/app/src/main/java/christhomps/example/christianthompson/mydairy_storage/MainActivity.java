package christhomps.example.christianthompson.mydairy_storage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText userText;
    private Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userText = (EditText) findViewById(R.id.editText);
        saveBtn = (Button) findViewById(R.id.saveBtn);
    }

    public void writeToFile(String myData){

        try{

            //try to write to file
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter
                    (openFileOutput("dairy.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(myData);
            outputStreamWriter.close(); //always close your stream
        } catch (IOException e){
            Log.v("MyActivity", e.toString());
        }
    }
}
