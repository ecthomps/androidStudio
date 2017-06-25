package picbio.example.christianthompson.showmethebio;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BioActivity extends Activity {

    private ImageView showImage;
    private TextView displayBio, displayName;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);

        showImage = (ImageView) findViewById(R.id.imageViewId);
        displayBio = (TextView) findViewById(R.id.bioTextViewId);
        displayName = (TextView) findViewById(R.id.showNameId);

        extras = getIntent().getExtras();

       if(extras != null){
           String getName = extras.getString("name");
           bioName(getName);
       }
    }

    public void bioName(String mName){

        if(mName.equals("Chris")){
            showImage.setImageDrawable(getResources().getDrawable(R.drawable.tman));
            displayName.setText(mName);
            displayBio.setText(extras.getString(mName));
        } else if(mName.equals("Mary")){
            showImage.setImageDrawable(getResources().getDrawable(R.drawable.mary));
            displayName.setText(mName);
            displayBio.setText(extras.getString(mName));
        }
    }
}
