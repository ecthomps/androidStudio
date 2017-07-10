package scorekeeper.example.christianthompson.scorekeeper;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int p1Score = 0, p2Score = 0, winnigScore;
    private int winner = Color.GREEN;
    private Boolean isGameOver = false;
    private TextView p1Display, p2Display;
    private EditText maxScoreDisplay;
    private Button p1Btn, p2Btn, resetScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1Display = (TextView) findViewById(R.id.p1ScoreId);
        p2Display = (TextView) findViewById(R.id.p2ScoreId);
        maxScoreDisplay = (EditText) findViewById(R.id.maxScoreId);
        p1Btn = (Button) findViewById(R.id.p1BtnId);
        p2Btn = (Button) findViewById(R.id.p2BtnId);
        resetScore = (Button) findViewById(R.id.resBtnId);

        winnigScore = Integer.parseInt(maxScoreDisplay.getText().toString());

        p1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isGameOver){
                    p1Score++;
                    if(p1Score == winnigScore){
                        p1Display.setTextColor(winner);
                        isGameOver = true;
                    }
                    p1Display.setText(p1Score);
                }
            }
        });

        p2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isGameOver){
                    p2Score++;
                    if(p2Score == winnigScore){
                        p2Display.setTextColor(winner);
                        isGameOver = true;
                    }
                    p2Display.setText(p2Score);
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
        isGameOver = false; winner = Color.BLACK;

    }
}
