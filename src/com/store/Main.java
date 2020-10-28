package com.store;

public class Main {

    public static void main(String[] args) {
//	ColorRectangle rect = new ColorRectangle();
//	System.out.println(rect);
//
//	rect.translate(Console.readInt("translate x and y with:"));
//	System.out.println(rect);
//
//	ColorRectangle other = new ColorRectangle();
//	Console.printPrompt("are the two rects equal? " + (rect.equals(other)));
//
//	ColorRectangle intersection = rect.unionRectangle(other);
//	System.out.println(intersection);
//
//	ColorRectangle envelope = rect.envelopeRectangle(other);
//	System.out.println(envelope);

//	Color c = new Color((256*256*54) + (256*255) + 255);
//	c.setRGBValue(150);
//	System.out.println("" + c.getRValue() + ","+c.getGValue() + "," + c.getBValue());


		LibraryBook b1 = new LibraryBook("Kniga 1", false);
		System.out.println(b1);
		Reader r1 = new Reader("Georgi", "51232");
		b1.setReader(r1);
		System.out.println(b1);
    }
}
