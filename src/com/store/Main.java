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

	Color c = new Color((256*256*54) + (256*255) + 255);
	c.setRGBValue(150);
	System.out.println("" + c.getRValue() + ","+c.getGValue() + "," + c.getBValue());
    }
}
