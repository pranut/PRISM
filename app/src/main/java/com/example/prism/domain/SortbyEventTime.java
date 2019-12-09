package com.example.prism.domain;

import java.util.Comparator;

public class SortbyEventTime  implements Comparator<TimeEvent> {

    // Used for sorting in ascending order of
    // event Time
    public int compare(TimeEvent a, TimeEvent b)
    {
        //TODO dangerous long to int conversion
        return (int)(a.eventTime - b.eventTime);
    }

}
