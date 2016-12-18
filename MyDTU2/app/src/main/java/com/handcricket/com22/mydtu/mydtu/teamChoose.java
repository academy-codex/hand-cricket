package com.handcricket.com22.mydtu.mydtu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.handcricket.com22.mydtu.R;

public class teamChoose extends Activity {

    int i,j;
    public void oteamf(View view)
    {


        if(j==1) {
            if (view.getId() == R.id.button13) {
                GamePlay.oteam = "Yellow";
                j++;
            }
            if (view.getId() == R.id.button14) {
                GamePlay.oteam = "Red";
                j++;
            }
            if (view.getId() == R.id.button15) {
                GamePlay.oteam = "Green";
                j++;
            }
            if (view.getId() == R.id.button16) {
                GamePlay.oteam = "Blue";
                j++;
            }
            Button b=(Button)view;
            int ColorBlack= Color.GRAY;
            int ColorWhite=Color.WHITE;
            b.setBackgroundColor(ColorBlack);
            b.setTextColor(ColorWhite);
        }

            Intent nextActivity=new Intent(this,toss.class);
            startActivity(nextActivity);




    }
    public void pteamf(View view)
    {


        if(i==1) {
            if (view.getId() == R.id.button9) {
                GamePlay.pteam = "Yellow";
                i++;
            }
            if (view.getId() == R.id.button10) {
                GamePlay.pteam = "Red";
                i++;
            }
            if (view.getId() == R.id.button11) {
                GamePlay.pteam = "Green";
                i++;
            }
            if (view.getId() == R.id.button12) {
                GamePlay.pteam = "Blue";
                i++;
            }
            Button b=(Button)view;
            int ColorBlack= Color.GRAY;
            int ColorWhite=Color.WHITE;
            b.setBackgroundColor(ColorBlack);
            b.setTextColor(ColorWhite);
        }



    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_choose);

        i=1;
        j=1;
    }
}
