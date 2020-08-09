package com.example.svp2.widget;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/**
 * Description：自定义recyclerview
 * Date：2019/7/12
 */
public class MyRecyclerView2 extends RecyclerView {
    private final Context mCtx;
    public boolean isScrollRefresh;
    public boolean isScrollLoad;

    public MyRecyclerView2(@NonNull Context context) {
        this(context, null);
    }

    public MyRecyclerView2(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyRecyclerView2(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        this.mCtx = context;

        init();
    }

    private void init() {
        setVerticalFadingEdgeEnabled(false);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setOverScrollMode(OVER_SCROLL_NEVER);
        setItemAnimator(new DefaultItemAnimator());
    }

    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private LinearLayoutManager mLinearLayoutManager;
    private GridLayoutManager mGridLayoutManager;

    public void setMyLayoutManager(LayoutManager _layoutManager) {
        if (_layoutManager instanceof StaggeredGridLayoutManager) {
            mStaggeredGridLayoutManager = (StaggeredGridLayoutManager) _layoutManager;
        } else if (_layoutManager instanceof GridLayoutManager) {
            mGridLayoutManager = (GridLayoutManager) _layoutManager;
        } else if (_layoutManager instanceof LinearLayoutManager) {
            mLinearLayoutManager = (LinearLayoutManager) _layoutManager;
        }
        setLayoutManager(_layoutManager);
        if (!isVertical()) {
            throw new UnsupportedOperationException("必须是vertical");
        }
    }

    private boolean isVertical() {
        if (mLinearLayoutManager != null) {
            return mLinearLayoutManager.getOrientation() == LinearLayoutManager.VERTICAL;
        } else if (mStaggeredGridLayoutManager != null) {
            return mStaggeredGridLayoutManager.getOrientation() == StaggeredGridLayoutManager.VERTICAL;
        } else if (mGridLayoutManager != null) {
            return mGridLayoutManager.getOrientation() == GridLayoutManager.VERTICAL;
        }
        return false;
    }

    /**
     * 是否是第一个元素
     * @return
     */
    public boolean isFirstPosition() {
        LayoutManager layoutManager = getLayoutManager();
        int firstPos = -1;
        if (layoutManager instanceof GridLayoutManager) {
            firstPos = ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int[] into = new int[staggeredGridLayoutManager.getSpanCount()];
            into = staggeredGridLayoutManager.findFirstVisibleItemPositions(into);
            firstPos = findMix(into);
        } else {
            firstPos = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        return firstPos == 0;
    }

    /**
     * 找最小的元素
     * @param _arr
     * @return
     */
    private int findMix(int[] _arr) {
        int min = _arr[0];
        for (int v : _arr) {
            if (v < min) {
                min = v;
            }
        }
        return min;
    }

    /**
     * 是否是最后一个元素
     * @return
     */
    public boolean isLastPosition() {
        LayoutManager layoutManager = getLayoutManager();
        int lastPos = -1;
        if (layoutManager instanceof GridLayoutManager) {
            lastPos = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int[] into = new int[staggeredGridLayoutManager.getSpanCount()];
            into = staggeredGridLayoutManager.findLastVisibleItemPositions(into);
            lastPos = findMax(into);
        } else {
            lastPos = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        return lastPos == layoutManager.getItemCount() - 1;
    }

    private int findMax(int[] _arrs) {
        int max = _arrs[0];
        for (int v : _arrs) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    public boolean isOrientation(int _orientation) {
        if (_orientation == 0) {
            return isCanPullDown();
        } else if (_orientation == 1) {
            return isCanPullUp();
        }
        return false;
    }

    private boolean isCanPullDown() {
        return !canScrollVertically(-1);
    }

    private boolean isCanPullUp() {
        return !canScrollVertically(1);
    }
}
