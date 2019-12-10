package com.example.prism.domain;

import java.util.ArrayList;

public class Routines {
    private String rName;
    private boolean enabled;
    private int routineID;

    public Routines(String name,int routineID, boolean enabled) {
        this.rName = name;
        this.routineID = routineID;
        this.enabled = enabled;
    }

    public String getName() {
        return rName;
    }

    public int getRoutineID(){
        return routineID;
    }

    public boolean isOnline() {
        return enabled;
    }

    private static int lastContactId = 0;

    public static ArrayList<Routines> createRoutinesList(int numContacts) {
        ArrayList<Routines> routineList = new ArrayList<Routines>();

        routineList.add( new Routines("Daily Pain Report Level", 77, true));
        routineList.add( new Routines("Knee Exercise", 88, true));
        routineList.add( new Routines("Stretching",99, true));
        routineList.add( new Routines("Walk",66, true));

//        for (int i = 1; i <= numContacts; i++) {
//            contacts.add(new Routines("Routine " + ++lastContactId, i, i <= numContacts / 2));
//        }

        return routineList;
    }
}