package com.handcricket.com22.mydtu.mydtu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.handcricket.com22.mydtu.R;


public class decision extends Activity {

    static boolean playerplayfirst=true;
    static int win;
    public void decisiontaken(View view){
        if(view.getId()== R.id.batting){
            playerplayfirst=true;
            Intent bat=new Intent(this,batting.class);
            startActivity(bat);
        }
        else {
            playerplayfirst=false;
            Intent bowl=new Intent(this,bowling.class);
            startActivity(bowl);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision);
        if (winning.exitapp == true) {
            finish();
        } else {
            win = 0;
            playerplayfirst = true;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_decision, menu);
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
