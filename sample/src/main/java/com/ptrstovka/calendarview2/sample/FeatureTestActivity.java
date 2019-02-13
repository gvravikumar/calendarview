package com.ptrstovka.calendarview2.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ptrstovka.calendarview2.CalendarDay;
import com.ptrstovka.calendarview2.CalendarView2;
import com.ptrstovka.calendarview2.Range;
import com.ptrstovka.calendarview2.format.CustomMultipleDayViewDecorator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.ptrstovka.calendarview2.CalendarDay.from;
import static com.ptrstovka.calendarview2.Range.range;
import static java.util.Arrays.asList;

@SuppressWarnings("unused")
public class FeatureTestActivity extends AppCompatActivity {

    private static final String TAG = "FeatureTestActivity";

    @BindView(R.id.calendar_view)
    CalendarView2 calendarView;

    int PRESENT;
    int ABSENT;
    int HOLIDAYS;
    int WHITE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature_test);
        ButterKnife.bind(this);
        calendarView.setSelectionMode(CalendarView2.SELECTION_MODE_NONE);
        HOLIDAYS = getResources().getColor(R.color.sample_primary);
        PRESENT = getResources().getColor(R.color.sample_secondary);
        ABSENT = getResources().getColor(R.color.sample_ternary);
        WHITE = getResources().getColor(R.color.white);
        selectRange();
    }

    private void selectRange() {
        List<Range> ranges = asList(
                range(from(2019, Calendar.FEBRUARY, 2), from(2019, Calendar.FEBRUARY, 4), PRESENT),
                range(from(2019, Calendar.FEBRUARY, 5), from(2019, Calendar.FEBRUARY, 18), HOLIDAYS),
//                range(from(2019, Calendar.FEBRUARY, 10), from(2019, Calendar.FEBRUARY, 14), HOLIDAYS),
//                range(from(2019, Calendar.FEBRUARY, 11), from(2019, Calendar.FEBRUARY, 18), ABSENT),
                range(from(2019, Calendar.FEBRUARY, 19), from(2019, Calendar.FEBRUARY, 28), ABSENT)
        );
        List<CalendarDay> days = new ArrayList<>();
        days.add(CalendarDay.from(2019, Calendar.FEBRUARY, 2));
        days.add(CalendarDay.from(2019, Calendar.FEBRUARY, 3));
        days.add(CalendarDay.from(2019, Calendar.FEBRUARY, 4));
        days.add(CalendarDay.from(2019, Calendar.FEBRUARY, 5));
        days.add(CalendarDay.from(2019, Calendar.FEBRUARY, 6));
        days.add(CalendarDay.from(2019, Calendar.FEBRUARY, 7));
        calendarView.addDecorator(new CustomMultipleDayViewDecorator(ABSENT, WHITE, days));
        calendarView.select(ranges);
    }

}
