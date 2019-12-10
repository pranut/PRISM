package com.example.prism.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Routine implements Parcelable {

    private String rName;
    private boolean enabled;
    private int routineID;

    private String description;
    private boolean isExpanded;
    private int image;

    public Routine(String name, int routineID, boolean enabled) {
        this.rName = name;
        this.routineID = routineID;
        this.enabled = enabled;
    }

    public Routine() {

    }

    protected Routine(Parcel in) {
        rName = in.readString();
        enabled = in.readByte() != 0;
        routineID = in.readInt();
        description = in.readString();
        isExpanded = in.readByte() != 0;
        image = in.readInt();
    }

    public static final Creator<Routine> CREATOR = new Creator<Routine>() {
        @Override
        public Routine createFromParcel(Parcel in) {
            return new Routine(in);
        }

        @Override
        public Routine[] newArray(int size) {
            return new Routine[size];
        }
    };

    public String getName() {
        return rName;
    }

    public void setName(String name) {
        this.rName = name;
    }

    public int getRoutineID(){
        return routineID;
    }

    public boolean isOnline() {
        return enabled;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private static int lastContactId = 0;

    public static ArrayList<Routine> createRoutinesList(int numContacts) {
        ArrayList<Routine> routineList = new ArrayList<Routine>();

        routineList.add( new Routine("Daily Pain Report Level", 77, true));
        routineList.add( new Routine("Knee Exercise", 88, true));
        routineList.add( new Routine("Stretching",99, true));
        routineList.add( new Routine("Walk",66, true));

//        for (int i = 1; i <= numContacts; i++) {
//            contacts.add(new Routine("Routine " + ++lastContactId, i, i <= numContacts / 2));
//        }

        return routineList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(rName);
        parcel.writeByte((byte) (enabled ? 1 : 0));
        parcel.writeInt(routineID);
        parcel.writeString(description);
        parcel.writeByte((byte) (isExpanded ? 1 : 0));
        parcel.writeInt(image);
    }
}