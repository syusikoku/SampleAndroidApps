package com.example.svp2.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

/**
 * Description：
 * Date：2019/7/15
 */
public class CircleImageView extends AppCompatImageView {
    private static final int KEY_SHADOW_COLOR = 0x1E000000;

    private static final int FILL_SHADOW_COLOR = 0x3D000000;
    private static final float X_OFFSET = 0f;
    private static final float Y_OFFSET = 1.75f;
    private static final float SHADOW_RADIUS = 3.5f;
    private static final float SHADOW_EVELATION = 4;

    private final Context mCtx;
    private RadialGradient mRaidusGadient;
    private int mShadowRadius;
    private Animation.AnimationListener mListener;

    public CircleImageView(Context context, int color) {
        super(context);
        this.mCtx = context;
        init(color);
    }

    private void init(int _color) {
        float density = mCtx.getResources().getDisplayMetrics().density;
        int shadowYOffset = (int) (density * Y_OFFSET);
        int shadowXOffset = (int) (density * X_OFFSET);

        // 计算阴影的圆角
        mShadowRadius = (int) (density * SHADOW_RADIUS);

        ShapeDrawable circle;
        if (evelationSupported()) {
            circle = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(this, SHADOW_EVELATION * density);
        } else {
            OvalShadow oval = new OvalShadow(mShadowRadius);
            circle = new ShapeDrawable(oval);
            // 设置图层样式: 硬件加速和软件加速
            ViewCompat.setLayerType(this, ViewCompat.LAYER_TYPE_SOFTWARE, circle.getPaint());
            circle.getPaint().setShadowLayer(mShadowRadius, shadowXOffset, shadowYOffset, KEY_SHADOW_COLOR);
            int pading = mShadowRadius;
            circle.setPadding(pading, pading, pading, pading);
        }
        circle.getPaint().setColor(_color);
        setBackgroundDrawable(circle);
    }

    private boolean evelationSupported() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!evelationSupported()) {
            setMeasuredDimension(getMeasuredWidth() + mShadowRadius * 2, getMeasuredHeight() + mShadowRadius * 2);
        }
    }

    public void setAnimListener(Animation.AnimationListener _listener) {
        this.mListener = _listener;
    }

    @Override
    protected void onAnimationStart() {
        super.onAnimationStart();
        if (mListener != null) {
            mListener.onAnimationStart(getAnimation());
        }
    }

    @Override
    protected void onAnimationEnd() {
        super.onAnimationEnd();

        if (mListener != null) {
            mListener.onAnimationEnd(getAnimation());
        }
    }

    public void setBgColorRes(int _colorRes) {
        setBackgroundColor(ContextCompat.getColor(getContext(), _colorRes));
    }


    @Override
    public void setBackgroundColor(int color) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(color);
        }
    }

    /**
     * 重写圆形shape资源
     */
    private class OvalShadow extends OvalShape {
        private Paint mShadowPaint;
        private int mShadowRadius;

        OvalShadow(int shadowRadius) {
            super();
            mShadowPaint = new Paint();
            mShadowRadius = shadowRadius;
            updateRadialGradient((int) rect().width());
        }

        @Override
        protected void onResize(float width, float height) {
            super.onResize(width, height);
            updateRadialGradient((int) width);
        }

        @Override
        public void draw(Canvas canvas, Paint paint) {
            super.draw(canvas, paint);
            int width = CircleImageView.this.getWidth();
            int height = CircleImageView.this.getHeight();
            // 画渐变效果
            canvas.drawCircle(width / 2, height / 2, width / 2, mShadowPaint);
            canvas.drawCircle(width / 2, height / 2, width / 2 - mShadowRadius, paint);
        }

        private void updateRadialGradient(int _diamater) {
            mRaidusGadient = new RadialGradient(_diamater / 2, _diamater / 2,
                    mShadowRadius, new int[]{FILL_SHADOW_COLOR, Color.TRANSPARENT}, null, Shader.TileMode.CLAMP
            );
            // 设置着色器
            mShadowPaint.setShader(mRaidusGadient);
        }
    }

}
