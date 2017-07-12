package christhomps.example.christianthompson.togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private ImageView showBaby;
    private TextView babyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = (ToggleButton) findViewById(R.id.toggleButtonId);
        showBaby = (ImageView) findViewById(R.id.babyId);
        babyName = (TextView) findViewById(R.id.nameId);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    showBaby.setVisibility(View.VISIBLE);
                    babyName.setVisibility(View.VISIBLE);
                } else{
                    showBaby.setVisibility(View.INVISIBLE);
                    babyName.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
}
