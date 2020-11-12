package com.store;

import java.util.GregorianCalendar;

public class Student extends Applicant implements Comparable<Student> {

    private String fak_n;

    public Student() {

    }

    public Student(String name, String number) {
       setName(name);
       this.fak_n = number;
    }

    public Student(String name, GregorianCalendar date, double g, String number) {
        super(name, date, g);
        this.fak_n = number;
    }



    @Override
    public int compareTo(Student o) {
        this.name = "";
        return (getGrade() < o.getGrade()) ? -1 : 1;
    }

    public String getFacultyID() {
        return this.fak_n;
    }

    public void setFacultyID(String id) {
        this.fak_n = id;
    }

    public void move() {

    }
}
