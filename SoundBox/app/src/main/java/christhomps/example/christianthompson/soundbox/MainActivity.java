package christhomps.example.christianthompson.soundbox;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button playBtn, prevBtn, nextBtn;
    private MediaPlayer mediaPlayer;
    private TextView musicStatus;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.game_field);

        playBtn = (Button) findViewById(R.id.playBtn);
        prevBtn = (Button) findViewById(R.id.prevBtn);
        nextBtn = (Button) findViewById(R.id.nextBtn);

        musicStatus = (TextView) findViewById(R.id.artistName);
        imageView = (ImageView) findViewById(R.id.artistImage);

        playBtn.setOnClickListener(this);
        prevBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.playBtn:
                //playMusic
                if(mediaPlayer.isPlaying()){
                    pauseMusic();
                } else{
                    playMusic();
                }
                break;

            case R.id.prevBtn:
                //doSomething
                break;

            case R.id.nextBtn:
                mediaPlayer = MediaPlayer.create(getApplicationContext(),
                        R.raw.nba);
                break;
        }
    }

    public void playMusic(){

        if(mediaPlayer != null){
            mediaPlayer.start();
            musicStatus.setText(R.string.play_soccer);
            playBtn.setBackgroundDrawable(getResources().
                        getDrawable(android.R.drawable.ic_media_pause));
        }
    }

    public void pauseMusic(){

        if(mediaPlayer != null){
            mediaPlayer.pause();
            musicStatus.setText(R.string.pause_soccer);
            playBtn.setBackgroundDrawable(getResources().
                    getDrawable(android.R.drawable.ic_media_play));
        }
    }

    public void prevMusic(){

        if(mediaPlayer != null){
            imageView.setImageDrawable(getResources().
                          getDrawable(R.drawable.game));
        }
    }

    public void nextMusic(){

        if(mediaPlayer != null){
            imageView.setImageDrawable(getResources().
                    getDrawable(R.drawable.nba));
        }
    }

    @Override
    protected void onDestroy() {

        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
