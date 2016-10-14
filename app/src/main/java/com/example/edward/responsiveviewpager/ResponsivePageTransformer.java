package com.example.edward.responsiveviewpager;

import android.os.Build;
import android.support.v4.view.ViewPager;
import android.view.View;


/**
 * Created by edward on 2016/9/22.
 */

public class ResponsivePageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {

        int pageWidth = page.getWidth();
        int pageHeight = page.getHeight();

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left
            setAlpha(page, 0);
        } else if (position <= 0) { // [-1,0]
            // This page is moving out to the left

            // Counteract the default swipe
            counteractSwipe(page, pageWidth * -position);
            addFadingEffect(page, 1 + position);

            if (page instanceof ResponsiveViewPagerInterface) {
                switch (((ResponsiveViewPagerInterface) page).direction()) {
                    case Direction.UP:
                        setTranslationY(page, pageHeight * position);
                        break;
                    case Direction.DOWN:
                        setTranslationY(page, pageHeight * -position);
                        break;
                    case Direction.LEFT:
                        setTranslationX(page, pageHeight * position);
                        break;
                    case Direction.RIGHT:
                        setTranslationX(page, pageHeight * -position);
                        break;
                }
//                if (((ResponsiveViewPagerInterface) page).direction() == Direction.UP || ((ResponsiveViewPagerInterface) page).direction() == Direction.RIGHT)
//                    counteractSwipe(page, pageWidth * -position);
//                else
//                    counteractSwipe(page, pageWidth * position);
            }

        } else if (position <= 1) { // (0,1]
            // This page is moving in from the right

            // Counteract the default swipe
            counteractSwipe(page, pageWidth * -position);

            addFadingEffect(page, 1 - position);

            if (page instanceof ResponsiveViewPagerInterface) {
                switch (((ResponsiveViewPagerInterface) page).direction()) {
                    case Direction.UP:
                        setTranslationY(page, pageHeight * position);
                        break;
                    case Direction.DOWN:
                        setTranslationY(page, pageHeight * -position);
                        break;
                    case Direction.LEFT:
                        setTranslationX(page, pageHeight * position);
                        break;
                    case Direction.RIGHT:
                        setTranslationX(page, pageHeight * -position);
                        break;
                }
//                if (((ResponsiveViewPagerInterface) page).direction() == Direction.UP || ((ResponsiveViewPagerInterface) page).direction() == Direction.RIGHT)
//                    counteractSwipe(page, pageWidth * -position);
//                else
//                    counteractSwipe(page, pageWidth * position);
            }else if (page instanceof ResponsiveCollectorInterface){
                ResponsiveCollectorInterface responsiveCollector= (ResponsiveCollectorInterface) page;
                for (ResponsiveViewPagerInterface responsiveViewPagerInterface : responsiveCollector.getCollection()) {
                    switch (responsiveViewPagerInterface.direction()) {
                        case Direction.UP:
                            setTranslationY((View) responsiveViewPagerInterface, pageHeight * position);
                            break;
                        case Direction.DOWN:
                            setTranslationY((View) responsiveViewPagerInterface, pageHeight * -position);
                            break;
                        case Direction.LEFT:
                            setTranslationX((View) responsiveViewPagerInterface, pageHeight * position);
                            break;
                        case Direction.RIGHT:
                            setTranslationX((View) responsiveViewPagerInterface, pageHeight * -position);
                            break;
                    }

                }
            }

        } else if (position > 1) {
            setAlpha(page, 0);
        }

    }

    private void addFadingEffect(View page, float length) {
        setAlpha(page, length);
    }

    private void counteractSwipe(View page, float length) {
        setTranslationX(page, length);
    }

    private void setAlpha(View view, float alpha) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            view.setAlpha(alpha);
        }
    }

    private void setTranslationX(View view, float translationX) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            view.setTranslationX(translationX);
        }
    }

    private void setTranslationY(View view, float translationY) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            view.setTranslationY(translationY);
        }
    }

//    private void translationEffect(ResponsiveCollectorInterface page,float position) {
//        switch (((ResponsiveViewPagerInterface) page).direction()) {
//            case Direction.UP:
//                setTranslationY(page, page.getHeight() * position);
//                break;
//            case Direction.DOWN:
//                setTranslationY(page, page.getHeight() * -position);
//                break;
//            case Direction.LEFT:
//                setTranslationX(page, page.getWidth() * position);
//                break;
//            case Direction.RIGHT:
//                setTranslationX(page, page.getWidth() * -position);
//                break;
//        }
//
//    }


}
