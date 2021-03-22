package de.thunderfrog;

import java.util.ArrayList;
import java.util.Arrays;

public class Person {
    private String firstName;
    private String lastName;
    private String job;
    private static final String[] jobnames = {"Sänger/in","Regisseur/in","Kameramann/frau" ,"Hauptdarsteller/in"};
    public static final ArrayList<String> jobs = new ArrayList<>(Arrays.asList(jobnames));

    public Person(String firstName, String lastName, String job) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        MainApp.cbPerson.addItem(this);
        MediumGUI.cbPerson.addItem(this);
    }

    public static ArrayList<String> getJobs() {
        return jobs;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return firstName + "," + lastName + " | " + job;
    }
}
