package com.store;

import java.util.GregorianCalendar;

public class Applicant {
    protected String name;
    protected GregorianCalendar dob;
    protected double grade;

    public Applicant() {
        dob = new GregorianCalendar();
        grade = 0;
    }

    public Applicant(String name, GregorianCalendar date, double g) {
        this.name = name;
        this.dob = date;
        this.grade = g;
    }

    public String getName() {
        return this.name;
    }

    public GregorianCalendar getDoB() {
        return this.dob;
    }

    public double getGrade() {
        return this.grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDoB(GregorianCalendar date) { this.dob = date; }

    public void setGrade(double grade) { this.grade = grade; }

    public String toString() {
        return String.format("Name: %1$s,total grade: %2$s", name, grade);
    }
}
