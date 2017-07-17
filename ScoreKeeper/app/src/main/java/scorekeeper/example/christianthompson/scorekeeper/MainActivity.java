package scorekeeper.example.christianthompson.scorekeeper;

import android.graphics.Color;
import android.graphics.Interpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int p1Score = 0, p2Score = 0, winningScore = 5;
    private Boolean isGameOver = false;
    private TextView p1Display, p2Display;
    private EditText maxScoreDisplay;
    private SeekBar maxScoreVal;
    private Button p1Btn, p2Btn, resetScore;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1Display = (TextView) findViewById(R.id.p1ScoreId);
        p2Display = (TextView) findViewById(R.id.p2ScoreId);
        maxScoreDisplay = (EditText) findViewById(R.id.maxScoreId);
        p1Btn = (Button) findViewById(R.id.p1BtnId);
        p2Btn = (Button) findViewById(R.id.p2BtnId);
        resetScore = (Button) findViewById(R.id.resBtnId);

        maxScoreDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                winningScore = Integer.parseInt(maxScoreDisplay.getText().toString());
                reset();
            }
        });

        p1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isGameOver){
                    p1Score++;
                    if(p1Score == winningScore){
                        isGameOver = true;
                        p1Display.setTextColor(Color.GREEN);
                    }
                    p1Display.setText(Integer.toString(p1Score));
                }
            }
        });

        p2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isGameOver){
                    p2Score++;
                    if(p2Score == winningScore){
                        isGameOver = true;
                        p2Display.setTextColor(Color.GREEN);
                    }
                    p2Display.setText(Integer.toString(p2Score));
                }
            }
        });

        resetScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }

    public void reset(){
        p1Score = 0; p2Score = 0;
        p1Display.setText(Integer.toString(p1Score));
        p2Display.setText(Integer.toString(p2Score));
        isGameOver = false; p1Display.setTextColor(Color.BLACK);
        p2Display.setTextColor(Color.BLACK);
    }
}
