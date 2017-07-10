package scorekeeper.example.christianthompson.alertdialogs;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private Button showDialog;
    private AlertDialog.Builder dialog;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialog = (Button) findViewById(R.id.showButtonId);

        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show AlertDialogs
                dialog = new AlertDialog.Builder(MainActivity.this);

                //show Title
                dialog.setTitle(getResources().getString(R.string.dialog_message));

                //show message
                dialog.setMessage(getResources().getString(R.string.dialog_message));

                //set cancelable --> lets users cancel dialog only by clicking
                //dialog button

                //set an Icon
                //dialog.setIcon(android.R.drawable.btn_star);

                //set an Image
                ImageView image = new ImageView(MainActivity.this);
                image.setImageResource(R.drawable.images);
                dialog.setView(image);

                //dialogs has two buttons...a positive btn for YES
                                          //a negative btn for NO
                dialog.setPositiveButton(getResources().getString(R.string.positive_btn),

                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                //Exit our Activity
                                MainActivity.this.finish();
                            }
                        });

                dialog.setNegativeButton(getResources().getString(R.string.negative_btn),

                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.cancel();
                            }
                        });

                //create dialog
                AlertDialog alertD = dialog.create();

                //show dialog
                alertD.show();
            }
        });
    }
}
