package christhomps.example.christianthompson.imagebiography;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Christian Thompson on 7/16/2017.
 */

public class BioActivity extends Activity {

    private ImageView showImage;
    private TextView displayBio;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bio);

        showImage = (ImageView) findViewById(R.id.imageId);
        displayBio = (TextView) findViewById(R.id.bioId);

        extras = getIntent().getExtras();

        if(extras != null){
            String getBio = extras.getString("name");
            bioInfo(getBio);
        }
    }

    public void bioInfo(String mName){

        if(mName.equals("Chris")){
            showImage.setImageDrawable(getResources().getDrawable(R.drawable.tman));
            String getBio = extras.getString(mName);
            displayBio.setText(getBio);
        } else if(mName.equals("Mary")){
            showImage.setImageDrawable(getResources().getDrawable(R.drawable.mary));
            String getBio = extras.getString(mName);
            displayBio.setText(getBio);
        } else if(mName.equals("Cil")){
            showImage.setImageDrawable(getResources().getDrawable(R.drawable.cil));
            String getBio = extras.getString(mName);
            displayBio.setText(getBio);
        } else if(mName.equals("Love")){
            showImage.setImageDrawable(getResources().getDrawable(R.drawable.love));
            String getBio = extras.getString(mName);
            displayBio.setText(getBio);
        } else if(mName.equals("Manny")){
            showImage.setImageDrawable(getResources().getDrawable(R.drawable.manny));
            String getBio = extras.getString(mName);
            displayBio.setText(getBio);
        }
    }
}
