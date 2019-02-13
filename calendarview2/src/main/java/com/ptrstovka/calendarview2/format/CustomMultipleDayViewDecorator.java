package com.ptrstovka.calendarview2.format;

import com.ptrstovka.calendarview2.CalendarDay;
import com.ptrstovka.calendarview2.DayViewDecorator;
import com.ptrstovka.calendarview2.DayViewFacade;
import com.ptrstovka.calendarview2.spans.CustomSpan;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class CustomMultipleDayViewDecorator extends DayViewDecorator {

    private int colorLeft;
    private int colorRight;
    private List<Integer> colors;
    private HashSet<CalendarDay> dates;

    public CustomMultipleDayViewDecorator(int colorLeft, int colorRight,
                                Collection<CalendarDay> dates) {
        this.colorLeft = colorLeft;
        this.colorRight = colorRight;
        this.dates = new HashSet<>(dates);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new CustomSpan(5, colorLeft, colorRight));
    }
}
