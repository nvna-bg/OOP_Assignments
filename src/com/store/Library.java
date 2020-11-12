package com.store;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Library implements IFile {

    private List<LibraryBook> books; // LibraryBook[5]
    private List<Reader> readers; // Reader[]
    private String[] fileNames;

    public Library(String[] files) {
        fileNames = files;

        books = new ArrayList<LibraryBook>();
        readers = new ArrayList<Reader>();
    }

    public void borrowing(int irdr, int ibk) {
        LibraryBook book = books.get(ibk);

        Reader reader = readers.get(irdr);

        book.get(reader);
    }

    public void returnBook(int ibk) {
        LibraryBook book = books.get(ibk);
        book.ret();
    }

    public String toString() {
//        Reader[] readersArray = (Reader[]) readers.toArray();
//        LibraryBook[] booksArray = (LibraryBook[]) books.toArray();

        // в 4-то упражнение (MainClass) показахме за функция към Arrays класа, която позволява да изобразим
        // като стринг един цял масив без да го обхождаме с цикъл
        // проблемът е , че нашите колекции books и readers технически не са нормални масиви
        // хубавото е , че нашите колекции имат вградена функция toArray която ги обръща в нормални масиви
        // List<T> към T[] i.e. List<LibraryBook> -> LibraryBook[]; List<Reader> -> Reader[]
        String readersString = Arrays.toString(readers.toArray());
        String booksString = Arrays.toString(books.toArray());

        return readersString + "\n" + booksString;
    }

    public void outputToConsole() {
        System.out.print(this.toString());
    }

    public LibraryBook getBookAtIndex(int ibk) {
        // същото като ако имахме LibraryBook[] books;
        // return books[ibk];
        return books.get(ibk);
    }

    public void setBookAtIndex(int ibk, LibraryBook newBook) {
        // същото ако имахме LibraryBook[] books;
        // books[ibk] = newBook
        books.set(ibk, newBook);
    }

    public boolean compareBooks(int ibk1, int ibk2) {
        LibraryBook b1 = books.get(ibk1);
        LibraryBook b2 = books.get(ibk2);

        // ползваме compareTo метода който имаме написан в LibraryBook
        boolean result = (b1.compareTo(b2) == 0);
        return result;
    }

    public boolean compareReaders(int irdr1, int irdr2) {
        Reader r1 = readers.get(irdr1);
        Reader r2 = readers.get(irdr2);

        // ползваме compareTo метода който имаме написан в LibraryBook
        boolean result = (r1.compareTo(r2) == 0);
        return result;
    }

    @Override
    public void load() {
        // показвали сме този синтаксис и преди
        // равносилен е на
        // for(int i = 0; i < fileNames.length; i++) {
        //      String fileName = fileNames[i];
        //      ........останалата част от кода
        // }
        for (String fileName: fileNames) {
            // опитваме се да отворим файлът който се намира на оказаното във локацията място ( fileName e
            // string който се очаква да сочи към определен файл )
            File file = new File(fileName);
            try {
                // surprise surprise , Scanner-ът може да работи и с други източници на информация
                // досега ползвахме Scanner(InputStream i) версията - System.in e InputStream
                // има и версия която е Scanner(File f) която ползваме в този случай
                // https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html#Scanner(java.io.File)
                Scanner scanner = new Scanner(file);
                // имаме да решим генерален проблем - как програмата ще разбира въпросен файл дали се отнася
                // за книги LibraryBook или за читатели Reader. Добре е да помислим как бихме оказали
                // това ако ставаше въпрос примерно как бихме го обозначили за пред друг човек:
                // 1. името на файла - съдържа book ако файлът е за книга; съдържа reader ако файлът е за читател
                // 2. content в самия файл - директно във файла пишем (примерно най-първи ред) book ако е за книга,
                // reader ако е за читател.
                // Тук е показана версията която проверява fileName-овете - някой да има идея как да направим другата версия?
                if(fileName.contains("book")) {
                    // в нашите txt файлове има само 2 реда за всяка книга - име и статус
                    String bookName = scanner.nextLine(); // четем първия за име
                    boolean bookStatus = scanner.nextBoolean(); // четем втория за статус

                    LibraryBook book = new LibraryBook(bookName, bookStatus); // създаваме обект от тип LibraryBook
                    books.add(book); // и го добавяме към нашата колекция с книги books
                }
                // идентично с горния сегмент, само дето става въпрос за читатели
                else if(fileName.contains("reader")) {
                    String readerName = scanner.nextLine();
                    String facultyNumber = scanner.nextLine();

                    Reader reader = new Reader(readerName, facultyNumber);
                    readers.add(reader);
                }
                else {}
            }
            catch(FileNotFoundException ex) {
                ex.printStackTrace();
            }

        }
    }
}
