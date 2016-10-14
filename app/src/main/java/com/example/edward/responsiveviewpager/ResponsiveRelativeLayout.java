package com.example.edward.responsiveviewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by edward on 2016/10/15.
 */

public class ResponsiveRelativeLayout extends RelativeLayout implements ResponsiveCollectorInterface {
    public ResponsiveRelativeLayout(Context context) {
        super(context);
    }

    public ResponsiveRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public ArrayList<ResponsiveViewPagerInterface> getCollection() {
        ArrayList<ResponsiveViewPagerInterface> responsiveView = new ArrayList<>();
        responsiveView.add((ResponsiveViewPagerInterface) findViewById(R.id.responsiveImageview));
        responsiveView.add((ResponsiveViewPagerInterface) findViewById(R.id.responsiveImageview2));
        return responsiveView;
    }
}
