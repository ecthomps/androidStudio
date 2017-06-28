package imgbio.example.christianthompson.imagebio;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShowBio extends Activity {

    private ImageView showImage;
    private TextView showBioName, showBioText;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bio);

        showImage = (ImageView) findViewById(R.id.imgBioId);
        showBioName = (TextView) findViewById(R.id.showBioNameId);
        showBioText = (TextView) findViewById(R.id.bioId);

        extras = getIntent().getExtras();

        if(extras != null){
            String getName = extras.getString("name");
            bioName(getName);
        }
    }

    public void bioName(String mName){
        if(mName == "Chris"){
            showImage.setImageDrawable(getResources().getDrawable(R.drawable.tman));
            String getBio = extras.getString(mName);
            showBioName.setText(mName);
            showBioText.setText(getBio);
        }   else if(mName == "Mary"){
            showImage.setImageDrawable(getResources().getDrawable(R.drawable.mary));
            String getBio = extras.getString(mName);
            showBioName.setText(mName);
            showBioText.setText(getBio);
        }
    }
}
