package com.handcricket.com22.mydtu.mydtu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.handcricket.com22.mydtu.R;


public class batting extends Activity {
    Context context;
    public void changeactivity(){
        Intent letsbat = new Intent(context, GameStart.class);
        startActivity(letsbat);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batting);

        if (winning.exitapp == true) {
            finish();
        } else {
            context = this;
            final TextView textView = (TextView) findViewById(R.id.TIMER);
            new CountDownTimer(5000 + 100, 1000) {

                @Override
                public void onTick(long l) {
                    textView.setText(Long.toString(l / 1000));
                }

                @Override
                public void onFinish() {
                    changeactivity();
                }


            }.start();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_batting, menu);
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
