package com.example.svp2.itemdecoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by zzg on 2017/11/12.
 */

public class LinearSpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int leftRight;
    private int topBottom;
    private ColorDrawable mDivider;

    public LinearSpacesItemDecoration(int leftRight, int topBottom, int mColor) {
        this.leftRight = leftRight;
        this.topBottom = topBottom;
        if (mColor != 0) {
            mDivider = new ColorDrawable(mColor);
        }
    }

    /**
     * 具体的绘制
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (parent.getLayoutManager() != null && parent.getLayoutManager() instanceof LinearLayoutManager) {
            LinearLayoutManager layoutManager = (LinearLayoutManager) parent.getLayoutManager();
            // 没有子view或没有颜色直接返回
            if (mDivider == null || layoutManager.getChildCount() == 0) {
                return;
            }

            int left, right, top, bottom;
            int childCount = parent.getChildCount();
            if (layoutManager.getOrientation() == LinearLayoutManager.VERTICAL) {
                for (int i = 0; i < childCount - 1; i++) {
                    View child = parent.getChildAt(i);
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
                    // 将有颜色的分割线处于中间位置
                    float center = (layoutManager.getTopDecorationHeight(child) - topBottom) / 2;
                    // 计算下边的
                    left = layoutManager.getLeftDecorationWidth(child);
                    right = parent.getWidth() - layoutManager.getLeftDecorationWidth(child);
                    top = (int) (child.getBottom() + layoutParams.bottomMargin + center);
                    bottom = top + topBottom;
                    mDivider.setBounds(left, top, right, bottom);
                    mDivider.draw(c);
                }
            } else {
                for (int i = 0; i < childCount - 1; i++) {
                    View child = parent.getChildAt(i);
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
                    // 将有颜色的分割线处于中间位置
                    float center = (layoutManager.getTopDecorationHeight(child) - leftRight) / 2;
                    // 计算下边的
                    left = (int) (child.getRight() + layoutParams.rightMargin + center);
                    right = left + leftRight;
                    top = layoutManager.getTopDecorationHeight(child);
                    bottom = parent.getHeight() - layoutManager.getTopDecorationHeight(child);
                    mDivider.setBounds(left, top, right, bottom);
                    mDivider.draw(c);
                }

            }


        }
    }

    /**
     * 确定divider的范围
     *
     * 首先判断是VERTICAL还是HORIZONTAL。对于VERTICAL，每一个item必需的是top，left和right，但是最后一个item还
     * 需要bottom。而对于HORIZONTAL，每一个item必需的是top，left和bottom，但是最后一个item还需要right。
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (parent.getLayoutManager() != null && parent.getLayoutManager() instanceof LinearLayoutManager) {
            LinearLayoutManager layoutManager = (LinearLayoutManager) parent.getLayoutManager();
            // 垂直方向
            if (layoutManager.getOrientation() == LinearLayoutManager.VERTICAL) {
                // 最后一项需要bottom
                if (parent.getChildAdapterPosition(view) == layoutManager.getItemCount() - 1) {
                    outRect.bottom = topBottom;
                }
                outRect.top = topBottom;
                outRect.left = leftRight;
                outRect.right = leftRight;
            } else {
                // 最后一项需要right
                if (parent.getChildAdapterPosition(view) == layoutManager.getItemCount() - 1) {
                    outRect.right = leftRight;
                }
                outRect.top = topBottom;
                outRect.left = leftRight;
                outRect.bottom = topBottom;
            }
        }

    }
}
