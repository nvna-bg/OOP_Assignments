package com.store;

public class ColorRectangle extends Color implements Comparable {
    private int iX1, iX2, iY1, iY2;

    public ColorRectangle() {
        super();
        // project 3 additions

        int x1 = Console.readInt("x1:");
        int y1 = Console.readInt("y1:");
        int x2 = Console.readInt("x2:");
        int y2 = Console.readInt("y2:");

        iX1 = (x1 < x2) ? x1 : x2;
        iY1 = (y1 < y2) ? y1 : y2;
        iX2 = (x2 > x1) ? x2 : x1;
        iY2 = (y2 > y1) ? y2 : y1;
    }

    public ColorRectangle(int x1, int y1, int x2, int y2, long color) {
        super(color);
//         without rearranging in coordinate space
//         iX1 = x1; iX2 = x2; iY1 = y1; iY2 = y2;
//         rearrange in coordinate space
        iX1 = (x1 < x2) ? x1 : x2;
        iY1 = (y1 < y2) ? y1 : y2;
        iX2 = (x2 > x1) ? x2 : x1;
        iY2 = (y2 > y1) ? y2 : y1;
    }


    public int getiX1() {
        return iX1;
    }

    public void setiX1(int x1) {
        if(x1 <= iX2) iX1 = x1;
        else {
            iX2 = iX1;
            iX1 = x1;
        }
    }

    public int getiX2() {
        return iX2;
    }

    public void setiX2(int x2) {
        if(x2 >= iX1) iX2 = x2;
        else {
            iX1 = iX2;
            iX2 = x2;
        }
    }

    public int getiY1() {
        return iY1;
    }

    public void setiY1(int y1) {
        if(y1 <= iY2) iY1 = y1;
        else {
            iY2 = iY1;
            iY1 = y1;
        }
    }

    public int getiY2() {
        return iY2;
    }

    public void setiY2(int y2) {
        if(y2 >= iY1) iY2 = y2;
        else {
            iY1 = iY2;
            iY2 = y2;
        }
    }

    public int calcArea() {
        return Math.abs((iX2 - iX1) * (iY2 - iY1));
    }

    public int compareTo(Object o) {
        if(this == o) return 0;
        ColorRectangle colorRect = (ColorRectangle)o;
        return (colorRect.calcArea() > calcArea()) ? 1 : (colorRect.calcArea() < calcArea()) ? -1 : 0;
    }

    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        ColorRectangle colorRectangle = (ColorRectangle)o;
        return (calcArea() == colorRectangle.calcArea()) && (getRGBValue() == colorRectangle.getRGBValue());
    }

    public void translateX(int iPoints) {
        iX1 += iPoints;
        iX2 += iPoints;
    }

    public void translateY(int iPoints) {
        iY1 += iPoints;
        iY2 += iPoints;
    }

    public void translate(int iPoints) {
        translateX(iPoints);
        translateY(iPoints);
    }

    public boolean isInside(int ptX, int ptY) {
        if(iX1 < ptX && ptX < iX2) {
            if(iY1 < ptY && ptY < iY2) {
                return true;
            }
            else return false;
        }
        else return false;
    }

    public ColorRectangle envelopeRectangle(ColorRectangle other) {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        if(iX1 < other.getiX1()) {
            x1 = iX1;
        }
        else {
            x1 = other.getiX1();
        }
        if(iY1 < other.getiY1()) {
            y1 = iY1;
        }
        else {
            y1 = other.getiY1();
        }
        if(iX2 > other.getiX2()) {
            x2 = iX2;
        }
        else {
            x2 = other.getiX2();
        }
        if(iY2 > other.getiY2()) {
            y2 = iY2;
        }
        else {
            y2 = other.getiY2();
        }

        ColorRectangle result = new ColorRectangle(x1, y1, x2, y2, 5223);
        return result;

//        int x1 = (other.iX1 < this.iX1) ? other.iX1 : this.iX1;
//        int y1 = (other.iY1 < this.iY1) ? other.iY1 : this.iY1;
//        int x2 = (other.iX2 > this.iX2) ? other.iX2 : this.iX2;
//        int y2 = (other.iY2 > this.iY2) ? other.iY2 : this.iY2;
//
//        return new ColorRectangle(x1, y1, x2, y2, Math.round((other.getRGBValue() + getRGBValue())/2));
    }

    public ColorRectangle unionRectangle(ColorRectangle other) {
        int x1 = (other.iX1 > this.iX1) ? other.iX1 : this.iX1;
        int y1 = (other.iY1 > this.iY1) ? other.iY1 : this.iY1;
        int x2 = (other.iX2 < this.iX2) ? other.iX2 : this.iX2;
        int y2 = (other.iY2 < this.iY2) ? other.iY2 : this.iY2;

        if(x2 < x1) x1 = x2 = 0;
        if(y2 < y1) y1 = y2 = 0;
        return new ColorRectangle(x1, y1, x2, y2, Math.round((other.getRGBValue() + getRGBValue())/2));
    }

    public String toString() {
        return String.format("(%1$s,%2$s),(%3$s,%4$s),%5$s", iX1, iY1, iX2, iY2, super.toString());
    }
}
