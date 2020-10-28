package com.store;

import java.util.GregorianCalendar;

public class Reader extends Student implements IReader {

    public Reader(String name, String fn) {
        super(name, fn);
    }

    public Reader(GregorianCalendar date, String name, String fn, double g) {
        super(name, date, g, fn);
    }

    @Override
    public void get(LibraryBook book) {
        book.setReader(this);
    }

    @Override
    public void ret(LibraryBook book) {
        book.ret();
    }
}
