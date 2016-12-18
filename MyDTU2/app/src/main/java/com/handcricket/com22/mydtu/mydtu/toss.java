package com.handcricket.com22.mydtu.mydtu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.handcricket.com22.mydtu.R;


public class toss extends Activity {
    int i;
    int userchoice=3;
    TextView Timer;
    TextView CoinFlip;
    int textControl=1;
    Context context;
    int compdec;
    Intent playGame1;
    Intent playGame2;

    public void tossit(View view) {
        i = (int) Math.floor(Math.random() * 2);
        context=this;

        if (view.getId() == R.id.heads)
            userchoice = 1;
        else
            userchoice = 0;

        CoinFlip.setText("Flipping Coin");
        new CountDownTimer(5000 + 100, 1000) {
            @Override
            public void onTick(long l) {
                Timer.setText(Long.toString(l / 1000));

                if(textControl<=3)
                {
                    CoinFlip.setText(CoinFlip.getText()+".");
                    textControl++;
                }
                else {
                    textControl = 1;
                    CoinFlip.setText("Flipping Coin");
                }
            }

            @Override
            public void onFinish() {
                Timer.setText("0");
                if (userchoice == i)
                    Toast.makeText(getApplicationContext(), "WON", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "LOST", Toast.LENGTH_LONG).show();

                new CountDownTimer(2000, 1000) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        if(userchoice==i) {
                            Intent playGame = new Intent(context, decision.class);
                            startActivity(playGame);
                        }
                        else
                        {
                            if(compdec==0) {
                                decision.playerplayfirst=false;
                                playGame1 = new Intent(context, bowling.class);
                                startActivity(playGame1);
                            }
                            else{
                                decision.playerplayfirst=true;
                                playGame2 = new Intent(context, batting.class);
                                startActivity(playGame2);
                            }
                        }
                    }
                }.start();
            }

        }.start();



    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toss);
        if (winning.exitapp == true) {
            finish();
        } else {
            Timer = (TextView) findViewById(R.id.Timer);
            CoinFlip = (TextView) findViewById(R.id.coinflip);

            compdec = (int) Math.floor(Math.random() * 2);


        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toss, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
