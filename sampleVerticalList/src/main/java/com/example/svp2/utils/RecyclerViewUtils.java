package com.example.svp2.utils;

import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class RecyclerViewUtils {

    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private LinearLayoutManager mLinearLayoutManager;
    private GridLayoutManager mGridLayoutManager;

    //<editor-fold desc="内容工具">
    public static int measureViewHeight(View view) {
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p == null) {
            p = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        int childHeightSpec;
        int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0, p.width);
        if (p.height > 0) {
            childHeightSpec = View.MeasureSpec.makeMeasureSpec(p.height, View.MeasureSpec.EXACTLY);
        } else {
            childHeightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        }
        view.measure(childWidthSpec, childHeightSpec);
        return view.getMeasuredHeight();
    }

    public void setMyLayoutManager(RecyclerView.LayoutManager _layoutManager) {
        if (_layoutManager instanceof StaggeredGridLayoutManager) {
            mStaggeredGridLayoutManager = (StaggeredGridLayoutManager) _layoutManager;
        } else if (_layoutManager instanceof GridLayoutManager) {
            mGridLayoutManager = (GridLayoutManager) _layoutManager;
        } else if (_layoutManager instanceof LinearLayoutManager) {
            mLinearLayoutManager = (LinearLayoutManager) _layoutManager;
        }
//        setLayoutManager(_layoutManager);
//        if (!isVertical()) {
//            throw new UnsupportedOperationException("必须是vertical");
//        }
    }

    /**
     * 是否是第一个元素
     * @return
     */
    public boolean isFirstPosition(RecyclerView.LayoutManager layoutManager) {
        int firstPos = -1;
        if (layoutManager instanceof GridLayoutManager) {
            firstPos = ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager =
                    (StaggeredGridLayoutManager) layoutManager;
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
    public boolean isLastPosition(RecyclerView.LayoutManager layoutManager) {
        int lastPos = -1;
        if (layoutManager instanceof GridLayoutManager) {
            lastPos = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager =
                    (StaggeredGridLayoutManager) layoutManager;
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

    public boolean isOrientation(RecyclerView recyclerView, int _orientation) {
        if (_orientation == 0) {
            return isCanPullDown(recyclerView);
        } else if (_orientation == 1) {
            return isCanPullUp(recyclerView);
        }
        return false;
    }

    private boolean isCanPullDown(RecyclerView recyclerView) {
        return !recyclerView.canScrollVertically(-1);
    }

    private boolean isCanPullUp(RecyclerView recyclerView) {
        return !recyclerView.canScrollVertically(1);
    }
}
