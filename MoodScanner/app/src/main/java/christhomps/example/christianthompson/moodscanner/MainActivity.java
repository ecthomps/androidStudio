package christhomps.example.christianthompson.moodscanner;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView thumbImage;
    private TextView moodText;
    private AnimationDrawable thumbAnimation;
    private String[] moods;

    //lets you delay certain actions(animation) for a short period of time
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        moods = new String[]{
                "Someone is cranky",
                "You are my sunshine",
                "No comments...",
                "You are stressed out",
                "Happy Camper :)",
                "Not your day :(",
                "Smile - it's good for you",
                "In the clouds...", "Pensive",
                "Sad", "Excited"
        };

        thumbImage = (ImageView) findViewById(R.id.thumbPrint);
        //setting thumbPrint background to hold the animated_bg
        thumbImage.setBackgroundResource(R.drawable.thumb_animation);

        //getting the drawable background and assign to thumbAnimation
        thumbAnimation = (AnimationDrawable) thumbImage.getBackground();

        moodText = (TextView) findViewById(R.id.result);

        //delays click action before showing output
        thumbImage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                //start Animation
                thumbAnimation.start();

                showResult();

                return true;
            }
        });
    }

    public void showResult(){

        mRunnable = new Runnable() {
            @Override
            public void run() {
                int rand =  (int) (Math.random() * moods.length);
                moodText.setText(moods[rand]);

                //stop Animation
                thumbAnimation.stop();
            }
        };

        //Handler(does a lot of things) lets you post-delay or responses
        Handler mHandler = new Handler();

        //handles the onImageClick delay response
        mHandler.postDelayed(mRunnable, 5000);
    }
}
