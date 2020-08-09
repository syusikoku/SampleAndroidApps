package com.example.svp2.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.svp2.R;

import androidx.annotation.Nullable;

public class GlideUtils {

    /**
     *  自适应宽度加载图片。保持图片的长宽比例不变，通过修改imageView的高度来完全显示图片
     *    适用于RecyclerView+GridLayoutManager
     */
    public static void loadImgWithAutoHeight(Context context, ImageView imageView, String url) {
        Glide
                .with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .placeholder(R.mipmap.icon_loadingimg)
                .error(R.mipmap.activity_rideresult_failure)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<Drawable> target, boolean isFirstResource) {
                        imageView.setBackgroundColor(Color.GREEN);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model,
                                                   Target<Drawable> target, DataSource dataSource
                            , boolean isFirstResource) {
                        if (imageView == null) {
                            return false;
                        }
                        if (imageView.getScaleType() != ImageView.ScaleType.FIT_XY) {
                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        }
                        ViewGroup.LayoutParams params = imageView.getLayoutParams();
                        int vw =
                                imageView.getWidth() - imageView.getPaddingLeft() - imageView.getPaddingRight();
                        float scale = (float) vw / (float) resource.getIntrinsicWidth();
                        int vh = Math.round(resource.getIntrinsicHeight() * scale);
                        params.height =
                                vh + imageView.getPaddingTop() + imageView.getPaddingBottom();
                        imageView.setLayoutParams(params);
                        return false;
                    }
                }).into(imageView);
    }
}
