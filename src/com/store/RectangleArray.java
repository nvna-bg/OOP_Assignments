package com.store;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RectangleArray {
    private ColorRectangle[] rectangles;

    public RectangleArray(String filename) {
        rectangles = new ColorRectangle[10]; // по условие се иска да са 10
        try {
            File f = new File(filename);
            Scanner scanner = new Scanner(f);
            int index = 0; // пазим на кой ред се намираме , почваме от 0
            while (scanner.hasNextLine()) {
                // прочитаме следващия ред от скенера, и създаваме масив от елементи които се състоят от
                // целия ред, разделен от интервали ( това е частта .split("-") ) т.е. ->
                // "1-2-3-4-5" = string[] { "1", "2", "3", "4", "5" }
                String[] data = scanner.nextLine().split(" ");
                // в този масив от стрингове , първите 4 са ни точките на правоъгълника а последния елемент
                // е цветът му т.е. ->
                // data[0] = x1; data[1] = y1; data[2] = x2; data[3] = y2; data[4] = RGB;
                int x1 = Integer.parseInt(data[0]);
                int y1 = Integer.parseInt(data[1]);
                int x2 = Integer.parseInt(data[2]);
                int y2 = Integer.parseInt(data[3]);
                long rgb = Long.parseLong(data[4]);

                // накрая създаваме ColorRectangle с парснатите стойности
                ColorRectangle rect = new ColorRectangle(x1, y1, x2, y2, rgb);
                // и го добавяме към позицията му в масива, според нашия индекс
                rectangles[index] = rect;
                // увеличаваме си индекса на ръка , защото сме във while loop а не във for loop
                // т.е. ако бяхме във for , това щеше да е написано вътре в самото условие на цикъла
                index++;
            }
            // задължително затваряме Scanner-а накрая , за да освободи файлът от паметта
            // ако не го направим няма да можем да трием или местим файла
            scanner.close();
        }
        catch(FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void printColl() {
        // синтаксисът за този вид for loop е следния
        // "за всеки Вид обект" ColorRectangle
        // ",който за момента наричаме с тази променлива," rect
        // "във следния масив" :rectangles

        // т.е. този цикъл ще обходи всеки ColorRectangle във нашия rectangles масив
        // този синтаксис за for loop е удачен когато не ни интересуват индекси на елементите, а само това
        // да обходим всеки един елемент

        // Arrays.toString(rectangles);

        for (ColorRectangle rect: rectangles) {
            System.out.println(rect.toString());
        }

        // еквивалентното изписване е това, но то включва индекси а те не ни интересуват в момента
        //        for(int i = 0; i < rectangles.length; i++) {
        //            System.out.println(rectangles[i].toString());
        //        }
    }

    public double calcSumArea() {
        double sum = 0;
        // ползваме същия синтаксис като от горе
        for(ColorRectangle rect: rectangles) {
            sum += rect.calcArea();
        }

        // еквивалентното изписване е това
        //        for(int i = 0; i < rectangles.length; i++) {
        //            sum += rectangles[i].calcArea();
        //        }

        return sum;
    }

    public double calcSumPerimeter() {
        double sum = 0;
        for(ColorRectangle rect: rectangles) {
            int xSide = rect.getiX2() - rect.getiX1();
            int ySide = rect.getiY2() - rect.getiY1();

            sum += (2*xSide) + (2*ySide);
        }

        // еквивалентното изписване е това
        //        for(int i = 0; i < rectangles.length; i++) {
        //            int xSide = rectangles[i].getiX2() - rectangles[i].getiX1();
        //            int ySide = rectangles[i].getiY2() - rectangles[i].getiY1();
        //
        //            sum += (2*xSide) + (2*ySide);
        //        }

        return sum;
    }


}
