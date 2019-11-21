package com.example.prism.domain;

import java.util.ArrayList;

public class Patient {
    private String mName;
    private boolean mOnline;

    public Patient(String name, boolean online) {
        mName = name;
        mOnline = online;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    private static int lastContactId = 0;

    public static ArrayList<Patient> createRoutinesList(int numContacts) {
        ArrayList<Patient> contacts = new ArrayList<Patient>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Patient("Patient " + ++lastContactId, i <= numContacts / 2));
        }

        return contacts;
    }
}