package com.example.svp2.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewConfiguration;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerView3 extends RecyclerView {

    private final Context mCtx;
    private int mTouchSlop;
    private int scrollPointerId;
    private int initialTouchX;
    private int initialTouchY;

    public MyRecyclerView3(Context context) {
        this(context, null);
    }

    public MyRecyclerView3(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyRecyclerView3(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        ViewConfiguration vc = ViewConfiguration.get(context);
        mTouchSlop = vc.getScaledEdgeSlop();

        this.mCtx = context;
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthSpec, expandSpec);
    }
}
