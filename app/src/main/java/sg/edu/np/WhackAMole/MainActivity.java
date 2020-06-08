package sg.edu.np.WhackAMole;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button ButtonLeft;
    private Button ButtonMiddle;
    private Button ButtonRight;
    private static final String TAG = "Whack-A-Mole 1.0!";
    private int score = 0;
    AlertDialog alert;


    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - The function doCheck() takes in button selected and computes a hit or miss and adjust the score accordingly.
        - The function doCheck() also decides if the user qualifies for the advance level and triggers for a dialog box to ask for user to decide.
        - The function nextLevelQuery() builds the dialog box and shows. It also triggers the nextLevel() if user selects Yes or return to normal state if user select No.
        - The function nextLevel() launches the new advanced page.
        - Feel free to modify the function to suit your program.
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG, "Finished Pre-Initialisation!");

        final TextView Score = (TextView) findViewById(R.id.score);

        ButtonLeft = (Button) findViewById(R.id.ButtonLeft);
        ButtonMiddle = (Button) findViewById(R.id.ButtonMiddle);
        ButtonRight = (Button) findViewById(R.id.ButtonRight);

        ButtonLeft.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                doCheck(ButtonLeft);
                setNewMole();
            }
        });

        ButtonMiddle.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                doCheck(ButtonMiddle);
                setNewMole();
            }
        });

        ButtonRight.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                doCheck(ButtonRight);
                setNewMole();
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        Log.v(TAG, "Starting GUI!");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TAG, "Paused Whack-A-Mole!");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TAG, "Stopped Whack-A-Mole!");
    }

    public void setNewMole()
    {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        if (randomLocation == 0){
            Button button = (Button)findViewById(R.id.ButtonLeft);
            button.setText("*");
        } else if (randomLocation == 1){
            Button button = (Button)findViewById(R.id.ButtonMiddle);
            button.setText("*");
        } else{
            Button button = (Button)findViewById(R.id.ButtonRight);
            button.setText("*");
        }
    }

    private void doCheck(Button checkButton) {
        /* Checks for hit or miss and if user qualify for advanced page.
            Triggers nextLevelQuery().
         */
        final TextView Score = (TextView) findViewById(R.id.score);

        if (checkButton == ButtonLeft) {
            Log.v(TAG,"Button Left Clicked!");
        } else if (checkButton == ButtonMiddle) {
            Log.v(TAG,"Button Middle Clicked!");
        } else {
            Log.v(TAG,"Button Right Clicked!");
        }
        if (checkButton.getText() == "*"){
            Log.v(TAG,"Hit, score added!");
            score += 1;
            Score.setText(Integer.toString(score));
        } else {
            Log.v(TAG,"Miss, point deducted!");
            score -= 1;
            Score.setText(Integer.toString(score));
        }
        ButtonLeft.setText("O");
        ButtonMiddle.setText("O");
        ButtonRight.setText("O");
        if (score % 10 == 0){
            nextLevelQuery();
        }
    }

    private void nextLevelQuery() {
        /*
        Builds dialog box here.
        Log.v(TAG, "User accepts!");
        Log.v(TAG, "User decline!");
        Log.v(TAG, "Advance option given to user!");
        belongs here*/

        Log.v(TAG, "Advance option given to user!");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Warning! Insane Whack-A-Mole incoming!");
        builder.setMessage("Would you like to advance to advanced mode?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.v(TAG,"User accepts!");
                nextLevel();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.v(TAG, "User decline!");
            }
        });
        builder.show();
    }
    private void nextLevel(){
        /* Launch advanced page */
        Intent upgrade = new Intent(MainActivity.this,Main2Activity.class);
        TextView Score = (TextView) findViewById(R.id.score);
        String simple = Score.getText().toString();
        upgrade.putExtra("Score", simple);
        startActivity(upgrade);
    }
}