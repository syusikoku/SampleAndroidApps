package com.example.svp2.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerView extends RecyclerView {

    private final Context mCtx;
    private int mTouchSlop;
    private int scrollPointerId;
    private int initialTouchX;
    private int initialTouchY;

    public MyRecyclerView(Context context) {
        this(context, null);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        ViewConfiguration vc = ViewConfiguration.get(context);
        mTouchSlop = vc.getScaledEdgeSlop();

        this.mCtx = context;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        Log.e("dl", "onInterceptTouchEvent");

        if (e == null)
            return false;

        int action = MotionEventCompat.getActionMasked(e);
        int actionIndex = MotionEventCompat.getActionIndex(e);
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.e("dl", "MotionEvent.ACTION_DOWN");
                scrollPointerId = MotionEventCompat.getPointerId(e, 0);
                initialTouchX = Math.round(e.getX() + 0.5f);
                initialTouchY = Math.round(e.getY() + 0.5f);
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                Log.e("dl", "MotionEvent.ACTION_POINTER_DOWN");
                scrollPointerId = MotionEventCompat.getPointerId(e, actionIndex);
                initialTouchX = Math.round(MotionEventCompat.getX(e, actionIndex) + 0.5f);
                initialTouchY = Math.round(MotionEventCompat.getY(e, actionIndex) + 0.5f);
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("dl", "MotionEvent.ACTION_MOVE");
                int index = MotionEventCompat.findPointerIndex(e, scrollPointerId);
                if (index < 0) {
                    return false;
                }

                int x = Math.round(MotionEventCompat.getX(e, index) + 0.5f);
                int y = Math.round(MotionEventCompat.getY(e, index) + 0.5f);
                // 不是拖拽
                if (getScrollState() != SCROLL_STATE_DRAGGING) {
                    int dx = x - initialTouchX;
                    int dy = y - initialTouchY;

                    boolean startScroll = false;

                    // 水平滑动的处理
                    /*
                    使用下面的。组合成一个
                    if (getLayoutManager().canScrollHorizontally() && Math.abs(dy) > mTouchSlop &&
                            (Math.abs(dx) > Math.abs(dy))) {
                        startScroll = true;
                    }
                    // 垂直滑动的处理
                    if (getLayoutManager().canScrollVertically() && Math.abs(dy) > mTouchSlop &&
                            (Math.abs(dx) > Math.abs(dy))) {
                        startScroll = true;
                    }*/

                    // 如下条件，组合成一个条件,前者条件已经是判断未纵向移动了。那么后面补上横向就行了
                    // 垂直滑动的处理
                    if (getLayoutManager().canScrollVertically() && Math.abs(dy) > mTouchSlop &&
                            (getLayoutManager().canScrollHorizontally() || Math.abs(dx) > Math.abs(dy))) {
                        startScroll = true;
                    }
                    return startScroll && super.onInterceptTouchEvent(e);
                }
                break;
        }
        return super.onInterceptTouchEvent(e);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthSpec, expandSpec);
    }
}
