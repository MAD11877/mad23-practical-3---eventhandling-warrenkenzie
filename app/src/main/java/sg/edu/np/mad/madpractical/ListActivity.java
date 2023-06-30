package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    String TAG = "List activity";

    private int randomnum(){
        Random ran = new Random();
        int myRandomValue = ran.nextInt(999999);
        return myRandomValue;
    }

    private void queryAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(false);
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.v(TAG,"close option");
                finish();
            }
        });
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.v(TAG,"view option");
                Intent myIntent = new Intent(ListActivity.this,MainActivity.class);
                String random_num = Integer.toString(randomnum());
                myIntent.putExtra("random_num",random_num);
                startActivity(myIntent);
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.v(TAG,"Create");

        ImageView image_button = findViewById(R.id.imageViewonclick);

        image_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.v(TAG,"Image button clicked");

                queryAlert();
            }
        });
    }
}