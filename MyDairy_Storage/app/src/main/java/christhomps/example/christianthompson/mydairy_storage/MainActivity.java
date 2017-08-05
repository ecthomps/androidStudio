package christhomps.example.christianthompson.mydairy_storage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            //check to see if users have entered something
                if(!userText.getText().toString().equals("")){
                    //if no text then write to file
                    String data = userText.getText().toString();
                    writeToFile(data);
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter text",
                                       Toast.LENGTH_SHORT).show();
                }

            }
        });

        //check to see if file existed and display existing content on it
        if(readfromFile() != null){
            userText.setText(readfromFile());
        }
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

    public String readfromFile(){

        String result = "";

        try{

            InputStream inputStream = openFileInput("dairy.txt");

            if( inputStream != null){
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

             //create a bufferRreader to interpret (read and store data) the inputStream further
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String tempString = "";
                StringBuilder stringBuilder = new StringBuilder();

            //assigns value read from bufferRead into tempString
                while ( (tempString =bufferedReader.readLine()) != null){

                    stringBuilder.append(tempString);
                }

                inputStream.close();

                result = stringBuilder.toString();

            }
        } catch(FileNotFoundException e){
            Log.v("MyActivity", "File Not found " + e.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
