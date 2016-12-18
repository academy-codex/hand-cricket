package com.handcricket.com22.mydtu.mydtu;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.handcricket.com22.mydtu.R;

import java.lang.ref.WeakReference;
import java.util.Random;


public class GameStart extends Activity {
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
    class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {
        private final WeakReference<ImageView> imageViewReference;
        private int data = 0;

        public BitmapWorkerTask(ImageView imageView) {
            // Use a WeakReference to ensure the ImageView can be garbage collected
            imageViewReference = new WeakReference<ImageView>(imageView);
        }

        // Decode image in background.
        @Override
        protected Bitmap doInBackground(Integer... params) {
            data = params[0];
            return decodeSampledBitmapFromResource(getResources(), data, 100, 100);
        }

        // Once complete, see if ImageView is still around and set bitmap.
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (imageViewReference != null && bitmap != null) {
                final ImageView imageView = imageViewReference.get();
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        }
    }


    static int score;
    boolean userandom;
    TextView pturn;
    TextView oturn;
    int nohit;
    int wickets;
    int balls;
    int overs;
    int userValue;
    int compValue;
    TextView outcome;
    TextView SCORE;
    TextView OVERS;
    int hit;

    public void setuserValue(View view){
        if(view.getId()== R.id.one)
            userValue=1;
        else if(view.getId()== R.id.two)
            userValue=2;
        else if(view.getId()== R.id.three)
            userValue=3;
        else if (view.getId()== R.id.four)
            userValue=4;
        else if (view.getId()== R.id.five)
            userValue=5;
        else
            userValue=6;
    }

    public void setcompValue(){
        Random random=new Random();
        if(userandom) {
            compValue = random.nextInt(6) + 1;
            userandom = false;
        }else {
            compValue = (int) (Math.floor(Math.random() * 6)) + 1;
            userandom = true;
        }

        if(hit>=3){
            compValue=random.nextInt(3)+4;
        }

        if(nohit>=4){
            compValue=random.nextInt(6)+1;
            hit=1;
        }
    }

    public void updateStatistics() {
        outcome.setText("");
        //UPDATING BALLS AND OVERS
        if (balls < 5)
            balls++;
        else {
            balls = 0;
            overs++;
        }
        //UPDATING SCORE AND WICKETS
        if (userValue == compValue) {
            wickets++;
            outcome.setText("OUT");
        } else {
            score = score + userValue;
            if (userValue == 4)
                outcome.setText("FOUR!!");
            if (userValue == 6)
                outcome.setText("SIX!");

            if (userValue == 4 || userValue == 5 || userValue == 6) {
                hit++;
            } else
                nohit++;
        }
    }

    public void updateDisplayValues(){

        ImageView pturni=(ImageView) findViewById(R.id.playerTurn);
        ImageView oturni=(ImageView) findViewById(R.id.oppTurn);

        if(userValue==1)
        {
        pturn.setText("1");
            BitmapWorkerTask task = new BitmapWorkerTask(pturni);
            task.execute(R.drawable.myproj);}
        else if(userValue==2)
        {  BitmapWorkerTask task = new BitmapWorkerTask(pturni);
            task.execute(R.drawable.two);
            pturn.setText("2");}
            else if(userValue==3)
        {  BitmapWorkerTask task = new BitmapWorkerTask(pturni);
            task.execute(R.drawable.three);
            pturn.setText("3");}
            else if(userValue==4)
        { BitmapWorkerTask task = new BitmapWorkerTask(pturni);
            task.execute(R.drawable.four);
            pturn.setText("4");}
            else if(userValue==5)
        {  BitmapWorkerTask task = new BitmapWorkerTask(pturni);
            task.execute(R.drawable.five);
            pturn.setText("5");}
            else
        {BitmapWorkerTask task = new BitmapWorkerTask(pturni);
            task.execute(R.drawable.six);
            pturn.setText("6");}

        if(compValue==1)
        {  BitmapWorkerTask task = new BitmapWorkerTask(oturni);
            task.execute(R.drawable.myproj);
            oturn.setText("1");}
        else if(compValue==2)
        {BitmapWorkerTask task = new BitmapWorkerTask(oturni);
            task.execute(R.drawable.two);
            oturn.setText("2");}
        else if(compValue==3)
        {  BitmapWorkerTask task = new BitmapWorkerTask(oturni);
            task.execute(R.drawable.three);
            oturn.setText("3");}
        else if(compValue==4)
        {  BitmapWorkerTask task = new BitmapWorkerTask(oturni);
            task.execute(R.drawable.four);
            oturn.setText("4");}
        else if(compValue==5)
        {  BitmapWorkerTask task = new BitmapWorkerTask(oturni);
            task.execute(R.drawable.five);
            oturn.setText("5");}
        else
        {  BitmapWorkerTask task = new BitmapWorkerTask(oturni);
            task.execute(R.drawable.six);
            oturn.setText("6");}

        updateStatistics();
        SCORE.setText("SCORE: " + Integer.toString(score) + " / " + Integer.toString(wickets));
        OVERS.setText("OVERS: "+Integer.toString(overs)+"."+Integer.toString(balls));


    }
    public void  userInput(View view){
        if(decision.playerplayfirst==true) {
            if (wickets < GamePlay.progress2 && overs < GamePlay.progress) {
                setuserValue(view);
                setcompValue();
                updateDisplayValues();
            } else {
                Intent changeGame = new Intent(this, bowling.class);
                startActivity(changeGame);
            }
        }
        else
        {
            if (wickets < GamePlay.progress2 && overs < GamePlay.progress&& score <= GameStart2.score) {
                setuserValue(view);
                setcompValue();
                updateDisplayValues();
        }
            else if(score>GameStart2.score){
                decision.win=1;
                Intent newintent= new Intent(this,winning.class);
                startActivity(newintent);
            }
            else{
                decision.win=2;
                Intent newintent= new Intent(this,winning.class);
                startActivity(newintent);
            }

    }}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_start);
        if (winning.exitapp == true) {
            finish();
        } else {
            pturn=(TextView)findViewById(R.id.playerturn);
            oturn=(TextView)findViewById(R.id.oppturn);
            balls = 0;
            overs = 0;
            wickets = 0;
            score = 0;

            hit = 0;
            nohit = 0;
            userandom = true;
            SCORE = (TextView) findViewById(R.id.Score);
            OVERS = (TextView) findViewById(R.id.Overs);

            outcome = (TextView) findViewById(R.id.Outcome);
            TextView playerTeamName = (TextView) findViewById(R.id.playerteamname);
            TextView oppTeamName = (TextView) findViewById(R.id.oppteamname);
            playerTeamName.setText(GamePlay.pteam);
            oppTeamName.setText(GamePlay.oteam);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_start, menu);
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
