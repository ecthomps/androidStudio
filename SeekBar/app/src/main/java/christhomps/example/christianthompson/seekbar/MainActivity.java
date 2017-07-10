package christhomps.example.christianthompson.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView nicenessTextView;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nicenessTextView = (TextView) findViewById(R.id.niceId);
        seekBar = (SeekBar) findViewById(R.id.seekBarId);

        nicenessTextView.setText("Niceness: "+ seekBar.getProgress() +
                                 "/" + seekBar.getMax());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                nicenessTextView.setText("Niceness " + progress + "/" +
                                         seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //tracks to see if user has started moving
                //the seekBar thumb/circle

                Toast.makeText(getApplicationContext(), "startTracking",
                               Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //called when the user stops moving the
                //seeBar thumb/circle
                
                Toast.makeText(getApplicationContext(), "stopTracking",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
