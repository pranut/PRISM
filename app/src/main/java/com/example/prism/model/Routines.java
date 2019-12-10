package com.example.prism.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Routines implements Parcelable {

    public ArrayList<Routine> rList;

    public Routines(ArrayList<Routine> routines) {
        this.rList = routines;
    }


    protected Routines(Parcel in) {
        rList = in.createTypedArrayList(Routine.CREATOR);
    }

    public static final Creator<Routines> CREATOR = new Creator<Routines>() {
        @Override
        public Routines createFromParcel(Parcel in) {
            return new Routines(in);
        }

        @Override
        public Routines[] newArray(int size) {
            return new Routines[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(rList);
    }
}
