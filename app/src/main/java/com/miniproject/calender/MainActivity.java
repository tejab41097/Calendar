package com.miniproject.calender;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    CompactCalendarView compactCalendarView;
    private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle("null");

        compactCalendarView=(CompactCalendarView)findViewById(R.id.compactcalendar_view);
        compactCalendarView.setUseThreeLetterAbbreviation(true);

        Event ev=new Event(Color.BLUE,1505412661,"Special Event");
        compactCalendarView.addEvent(ev);
        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context= getApplicationContext();
                Toast.makeText(MainActivity.this,""+dateClicked,Toast.LENGTH_LONG).show();
               /* if(dateClicked.toString().compareTo("Thu Sep 14 18:11:1 AST 2017")==0)
                    Toast.makeText(MainActivity.this,"Special Event",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"No Event",Toast.LENGTH_SHORT).show();*/
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                actionBar.setTitle(simpleDateFormat.format(firstDayOfNewMonth));
            }
        });
    }
}
