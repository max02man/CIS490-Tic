package com.hawsawi02.alaa.tic;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button a1,a2,a3,b1,b2,b3,c1,c2,c3,rest;
    Button[] bArray;
    boolean turn = true;
    int turn_count = 0;
    private TextView result;
    private TextView who_turn;

/*    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("message", "This is my message to be saved when activity is restarted.");
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*        if (savedInstanceState == null) {
            savedInstanceState .getString("message");
        }
        else*/
        a1 = (Button) findViewById(R.id.A1);
        a2 = (Button) findViewById(R.id.A2);
        a3 = (Button) findViewById(R.id.A3);
        b1 = (Button) findViewById(R.id.B1);
        b2 = (Button) findViewById(R.id.B2);
        b3 = (Button) findViewById(R.id.B3);
        c1 = (Button) findViewById(R.id.C1);
        c2 = (Button) findViewById(R.id.C2);
        c3 = (Button) findViewById(R.id.C3);
        rest = (Button) findViewById(R.id.Rest);
        result = (TextView) findViewById(R.id.winner_box);
        who_turn =(TextView) findViewById(R.id.turn);

        bArray =new Button[]{a1,a2,a3,b1,b2,b3,c1,c2,c3};

        for (Button b :bArray){
            b.setOnClickListener(this);
        }
        who_turn.setText("X Turn");
        rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn=true;
                turn_count =0;
                disableallbutton(true);
                result.setText("");
            }
        });
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        buttonClicked(b);
    }

    private void buttonClicked(Button b) {
        if (turn){
            who_turn.setText("O Turn");
            b.setText("X");
            b.setTextColor(Color.WHITE);
        }else {
            who_turn.setText("X Turn");
            b.setText("O");
            b.setTextColor(Color.WHITE);
        }
        turn_count ++;

        b.setBackgroundColor(Color.BLACK);
        b.setClickable(false);
        turn =!turn;
        CheckForWinner();
        }

    private void CheckForWinner() {
        boolean theWinner =false;
        if(a1.getText() ==a2.getText() && a2.getText() ==a3.getText()
                && !a1.isClickable())
            theWinner =true;
        else if(b1.getText() ==b2.getText() && b2.getText() ==b3.getText()
                && !b1.isClickable())
            theWinner =true;
         else if(c1.getText() ==c2.getText() && c2.getText() ==c3.getText()
                && !c1.isClickable())
            theWinner = true;
        else if(a1.getText() ==b1.getText() && b1.getText() ==c1.getText()
                && !a1.isClickable())
            theWinner = true;
        else if(a2.getText() ==b2.getText() && b2.getText() ==c2.getText()
                && !b2.isClickable())
            theWinner = true;
        else if(a3.getText() ==b3.getText() && b3.getText() ==c3.getText()
                && !c3.isClickable())
            theWinner = true;
        else if(a1.getText() ==b2.getText() && b2.getText() ==c3.getText()
                && !a1.isClickable())
            theWinner = true;
        else if(a3.getText() ==b2.getText() && b2.getText() ==c1.getText()
                && !b2.isClickable())
            theWinner = true;

        if(theWinner) {
            if (!turn) {
                result.setText("X is winner");
                toast("X is winner");
                who_turn.setText("");
            } else{
                result.setText("O is winner");
                who_turn.setText("");
                toast("O is winner");
            }
            disableallbutton(false);
        }else if (turn_count==9) {
            result.setText("Drew");
            who_turn.setText("");
            toast("Drew"); }
    }

    private void disableallbutton(boolean enable) {
        for (Button b: bArray){
            b.setClickable(enable);
            if (enable) {
                b.setBackgroundColor(Color.RED);
                b.setText("");
            }
            else
                b.setBackgroundColor(Color.BLACK);
        }
    }


    private void toast (String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}
