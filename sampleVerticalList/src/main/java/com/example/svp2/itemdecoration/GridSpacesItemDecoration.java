package com.example.svp2.itemdecoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by zzg on 2017/11/12.
 */

public class GridSpacesItemDecoration extends RecyclerView.ItemDecoration {
    private final int leftRight;
    private final int topBottom;
    private ColorDrawable mDivider;

    public GridSpacesItemDecoration(int leftRight, int topBottom, int color) {
        this.leftRight = leftRight;
        this.topBottom = topBottom;
        if (color != 0) {
            mDivider = new ColorDrawable(color);
        }
    }

    /**
     * 具体的绘制
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (parent.getLayoutManager() != null && parent.getLayoutManager() instanceof GridLayoutManager) {
            GridLayoutManager layoutManager = (GridLayoutManager) parent.getLayoutManager();
            if (mDivider == null || layoutManager.getChildCount() == 0) {
                return;
            }

            //判断总的数量是否可以整除
            int totalCount = layoutManager.getItemCount();
            int surplusCount = totalCount % layoutManager.getSpanCount();

            int left, right, top, bottom;

            int childCount = parent.getChildCount();

            if (layoutManager.getOrientation() == GridLayoutManager.VERTICAL) {//竖直方向的
                for (int i = 0; i < childCount; i++) {
                    View child = parent.getChildAt(i);
                    RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) child.getLayoutParams();
                    // 得到它在总数里面的位置
                    int position = parent.getChildAdapterPosition(child);
                    // 将带有颜色分割线处于中间的位置
                    float centerLeft = (layoutManager.getLeftDecorationWidth(child) - leftRight) / 2;
                    float centerTop = (layoutManager.getBottomDecorationHeight(child) - topBottom) / 2;
                    // 是否为最后一排
                    boolean isLast = surplusCount == 0 ?
                            position > totalCount - layoutManager.getSpanCount() - 1 :
                            position > totalCount - surplusCount - 1;
                    // 画下边的最后一排不需要画
                    if ((position + 1) % layoutManager.getSpanCount() == 1 && !isLast) {
                        // 计算下边的
                        left = layoutManager.getLeftDecorationWidth(child);
                        right = parent.getWidth() - layoutManager.getLeftDecorationWidth(child);
                        top = (int) (child.getBottom() + lp.bottomMargin + centerTop);
                        bottom = top + topBottom;
                        mDivider.setBounds(left, top, right, bottom);
                        mDivider.draw(c);
                    }
                    // 画右边的，能被整除的不需要右边，并且当数量不足的时候最后一荐不需要右边
                    boolean first = totalCount > layoutManager.getSpanCount() && (position + 1) % layoutManager.getSpanCount() != 0;
                    boolean second = totalCount < layoutManager.getSpanCount() && position + 1 != totalCount;
                    if (first || second) {
                        // 计算右边的
                        left = (int) (child.getRight() + lp.rightMargin + centerLeft);
                        right = left + leftRight;
                        top = child.getTop() + lp.topMargin;
                        // 第一排的不需要顶部的分割线
                        if (position > layoutManager.getSpanCount() - 1) {
                            top -= centerTop;
                        }
                        bottom = child.getBottom() - lp.bottomMargin;
                        // 最后一排不需要最底下的分割线
                        if (!isLast) {
                            bottom += centerTop;
                        }
                        mDivider.setBounds(left, top, right, bottom);
                        mDivider.draw(c);
                    }
                }
            } else {
                for (int i = 0; i < childCount; i++) {
                    View child = parent.getChildAt(i);
                    RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) child.getLayoutParams();
                    // 得到它在总数里面的位置
                    int position = parent.getChildAdapterPosition(child);
                    // 将带有颜色的分割线处于中间
                    float centerLeft = (layoutManager.getLeftDecorationWidth(child) - leftRight) / 2;
                    float centerTop = (layoutManager.getTopDecorationHeight(child) - topBottom) / 2;
                    // 是否为最后一排
                    // 是否为最后一排
                    boolean isLast = surplusCount == 0 ?
                            position > totalCount - layoutManager.getSpanCount() - 1 :
                            position > totalCount - surplusCount - 1;
                    // 画下边的最后一排不需要画
                    if ((position + 1) % layoutManager.getSpanCount() == 1 && !isLast) {
                        // 计算下边的
                        left = (int) (child.getRight() + lp.rightMargin + centerLeft);
                        right = left + leftRight;
                        top = layoutManager.getTopDecorationHeight(child);
                        bottom = parent.getHeight() - layoutManager.getTopDecorationHeight(child);
                        mDivider.setBounds(left, top, right, bottom);
                        mDivider.draw(c);
                    }
                    // 画右边的，能被整除的不需要右边，并且当数量不足的时候最后一荐不需要右边
                    boolean first = totalCount > layoutManager.getSpanCount() && (position + 1) % layoutManager.getSpanCount() != 0;
                    boolean second = totalCount < layoutManager.getSpanCount() && position + 1 != totalCount;
                    if (first || second) {
                        // 计算右边的
                        left = child.getLeft() + lp.leftMargin;
                        if (position > layoutManager.getSpanCount() - 1) {
                            left -= centerLeft;
                        }
                        right = child.getRight() - lp.rightMargin;
                        if (!isLast) {
                            right += centerLeft;
                        }
                        top = (int) (child.getBottom() + lp.bottomMargin + centerTop);
                        bottom = top + topBottom;
                        mDivider.setBounds(left, top, right, bottom);
                        mDivider.draw(c);
                    }

                }
            }
        }
    }

    /**
     * 确定divider的范围
     *
     * 首先当然是判断VERTICAL还是HORIZONTAL。对于VERTICAL，我们每一项必须的是top和left，但是对于最后一排的还
     * 需要bottom，同时对于最右侧的还需要right。根据这些，就很好写出它的一个规则了
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (parent.getLayoutManager() != null && parent.getLayoutManager() instanceof GridLayoutManager) {
            GridLayoutManager layoutManager = (GridLayoutManager) parent.getLayoutManager();
            //判断总的数量是否可以整除
            int totalCount = layoutManager.getItemCount();
            int surplusCount = totalCount % layoutManager.getSpanCount();
            int childPosition = parent.getChildAdapterPosition(view);
            if (layoutManager.getOrientation() == GridLayoutManager.VERTICAL) {//竖直方向的
                if (surplusCount == 0 && childPosition > totalCount - layoutManager.getSpanCount() - 1) {
                    //后面几项需要bottom
                    outRect.bottom = topBottom;
                } else if (surplusCount != 0 && childPosition > totalCount - surplusCount - 1) {
                    outRect.bottom = topBottom;
                }
                if ((childPosition + 1) % layoutManager.getSpanCount() == 0) {//被整除的需要右边
                    outRect.right = leftRight;
                }
                outRect.top = topBottom;
                outRect.left = leftRight;
            } else {
                if (surplusCount == 0 && childPosition > totalCount - layoutManager.getSpanCount() - 1) {
                    //后面几项需要右边
                    outRect.right = leftRight;
                } else if (surplusCount != 0 && childPosition > totalCount - surplusCount - 1) {
                    outRect.right = leftRight;
                }
                if ((childPosition + 1) % layoutManager.getSpanCount() == 0) {//被整除的需要下边
                    outRect.bottom = topBottom;
                }
                outRect.top = topBottom;
                outRect.left = leftRight;
            }
        }

    }
}
