package com.example.svp2.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class MyVerticalViewPager extends ViewPager {
    public MyVerticalViewPager(@NonNull Context context) {
        super(context);
    }

    public MyVerticalViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        // 设置viewpager的切换动画，这里设置才能真正实现垂直滑动的viewpager
        setPageTransformer(true, new DefaultTransformer());
    }

    /**
     * 拦截touch事件
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean touchEvent = super.onInterceptTouchEvent(ev);
        swapEvent(ev);
        return touchEvent;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(swapEvent(ev));
    }

    private MotionEvent swapEvent(MotionEvent ev) {
        // 获取宽高
        int width = getWidth();
        int height = getHeight();
        // 将Y轴的移动距离转变成X轴的移动距离
        float swappedX = (ev.getY() / height) * width;
        // 将X轴的移动距离转换成Y轴的移动距离
        float swappedY = (ev.getX() / width) * height;
        // 重设event的位置
        ev.setLocation(swappedX, swappedY);
        return ev;
    }

    /**
     * 自定义的切换动画
     */
    private class DefaultTransformer implements PageTransformer {
        @Override
        public void transformPage(@NonNull View page, float position) {
            float alpha = 0;
            if (0 <= position && position <= 1) {
                alpha = 1 - position;
            } else if (-1 < position && position < 0) {
                alpha = position + 1;
            }
            page.setAlpha(alpha);
            float transX = page.getWidth() * -position;
            page.setTranslationX(transX);
            float transY = position * page.getHeight();
            page.setTranslationY(transY);
        }
    }
}
