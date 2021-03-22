package de.thunderfrog;

import java.util.ArrayList;

public class Person {
    private String firstName;
    private String lastName;
    private String job;
    private ArrayList<String> jobs = new ArrayList<>();

    public Person(String firstName, String lastName, String job) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
    }

    public Person() {
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

    public ArrayList<String> addSomeJobs(){
        jobs.add("Sänger/in");
        jobs.add("Regisseur/in");
        jobs.add("Kameramann/frau");
        jobs.add("Stuntman/women");
        jobs.add("Hauptdarsteller/in");
        jobs.add("Tontechniker/in");
        jobs.add("Catering");
        return jobs;
    }

    @Override
    public String toString() {
        return firstName + "," + lastName + " | " + job;
    }
}
