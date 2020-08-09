package com.example.svp2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.svp2.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NewMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_newmain);
    }

    public void testViewpager2(View view) {
        startActivity(new Intent(this, ViewPager2Activity.class));
    }

    public void testVerticalViewpager(View view) {
        startActivity(new Intent(this, VerticalViewPagerActivity.class));
    }

    public void mockVpByRv(View view) {
        startActivity(new Intent(this, MockVpByRvList.class));
    }
}
