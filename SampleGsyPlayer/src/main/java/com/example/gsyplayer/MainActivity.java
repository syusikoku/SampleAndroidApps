package com.example.gsyplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_stand).setOnClickListener(this);
        findViewById(R.id.btn_detail).setOnClickListener(this);
        findViewById(R.id.btn_detail2).setOnClickListener(this);
        findViewById(R.id.btn_detail3).setOnClickListener(this);
        findViewById(R.id.btn_detail4).setOnClickListener(this);
    }

    public void changeUI(Class<? extends Activity> tcls) {
        startActivity(new Intent(this, tcls));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_stand:
                changeUI(StandPlayTestActivity.class);
                break;
            case R.id.btn_detail:
                changeUI(DetailPlayTestActivity.class);
                break;
            case R.id.btn_detail2:
                changeUI(DetailPlayTestActivity2.class);
                break;
            case R.id.btn_detail3:
                changeUI(DetailPlayTestActivity3.class);
                break;
            case R.id.btn_detail4:
                changeUI(DetailPlayTestActivity4.class);
                break;
        }
    }
}
