package com.example.prism.model;

import android.os.Parcel;

public class TimeEvent {

    public long eventTime;
    public double value;

    public TimeEvent(long eventTime, double value)

    {
        this.eventTime = eventTime;
        this.value = value;
    }


}
