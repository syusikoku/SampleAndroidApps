package com.example.svp2.widget.verticalvp.transforms;

/**
 * Copyright (C) 2015 Kaelaela
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

import android.view.View;

import androidx.viewpager.widget.ViewPager;

public class MyZoomOutTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.90f;

    @Override
    public void transformPage(View view, float position) {
        float alpha = 0;
        if (0 <= position && position <= 1) {
            alpha = 1 - position;

            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

        } else if (-1 < position && position < 0) {
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            alpha = position + 1;
        }
        view.setAlpha(alpha);
    }
}
