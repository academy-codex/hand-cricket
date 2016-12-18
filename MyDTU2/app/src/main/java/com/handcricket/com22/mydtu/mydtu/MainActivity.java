package com.handcricket.com22.mydtu.mydtu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.handcricket.com22.mydtu.R;


public class MainActivity extends Activity {

    public void nextScreen(View view){
            Intent newScreen = new Intent(MainActivity.this, GamePlay.class);
            startActivity(newScreen);

    }

    public void about(View view){
        Intent aboutScreen= new Intent(MainActivity.this,about.class);
        startActivity(aboutScreen);
    }

    public void howtoplay(View view){
        Intent howToPlayScreen=new Intent(MainActivity.this,howtoplay.class);
        startActivity(howToPlayScreen);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
