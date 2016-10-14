package com.example.edward.responsiveviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Created by edward on 2016/9/22.
 */

public class ResponsiveViewPager extends ViewPager {

    ResponsivePageTransformer responsivePageTransformer = new ResponsivePageTransformer();

    public ResponsiveViewPager(Context context) {
        super(context);
        init();
    }

    public ResponsiveViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
        setPageTransformer(true, responsivePageTransformer);
    }

}
