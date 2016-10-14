package com.example.edward.responsiveviewpager;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

class CustomPagerAdapter extends PagerAdapter {

    Context mContext;

    public CustomPagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

//        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_sun_mountain,container);

        ResponsiveImageview imageView = new ResponsiveImageview(mContext);
        int imageId = 0;

        imageId = getImage(position);

        if (imageId != 0)
            imageView.setImageResource(imageId);

        if (position < 4)
            imageView.setDirection(position);
        else
            LayoutInflater.from(mContext).inflate(R.layout.layout_sun_mountain,container);

        container.addView(imageView);

        return imageView;
    }

    private int getImage(int position) {
        switch (position) {
            case 0:
                return R.mipmap.ic_launcher;
            case 1:
                return R.drawable.ic_brightness_high_black_24dp;
            case 2:
                return R.drawable.ic_camera_alt_black_24dp;
            case 3:
                return R.drawable.ic_directions_walk_black_24dp;
            case 4:
                return R.drawable.ic_insert_emoticon_black_24dp;
            default:
                return R.mipmap.ic_launcher;
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}