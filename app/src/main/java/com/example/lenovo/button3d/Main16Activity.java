package com.example.lenovo.button3d;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Main16Activity extends AppCompatActivity implements View.OnClickListener {
// level - 15
static int goal = 10;
    public int  result = 9;
    static int moves = 5 ;
    static int count15 = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16);
        Button clear=(Button)findViewById(R.id.bclear);
        ImageButton setting =(ImageButton)findViewById(R.id.setting);
        Button black1= (Button)findViewById(R.id.black1);
        Button black2= (Button)findViewById(R.id.black2);
        Button black3= (Button)findViewById(R.id.black3);
        Button b1= (Button)findViewById(R.id.b1);
        Button b2= (Button)findViewById(R.id.b2);
        Button b3= (Button)findViewById(R.id.b3);
        Button b4=(Button)findViewById(R.id.b4);
        TextView Result=(TextView)findViewById(R.id.answer);
        TextView Goal=(TextView)findViewById(R.id.goal);
        TextView Level=(TextView)findViewById(R.id.level);
        TextView move = (TextView)findViewById(R.id.moves);
        black1.setOnClickListener(this);
        black2.setOnClickListener(this);
        black3.setOnClickListener(this);
        black1.setText("+5");
        Result.setText(""+result);
        black2.setText("x5");
        black3.setText("+/-");
        Goal.setText("GOAL : 10");
        Level.setText("LEVEL 15");
        b1.setEnabled(false);
        b2.setEnabled( false );
        b3.setEnabled(false);
        move.setText("MOVES :"+moves);
        Result.setText(""+result);
        b4.setEnabled(false);
        TextView myTextView = (TextView) findViewById(R.id.answer);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/digital.ttf");
        myTextView.setTypeface(typeface);
        //black3.setEnabled(false);

    }

    @Override
    public void onClick(View v) {
        if (moves > 0) {
            Button clear=(Button)findViewById(R.id.bclear);
            TextView Result = (TextView) findViewById(R.id.answer);
            TextView move = (TextView) findViewById(R.id.moves);

            switch (v.getId()) {

                case R.id.black1:{

                    final MediaPlayer mp = MediaPlayer.create(this, R.raw.bclick);
                    mp.start();
                    result = result + 5  ;
                    Result.setText("" + result);
                    --moves;
                    move.setText("MOVES: " + moves);

                    break;}
                case R.id.black2: {

                    final MediaPlayer mp = MediaPlayer.create(this, R.raw.bclick);
                    mp.start();
                    result = result * 5;
                    Result.setText("" + result);
                    --moves;
                    move.setText("MOVES: " + moves);
                    break;
                }
                case R.id.black3: {

                    final MediaPlayer mp = MediaPlayer.create(this, R.raw.bclick);
                    mp.start();
                    result *=-1 ;
                    Result.setText("" + result);
                    --moves;
                    move.setText("MOVES: " + moves);
                    break;
                }



            }

            if (goal == result) {
                Result.setText("YOU WIN");
                count15 = count15+10;
                new Handler().postDelayed( new Runnable() {
                    @Override
                    public void run() {

                        Intent i=new Intent(Main16Activity.this,Main9Activity.class);
                        finish();
                        startActivity(i);
                    }
                }, 450);
            }
            else{
                if(moves==0&&goal!=result)
                {
                    Result.setTextSize(65);
                    Result.setText("YOU LOOSE");
                }
            }

        }
    }
    public void bclear(View view){
        clear();
    }
    public void clear(){
        TextView Result = (TextView) findViewById(R.id.answer);
        TextView move = (TextView) findViewById(R.id.moves);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.bclick);
        mp.start();
        count15 = count15-5;

        moves = 5;
        result = 9;
        Result.setText("" + result);
        move.setText("MOVES: " + moves);
    }
    public void setClick(View view)
    {

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.bclick);
        mp.start();
        Intent i=new Intent(Main16Activity.this,SettingActivity.class);
        TextView Level=(TextView)findViewById(R.id.level);
        i.putExtra("level15", count15);
        i.putExtra("calling-activity", MainActivity.ActivityConstants.ACTIVITY_15);
        i.putExtra("textViewText", Level.getText().toString());
        startActivity(i);
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

