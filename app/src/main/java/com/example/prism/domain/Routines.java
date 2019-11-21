package com.example.prism.domain;

import java.util.ArrayList;

public class Routines {
    private String mName;
    private boolean mOnline;
    private int routineType;

    public Routines(String name,int rType, boolean online) {
        mName = name;
        routineType = rType;
        mOnline = online;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    private static int lastContactId = 0;

    public static ArrayList<Routines> createRoutinesList(int numContacts) {
        ArrayList<Routines> contacts = new ArrayList<Routines>();

        contacts.add( new Routines("Daily Pain Report Level", 77, true));
        contacts.add( new Routines("Knee Exercise", 88, true));
        contacts.add( new Routines("Stretching",99, true));

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Routines("Routine " + ++lastContactId, i, i <= numContacts / 2));
        }

        return contacts;
    }
}