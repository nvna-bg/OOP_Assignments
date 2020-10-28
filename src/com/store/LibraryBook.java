package com.store;

public class LibraryBook implements ILibraryBook, Comparable<LibraryBook> {

    private Reader person;
    private String bookName;
    private boolean status;

    public LibraryBook(String name) {
        this.bookName = name;
    }

    public LibraryBook(String name, boolean status) {
        this.bookName = name;
        this.status = status;
    }


    @Override
    public void ret() {
        this.person = null;
        status = false;
    }

    @Override
    public void get(Reader rdr) {
        this.person = (Reader)rdr;
        this.status = true;
    }

    @Override
    public int compareTo(LibraryBook o) {
        return this.bookName.compareTo(o.bookName);
    }

    public Reader getReader() {
        return person;
    }

    public String getBookName() {
        return this.bookName;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setReader(Reader rdr) {
        this.person = rdr;
        this.status = (rdr != null);
    }

    public void setBookName(String name) {
        this.bookName = name;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String toString() {
        return String.format("'%1$s', currently %2$s", bookName, (
                (status) ? "taken by " + person.name : "not taken"
                ));
    }

}
