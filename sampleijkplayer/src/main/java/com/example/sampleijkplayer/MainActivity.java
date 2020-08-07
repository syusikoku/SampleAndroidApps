package com.example.sampleijkplayer;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;

import java.io.IOException;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;
import tv.danmaku.ijk.media.player.IMediaPlayer;

@RuntimePermissions
public class MainActivity extends AppCompatActivity implements VideoPlayerListener,
        View.OnClickListener {

    private VideoPlayerFrame videoPlayerFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListener();
//        initPlayer();
    }

    private void addListener() {
        findViewById(R.id.btn_test_multi).setOnClickListener(this);
        findViewById(R.id.btn_test_single).setOnClickListener(this);
    }

    private void initPlayer() {
        videoPlayerFrame = findViewById(R.id.videoplayer);
//        videoPlayerFrame.setPath("http://223.110.242.130:6610/gitv/live1/G_CCTV-1-HQ/1.m3u8");
        videoPlayerFrame.setPath("http://116.62.69.84:8085/Upload/VideoFile/20200802/122854304" +
                ".mp4");
        videoPlayerFrame.setVideoListener(this);
        try {
            videoPlayerFrame.load();
        } catch (IOException e) {
            Log.e("test", "播放失败");
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
//        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        }
        super.onResume();

    }

    @Override
    public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {

    }

    @Override
    public void onCompletion(IMediaPlayer iMediaPlayer) {

    }

    @Override
    public boolean onError(IMediaPlayer iMediaPlayer, int i, int i1) {
        videoPlayerFrame.stop();
        videoPlayerFrame.release();
        return false;
    }

    @Override
    public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i1) {
        return false;
    }

    @Override
    public void onPrepared(IMediaPlayer iMediaPlayer) {
        videoPlayerFrame.start();
    }

    @Override
    public void onSeekComplete(IMediaPlayer iMediaPlayer) {

    }

    @Override
    public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i1, int i2, int i3) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_test_single:
                testSingle();
                break;
            case R.id.btn_test_multi:
                testMulti();
                break;
        }
    }

    @NeedsPermission({Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE})
    public void testMulti() {
        Log.e("test", "testMulti");
    }

    @NeedsPermission(Manifest.permission.CAMERA)
    public void testSingle() {
        Log.e("test", "testSingle");
        PictureSelector.create(this)
                .openCamera(PictureMimeType.ofImage())
                .forResult(PictureConfig.REQUEST_CAMERA);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode,
                grantResults);
    }

}
