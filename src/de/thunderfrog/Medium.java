package de.thunderfrog;

import java.util.ArrayList;

public class Medium {

    //  Class Variable
    private String mTitle;
    private double mCost;
    private String mType;

    //  Creator of the Medium
    private Person creator;

    //  Medium ArrayList
    private final ArrayList<Medium> medium = new ArrayList<>();

    public Medium(String mTitle, double mCost, String mType, Person creator) {
        this.mTitle = mTitle;
        this.mCost = mCost;
        this.mType = mType;
        this.creator = creator;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public double getmCost() {
        return mCost;
    }

    public void setmCost(double mCost) {
        this.mCost = mCost;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "Medium{" +
                "mTitle='" + mTitle + '\'' +
                ", mCost=" + mCost +
                ", mType='" + mType + '\'' +
                ", creator=" + creator +
                ", medium=" + medium +
                '}';
    }
}
