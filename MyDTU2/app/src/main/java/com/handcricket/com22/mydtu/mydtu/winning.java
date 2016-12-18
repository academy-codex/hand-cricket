package com.handcricket.com22.mydtu.mydtu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.handcricket.com22.mydtu.R;


public class winning extends Activity {


  static  boolean exitapp=false;
    TextView pteamname;
    TextView oteamname;
    TextView pteamscore;
    TextView oteamscore;
    TextView pteamstatus;
    TextView oteamstatus;

    public void playagain(View view){
        Intent playagain=new Intent(winning.this,MainActivity.class);
        playagain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(playagain);

    }

    public void home(View view){
        exitapp=true;
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(startMain);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning);

        exitapp=false;
        pteamname=(TextView) findViewById(R.id.textView8);
        oteamname=(TextView) findViewById(R.id.textView20);
        pteamscore=(TextView) findViewById(R.id.textView18);
        oteamscore=(TextView) findViewById(R.id.textView21);
        pteamstatus=(TextView) findViewById(R.id.textView19);
        oteamstatus=(TextView) findViewById(R.id.textView22);

       pteamname.setText("TEAM : "+" "+GamePlay.pteam);
       oteamname.setText("TEAM : "+" "+GamePlay.oteam);
      pteamscore.setText("SCORE : "+" "+Integer.toString(GameStart.score));
      oteamscore.setText("SCORE : "+" "+Integer.toString(GameStart2.score));
        if(decision.win==1) {
           pteamstatus.setText("STATUS : "+" WIN");
            oteamstatus.setText("STATUS : "+" LOSE");
        }

        else if(decision.win==2) {
            oteamstatus.setText("STATUS : "+" WIN");
            pteamstatus.setText("STATUS : "+" LOSE");
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_winning, menu);
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
