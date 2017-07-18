package christhomps.example.christianthompson.dogorcatperson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView result;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = (TextView) findViewById(R.id.petLoverId);
        imageView = (ImageView) findViewById(R.id.showPet);

        Bundle extras = getIntent().getExtras();

        if(extras != null){

            int catResults = extras.getInt("catCounter");
            int dogResults = extras.getInt("dogCounter");

            if(catResults > dogResults){
                result.setText("Cat Lover!!!");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.cat));
            } else if(dogResults > catResults){
                result.setText("Dog Lover!!!");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.dog));
            } else{
                result.setText("NEITHER!!!");
            }
        }
    }
}
