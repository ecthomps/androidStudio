package picbio.example.christianthompson.showmethebio;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener{

    private ImageView chrisImg, maryImg;
    private String maryBio = "Nationality: American\n" + "Major: Nursing"
                             + "Favorite Color: Torquoise" + "Life Goal: " +
                               "Becoming a Pediatrician";
    private String chrisBio = "Nationality: Sierra Leonean\n" + "Major: " +
                              "Computer Science" + "Favorite Color: Blue" +
                              "Life Goal: Successful App Developer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chrisImg = (ImageView) findViewById(R.id.chrisViewId);
        maryImg = (ImageView) findViewById(R.id.maryViewId);

        chrisImg.setOnClickListener(this);
        maryImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.chrisViewId:
                Intent chrisIntent = new Intent(MainActivity.this,
                                           BioActivity.class);
                chrisIntent.putExtra("Chris", chrisBio);
                chrisIntent.putExtra("name", "Chris");
                startActivity(chrisIntent);
                break;

            case R.id.maryViewId:
                Intent maryIntent = new Intent(MainActivity.this,
                        BioActivity.class);
                maryIntent.putExtra("Mary", maryBio);
                maryIntent.putExtra("name", "Mary");
                startActivity(maryIntent);
                break;
        }

    }
}
