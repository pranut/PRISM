package com.example.prism;

/**
 * Created by root on 8/26/16.
 */
public class Scores {
    private int _id;
    private int _dvprs;
    private int _activity;
    private int _sleep;
    private int _mood;
    private int _stress;
    private int _qa1;
    private int _qa2;
    private int _qa3;

    public Scores() {

    }

    public Scores(int dvprs, int activity, int sleep, int mood, int stress, int qa1, int qa2, int qa3) {
        this._dvprs = dvprs;
        this._activity = activity;
        this._sleep = sleep;
        this._mood = mood;
        this._stress = stress;
        this._qa1 = qa1;
        this._qa2 = qa2;
        this._qa3 = qa3;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_dvprs(int _dvprs) {
        this._dvprs = _dvprs;
    }

    public void set_activity(int _activity) {
        this._activity = _activity;
    }

    public void set_sleep(int _sleep) {
        this._sleep = _sleep;
    }

    public void set_mood(int _mood) {
        this._mood = _mood;
    }

    public void set_stress(int _stress) {
        this._stress = _stress;
    }

    public void set_qa1(int _qa1) {
        this._qa1 = _qa1;
    }

    public void set_qa2(int _qa2) {
        this._qa2 = _qa2;
    }

    public void set_qa3(int _qa3) {
        this._qa3 = _qa3;
    }

    public int get_id() {
        return _id;
    }

    public int get_dvprs() {
        return _dvprs;
    }

    public int get_activity() {
        return _activity;
    }

    public int get_sleep() {
        return _sleep;
    }

    public int get_mood() {
        return _mood;
    }

    public int get_stress() {
        return _stress;
    }

    public int get_qa1() {
        return _qa1;
    }

    public int get_qa2() {
        return _qa2;
    }

    public int get_qa3() {
        return _qa3;
    }
}
