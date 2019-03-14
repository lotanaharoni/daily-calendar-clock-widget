package com.miltolstoy.roundcalendar;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

class Event {

    private String title;
    private long start;
    private long finish;
    private String dateTimeFormat = "dd.MM.yyyy HH:mm";
    private String dateFormat = "dd.MM.yyyy";
    private String timeFormat = "HH:mm";
    private static String tag = "Event";

    Event(String title, String start, String finish) {
        Log.d(tag, "Creating event. Title: " + title + ". Start: " + start + ". Finish: " + finish);
        this.title = title;
        this.start = Long.parseLong(start);
        try {
            this.finish = Long.parseLong(finish);
        } catch (NumberFormatException e) {
            this.finish = 0;
        }
    }

    String getTitle() {
        return title;
    }

    String getStartDateTime() {
        return formatToDateTime(start);
    }

    String getFinishDateTime() {
        return formatToDateTime(finish);
    }

    String getStartDate() {
        return formatToDate(start);
    }

    String getFinishDate() {
        return formatToDate(finish);
    }

    String getStartTime() {
        return formatToTime(start);
    }

    String getFinishTime() {
        return formatToTime(finish);
    }

    private String format(long milliSeconds, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.US);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    private String formatToDateTime(long milliSeconds) {
        return format(milliSeconds, dateTimeFormat);
    }

    private String formatToDate(long milliSeconds) {
        return format(milliSeconds, dateFormat);
    }

    private String formatToTime(long milliSeconds) {
        return format(milliSeconds, timeFormat);
    }

}
