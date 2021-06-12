package com.example.game3072;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GameRecords extends AppCompatActivity {

    private Button back_records;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> listData;
    private DatabaseReference base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_records);

        back_records = findViewById(R.id.back_records);
        back_records.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listView = findViewById(R.id.list);
        listData = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);
        base = FirebaseDatabase.getInstance().getReference("Record");

        getData();
    }

    private void getData() {
        Query query = base.getDatabase().getReference("Record").orderByChild("count");
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (listData.size() > 0)
                    listData.clear();
                base.getDatabase().getReference("Record").orderByValue();
                ArrayList<String> arrayList = new ArrayList<>();
                for (DataSnapshot s: snapshot.getChildren()){
                    Record record = s.getValue(Record.class);
                    assert record != null;
                    arrayList.add(record.toString());
                }
                int j = 1;
                for (int i = arrayList.size() - 1; i >= 0; i--) {
                    listData.add(j + " | " + arrayList.get(i));
                    j++;
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        query.addValueEventListener(vListener);
    }
}
