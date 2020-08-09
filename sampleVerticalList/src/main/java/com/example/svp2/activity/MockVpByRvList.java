package com.example.svp2.activity;

import android.os.Bundle;

import com.example.svp2.R;
import com.example.svp2.adapter.TestLitAdapter;
import com.example.svp2.widget.news.VpRecyView;

import java.util.Arrays;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MockVpByRvList extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mockvpbyrvlist);

        VpRecyView vpRecyView = findViewById(R.id.rvlist);

        vpRecyView.setAdapter(new TestLitAdapter(Arrays.asList(getResources().getStringArray(R.array.sg_list))));
    }

}
