package com.example.gsyplayer;


/**
 * 可全屏
 */
public class DetailPlayTestActivity3 extends DetailPlayTestActivity2 {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail_play3;
    }


    @Override
    protected void initOthers() {
        setSupportActionBar(findViewById(R.id.toolbar));
    }

    @Override
    protected void onExecEnterFullscreen() {
//        recyclerView.setVisibility(View.GONE);
    }

    @Override
    protected void onQuitEnterFullscreen() {
//        recyclerView.setVisibility(View.VISIBLE);
    }
}
