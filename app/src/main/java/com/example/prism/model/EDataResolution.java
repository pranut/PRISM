package com.example.prism.model;

public enum EDataResolution {

    All(0),
    Hourly(1),
    Daily(2),
    Weekly(3),
    Monthly(4),
    Yearly(5);


    private int id;
    private String name;

    EDataResolution(int id) {
        this.id = id;
        switch (id){
            case 0: this.name = "All"; break;
            case 1: this.name = "Hourly"; break;
            case 2: this.name = "Daily"; break;
            case 3: this.name = "Weekly"; break;
            case 4: this.name = "Monthly"; break;
            case 5: this.name = "Yearly"; break;
        }
    }

    public int getID() {
        return id;
    }
    public String toString() {
        return name;
    }

    public static EDataResolution toEnum(int x) {
        EDataResolution ret = null;
        for (EDataResolution type : EDataResolution.values()) {
            if (type.getID() == x)
                ret = type;
        }
        return ret;
    }

}
