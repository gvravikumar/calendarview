package com.prolificinteractive.materialcalendarview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;

/**
 * Custom ViewPager that allows swiping to be disabled.
 */
class MonthPager extends ViewPager {

    private boolean pagingEnabled = true;

    public MonthPager(Context context) {
        super(context);
    }

    @Override
    public void scrollTo(int x, int y) {
        if (pagingEnabled) {
            super.scrollTo(x, y);
        }
    }

    /**
     * enable disable viewpager scroll
     *
     * @param pagingEnabled false to disable paging, true for paging (default)
     */
    public void setPagingEnabled(boolean pagingEnabled) {
        this.pagingEnabled = pagingEnabled;
    }

    /**
     * @return is this viewpager allowed to page
     */
    public boolean isPagingEnabled() {
        return pagingEnabled;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return pagingEnabled && super.onInterceptTouchEvent(ev);
    }
}