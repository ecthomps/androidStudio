package imgbio.example.christianthompson.imagebio;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener{

    private ImageView chrisImage, maryImage;
    private String maryBio = "Nationality: American\n\n" + "Major: Nursing\n\n"
            + "Favorite Color: Torquoise\n\n" + "Life Goal: " +
            "Becoming a Pediatrician";
    private String chrisBio = "Nationality: Sierra Leonean\n\n" + "Major: " +
            "Computer Science\n\n" + "Favorite Color: Blue" +
            "Life Goal: Successful App Developer\n\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chrisImage = (ImageView) findViewById(R.id.cImgId);
        maryImage = (ImageView) findViewById(R.id.mImgId);

        chrisImage.setOnClickListener(this);
        maryImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.cImgId:
                Intent chrisIntent = new Intent(MainActivity.this,
                                                ShowBio.class);
                chrisIntent.putExtra("Chris", chrisBio);
                chrisIntent.putExtra("name", "Chris");
                startActivity(chrisIntent);
                break;
            case R.id.mImgId:
                Intent maryIntent = new Intent(MainActivity.this,
                                               ShowBio.class);
                maryIntent.putExtra("Mary", maryBio);
                maryIntent.putExtra("name", "Mary");
                startActivity(maryIntent);
                break;
        }
    }
}
