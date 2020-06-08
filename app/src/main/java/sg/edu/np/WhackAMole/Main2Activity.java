package sg.edu.np.WhackAMole;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 8.
        - The function doCheck() takes in button selected and computes a hit or miss and adjust the score accordingly.
        - The functions readTimer() and placeMoleTimer() are to inform the user X seconds before starting and loading new mole.
        - Feel free to modify the function to suit your program.
    */

    private Button Button1;
    private Button Button2;
    private Button Button3;
    private Button Button4;
    private Button Button5;
    private Button Button6;
    private Button Button7;
    private Button Button8;
    private Button Button9;
    private static final String TAG = "Whack-A-Mole 2.0!";
    private int score;
    private CountDownTimer myCountDown;
    private CountDownTimer MoleCountDown;



    private void readyTimer(){
        /*  HINT:
            The "Get Ready" Timer.
            Log.v(TAG, "Ready CountDown!" + millisUntilFinished/ 1000);
            Toast message -"Get Ready In X seconds"
            Log.v(TAG, "Ready CountDown Complete!");
            Toast message - "GO!"
            belongs here.
            This timer countdown from 10 seconds to 0 seconds and stops after "GO!" is shown.
         */
        myCountDown = new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                Log.v(TAG, "Ready CountDown!" + millisUntilFinished / 1000);
                Toast.makeText(getApplicationContext(), "Get Ready In " + millisUntilFinished / 1000 + " seconds!", Toast.LENGTH_SHORT).show();

            }

            public void onFinish() {
                Log.v(TAG, "Ready CountDown!0");
                Log.v(TAG, "Ready CountDown Complete!");
                Toast.makeText(getApplicationContext(), "GO!", Toast.LENGTH_SHORT).show();
                myCountDown.cancel();
                placeMoleTimer();
            }
        };
        myCountDown.start();
    }
    private void placeMoleTimer(){
        /* HINT:
           Creates new mole location each second.
           Log.v(TAG, "New Mole Location!");
           setNewMole();
           belongs here.
           This is an infinite countdown timer.
         */
        MoleCountDown = new CountDownTimer(1000, 1000) {
            public void onTick(long millisUntilFinished) {
                setNewMole();
                Log.v(TAG, "New Mole Location!");
            }

            public void onFinish() {
                MoleCountDown.cancel();
                MoleCountDown.start();
            }
        };
        MoleCountDown.start();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*Hint:
            This starts the countdown timers one at a time and prepares the user.
            This also prepares the existing score brought over.
            It also prepares the button listeners to each button.
            You may wish to use the for loop to populate all 9 buttons with listeners.
         */

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Log.v(TAG, "Current User Score: " + String.valueOf(advancedScore));

        final TextView Total = (TextView) findViewById(R.id.total);

        Button1 = (Button) findViewById(R.id.button1);
        Button2 = (Button) findViewById(R.id.button2);
        Button3 = (Button) findViewById(R.id.button3);
        Button4 = (Button) findViewById(R.id.button4);
        Button5 = (Button) findViewById(R.id.button5);
        Button6 = (Button) findViewById(R.id.button6);
        Button7 = (Button) findViewById(R.id.button7);
        Button8 = (Button) findViewById(R.id.button8);
        Button9 = (Button) findViewById(R.id.button9);
        Intent result = getIntent();
        String previous = result.getStringExtra("Score");
        Total.setText(previous);
        score = Integer.valueOf(previous);
        Total.setText(previous);
        Log.v(TAG, "Current User Score: " + previous);
        readyTimer();

        Button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                doCheck(Button1);
                Button1.setText("O");
                Button2.setText("O");
                Button3.setText("O");
                Button4.setText("O");
                Button5.setText("O");
                Button6.setText("O");
                Button7.setText("O");
                Button8.setText("O");
                Button9.setText("O");
                placeMoleTimer();
            }
        });

        Button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                doCheck(Button2);
                Button1.setText("O");
                Button2.setText("O");
                Button3.setText("O");
                Button4.setText("O");
                Button5.setText("O");
                Button6.setText("O");
                Button7.setText("O");
                Button8.setText("O");
                Button9.setText("O");
                placeMoleTimer();
            }
        });

        Button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                doCheck(Button3);
                Button1.setText("O");
                Button2.setText("O");
                Button3.setText("O");
                Button4.setText("O");
                Button5.setText("O");
                Button6.setText("O");
                Button7.setText("O");
                Button8.setText("O");
                Button9.setText("O");
                placeMoleTimer();
            }
        });

        Button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                doCheck(Button4);
                Button1.setText("O");
                Button2.setText("O");
                Button3.setText("O");
                Button4.setText("O");
                Button5.setText("O");
                Button6.setText("O");
                Button7.setText("O");
                Button8.setText("O");
                Button9.setText("O");
                placeMoleTimer();
            }
        });

        Button5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                doCheck(Button5);
                Button1.setText("O");
                Button2.setText("O");
                Button3.setText("O");
                Button4.setText("O");
                Button5.setText("O");
                Button6.setText("O");
                Button7.setText("O");
                Button8.setText("O");
                Button9.setText("O");
                placeMoleTimer();
            }
        });

        Button6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                doCheck(Button6);
                Button1.setText("O");
                Button2.setText("O");
                Button3.setText("O");
                Button4.setText("O");
                Button5.setText("O");
                Button6.setText("O");
                Button7.setText("O");
                Button8.setText("O");
                Button9.setText("O");
                placeMoleTimer();
            }
        });

        Button7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                doCheck(Button7);
                Button1.setText("O");
                Button2.setText("O");
                Button3.setText("O");
                Button4.setText("O");
                Button5.setText("O");
                Button6.setText("O");
                Button7.setText("O");
                Button8.setText("O");
                Button9.setText("O");
                placeMoleTimer();
            }
        });

        Button8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                doCheck(Button8);
                Button1.setText("O");
                Button2.setText("O");
                Button3.setText("O");
                Button4.setText("O");
                Button5.setText("O");
                Button6.setText("O");
                Button7.setText("O");
                Button8.setText("O");
                Button9.setText("O");
                placeMoleTimer();
            }
        });

        Button9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                doCheck(Button9);
                Button1.setText("O");
                Button2.setText("O");
                Button3.setText("O");
                Button4.setText("O");
                Button5.setText("O");
                Button6.setText("O");
                Button7.setText("O");
                Button8.setText("O");
                Button9.setText("O");
                placeMoleTimer();
            }
        });
    }


    @Override
    protected void onStart(){
        super.onStart();
    }
    private void doCheck(Button checkButton)
    {
        /* Hint:
            Checks for hit or miss
            Log.v(TAG, "Hit, score added!");
            Log.v(TAG, "Missed, point deducted!");
            belongs here.
        */
        final TextView Total = (TextView) findViewById(R.id.total);
        if (checkButton.getText() == "*"){
            Log.v(TAG,"Hit, score added!");
            score += 1;
            Total.setText(Integer.toString(score));
        } else {
            Log.v(TAG,"Miss, point deducted!");
            score -= 1;
            Total.setText(Integer.toString(score));
        }
    }

    public void setNewMole()
    {
        /* Hint:
            Clears the previous mole location and gets a new random location of the next mole location.
            Sets the new location of the mole.
         */
        Random ran = new Random();
        int randomLocation = ran.nextInt(9);
        if (randomLocation == 0){
            Button1.setText("O");
            Button2.setText("O");
            Button3.setText("O");
            Button4.setText("O");
            Button5.setText("O");
            Button6.setText("O");
            Button7.setText("O");
            Button8.setText("O");
            Button9.setText("O");
            Button1.setText("*");
        } else if (randomLocation == 1){
            Button1.setText("O");
            Button2.setText("O");
            Button3.setText("O");
            Button4.setText("O");
            Button5.setText("O");
            Button6.setText("O");
            Button7.setText("O");
            Button8.setText("O");
            Button9.setText("O");
            Button2.setText("*");
        } else if (randomLocation == 2){
            Button1.setText("O");
            Button2.setText("O");
            Button3.setText("O");
            Button4.setText("O");
            Button5.setText("O");
            Button6.setText("O");
            Button7.setText("O");
            Button8.setText("O");
            Button9.setText("O");
            Button3.setText("*");
        }else if (randomLocation == 3){
            Button1.setText("O");
            Button2.setText("O");
            Button3.setText("O");
            Button4.setText("O");
            Button5.setText("O");
            Button6.setText("O");
            Button7.setText("O");
            Button8.setText("O");
            Button9.setText("O");
            Button4.setText("*");
        }else if (randomLocation == 4){
            Button1.setText("O");
            Button2.setText("O");
            Button3.setText("O");
            Button4.setText("O");
            Button5.setText("O");
            Button6.setText("O");
            Button7.setText("O");
            Button8.setText("O");
            Button9.setText("O");
            Button5.setText("*");
        }else if (randomLocation == 5){
            Button1.setText("O");
            Button2.setText("O");
            Button3.setText("O");
            Button4.setText("O");
            Button5.setText("O");
            Button6.setText("O");
            Button7.setText("O");
            Button8.setText("O");
            Button9.setText("O");
            Button6.setText("*");
        }else if (randomLocation == 6){
            Button1.setText("O");
            Button2.setText("O");
            Button3.setText("O");
            Button4.setText("O");
            Button5.setText("O");
            Button6.setText("O");
            Button7.setText("O");
            Button8.setText("O");
            Button9.setText("O");
            Button7.setText("*");
        }else if (randomLocation == 7){
            Button1.setText("O");
            Button2.setText("O");
            Button3.setText("O");
            Button4.setText("O");
            Button5.setText("O");
            Button6.setText("O");
            Button7.setText("O");
            Button8.setText("O");
            Button9.setText("O");
            Button8.setText("*");
        }else{
            Button1.setText("O");
            Button2.setText("O");
            Button3.setText("O");
            Button4.setText("O");
            Button5.setText("O");
            Button6.setText("O");
            Button7.setText("O");
            Button8.setText("O");
            Button9.setText("O");
            Button9.setText("*");
        }
    }
}

