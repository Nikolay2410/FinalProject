package com.example.game3072;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

public class MainMenu extends AppCompatActivity {

    private Button Start;
    private Button records;

    public static RadioButton radioButton1;
    public static RadioButton radioButton2;

    public static RadioButton radioButton3;
    public static RadioButton radioButton4;
    public static RadioButton radioButton5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Start = findViewById(R.id.Start);
        records = findViewById(R.id.records);
        radioButton3 = findViewById(R.id.radioButton);
        radioButton4 = findViewById(R.id.radioButton2);
        radioButton5 = findViewById(R.id.radioButton3);
        radioButton1 = findViewById(R.id.radioButton4);
        radioButton2 = findViewById(R.id.radioButton5);

        Start.setOnClickListener(v -> {
                    if(radioButton3.isChecked())
                        MainActivity.a = 3;
                    else
                    if(radioButton4.isChecked())
                        MainActivity.a = 4;
                    else
                    if(radioButton5.isChecked())
                        MainActivity.a = 5;

                    if(radioButton1.isChecked())
                        MatrixGame.g = 2;
                    else if(radioButton2.isChecked())
                        MatrixGame.g = 3;

                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }
        );

        records.setOnClickListener(v -> {
            Intent intent = new Intent(this, GameRecords.class);
            startActivity(intent);
        });
    }
}
