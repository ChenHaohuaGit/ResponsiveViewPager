package com.example.edward.responsiveviewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by edward on 2016/10/12.
 */

public class ResponsiveImageview extends ImageView implements ResponsiveViewPagerInterface{

    int direction = Direction.DOWN;

    public ResponsiveImageview(Context context) {
        super(context);
    }

    public ResponsiveImageview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public float movingRate() {
        return 1;
    }

    @Override
    public int direction() {
        return direction;
    }

    public void setDirection(int direction){
        this.direction = direction;
    }
}
