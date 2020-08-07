package com.example.gsyplayer;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gsyplayer.entry.TestEntry;

import java.util.ArrayList;
import java.util.List;

public class DetailPlayTestActivity4 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail_play4);

        initList();

    }

    private void initList() {
        List<TestEntry> list = new ArrayList<>();
        TestEntry testEntry;
        for (int i = 0; i < 20; i++) {
            testEntry = new TestEntry();
            testEntry.title = "t_" + i;
            list.add(testEntry);
        }
        RecyclerView recyclerView = findViewById(R.id.rvlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TestListAdapter(this, list));
    }

}
