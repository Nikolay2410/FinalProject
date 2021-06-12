package com.example.game3072;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewRecord extends AppCompatActivity {

    public Button save;
    public EditText name;
    public EditText count;

    private DatabaseReference base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_record);

        save = findViewById(R.id.saveRecord);
        name = findViewById(R.id.nameRec);
        count = findViewById(R.id.countRec);
        count.setEnabled(false);
        base = FirebaseDatabase.getInstance().getReference("Record");
        count.setText("" + MatrixGame.score);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = base.getKey();
                String recName = name.getText().toString();
                if (!TextUtils.isEmpty(recName))
                {
                    Record record = new Record(id, recName, MatrixGame.score);
                    base.push().setValue(record);
                    Intent intent = new Intent(getApplicationContext(), GameRecords.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Пустое поле", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
