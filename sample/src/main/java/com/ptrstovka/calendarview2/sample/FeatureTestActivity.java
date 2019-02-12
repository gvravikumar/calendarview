package com.ptrstovka.calendarview2.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ptrstovka.calendarview2.CalendarView2;
import com.ptrstovka.calendarview2.Range;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature_test);
        ButterKnife.bind(this);
        calendarView.setSelectionMode(CalendarView2.SELECTION_MODE_NONE);
        HOLIDAYS = getResources().getColor(R.color.sample_primary);
        PRESENT = getResources().getColor(R.color.sample_secondary);
        ABSENT = getResources().getColor(R.color.sample_ternary);
        selectRange();
    }

    private void selectRange() {
        List<Range> ranges = asList(
                range(from(2019, Calendar.JANUARY, 3), from(2019, Calendar.JANUARY, 4), PRESENT),
                range(from(2019, Calendar.JANUARY, 5), from(2019, Calendar.JANUARY, 7), HOLIDAYS),
                range(from(2019, Calendar.JANUARY, 10), from(2019, Calendar.JANUARY, 14), HOLIDAYS),
                range(from(2019, Calendar.JANUARY, 17), from(2019, Calendar.JANUARY, 18), ABSENT),
                range(from(2019, Calendar.JANUARY, 19), from(2019, Calendar.JANUARY, 21), PRESENT)
        );

        calendarView.select(ranges);
    }

}
