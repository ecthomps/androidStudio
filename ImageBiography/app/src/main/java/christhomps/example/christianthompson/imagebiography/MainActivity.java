package christhomps.example.christianthompson.imagebiography;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView tmanImg, maryImg, cilImg;
    private ImageView loveImg, mannyImg;

    private String maryBio = "Nationality: American\n\n" + "Major: Nursing\n\n"
            + "Favorite Color: Torquois\n\n" + "Life Goal: " +
            "Becoming a Pediatrician";
    private String chrisBio = "Nationality: Sierra Leonean\n\n" + "Major: " +
            "Computer Science\n\n" + "Favorite Color: Blue" +
            "Life Goal: Successful App Developer\n\n";
    private String loveBio = "Nationality: Sierra Leonean\n\n" + "Major: " +
            "Medicine\n\n" + "Favorite Color: Pink" +
            "Life Goal: Become a medical doctor\n\n";
    private String cilBio = "Nationality: American\n\n" + "Major: " +
            "Unknown\n\n" + "Favorite Color: Blue" +
            "Life Goal: Become a leader and empower people\n\n";
    private String mannyBio = "Nationality: American\n\n" + "Major: " +
            "Unknown\n\n" + "Favorite Color: Blue" +
            "Life Goal: Build communities\n\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tmanImg = (ImageView) findViewById(R.id.chrisId);
        maryImg = (ImageView) findViewById(R.id.maryId);
        cilImg = (ImageView) findViewById(R.id.cilId);
        loveImg = (ImageView) findViewById(R.id.loveId);
        mannyImg = (ImageView) findViewById(R.id.mannyId);

        tmanImg.setOnClickListener(this);
        maryImg.setOnClickListener(this);
        cilImg.setOnClickListener(this);
        loveImg.setOnClickListener(this);
        mannyImg.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getApplicationContext(),
                        BioActivity.class);

        switch(v.getId()){
            case R.id.chrisId:
                intent.putExtra("Chris", chrisBio);
                intent.putExtra("name", "Chris");
                Toast.makeText(getApplicationContext(), "Tman", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
            case R.id.maryId:
                intent.putExtra("Mary", maryBio);
                intent.putExtra("name", "Mary");
                Toast.makeText(getApplicationContext(), "Mary", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
            case R.id.cilId:
                intent.putExtra("Cil", cilBio);
                intent.putExtra("name", "Cil");
                Toast.makeText(getApplicationContext(), "Cil", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
            case R.id.loveId:
                intent.putExtra("Love", loveBio);
                intent.putExtra("name", "Love");
                Toast.makeText(getApplicationContext(), "Love", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
            case R.id.mannyId:
                intent.putExtra("Manny", mannyBio);
                intent.putExtra("name", "Manny");
                Toast.makeText(getApplicationContext(), "Manny", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
        }
    }
}
