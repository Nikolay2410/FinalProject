package com.example.game3072;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GestureDetectorCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static int a = 4;
    public static MatrixGame MG = new MatrixGame(a);
    private TextView textView2;
    private Button undo;
    private Button restart;
    private Button back_menu;
    private View view;
    private GestureDetectorCompat lSwipeDetector;

    private ConstraintLayout main_layout;

    private static final int SWIPE_MIN_DISTANCE = 100;
    private static final int SWIPE_MIN_VELOCITY = 200;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        MG = new MatrixGame(a);

        lSwipeDetector = new GestureDetectorCompat(this, new MySwipeListener());
        main_layout = (ConstraintLayout) findViewById(R.id.main_layout);
        undo = (Button) findViewById(R.id.undo);
        restart = (Button) findViewById(R.id.back);
        back_menu = (Button) findViewById(R.id.back_menu);
        //textView = (TextView) findViewById(R.id.textView);
        //textView.setText(MG.print());
        textView2 = (TextView) findViewById(R.id.textView2);
        MatrixGame.score = 0;
        textView2.setText(MG.printScore());
        view = (View)findViewById(R.id.gameView);

        main_layout.setOnTouchListener((v, event) -> lSwipeDetector.onTouchEvent(event));

        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MatrixGame.score > 5) {
                    MatrixGame.matrix = MG.recentMatrix;
                    textView2.setText(MG.printScore());
                    undo.setClickable(false);
                    undo.setBackgroundColor(Color.GRAY);
                    view.invalidate();
                }
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MG = new MatrixGame(a);
                //textView.setText(MG.print());
                undo.setClickable(true);
                undo.setBackgroundColor(Color.parseColor("#7DCA00"));
                MatrixGame.score = 0;
                textView2.setText(MG.printScore());


                new Thread(() -> view.invalidate()).start();
            }
        });

        View.OnClickListener listener2 = v -> finish();
        back_menu.setOnClickListener(listener2);
    }


    private class MySwipeListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_MIN_VELOCITY) { //вправо
                MG.Right();
            }
            else
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_MIN_VELOCITY) { //влево
                MG.Left();
            }
            else
            if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_MIN_VELOCITY) { //вниз
                MG.Bottom();
            }
            else
            if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_MIN_VELOCITY) { //верх
                MG.Top();
            }
            textView2.setText(MG.printScore());
            new Thread(() -> view.invalidate()).start();
            try {
                if (MatrixGame.Vibration()) {
                    long mills = 1000L;
                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

                    if (vibrator.hasVibrator()) {
                        vibrator.vibrate(mills);
                    }
                }
                if (MatrixGame.checkLose(getApplicationContext())) {
                    Intent intent = new Intent(getApplicationContext(), NewRecord.class);
                    startActivity(intent);
                    finish();
                    //Toast.makeText(getApplicationContext(), "Lose", Toast.LENGTH_SHORT).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
