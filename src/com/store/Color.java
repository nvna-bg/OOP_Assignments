package com.store;

import java.util.Objects;

public class Color implements Comparable {
    private long RValue;
    private long GValue;
    private long BValue;

    private long RGBValue;

    public Color() {
        // project 3 additions
//        RValue = Console.readLong("Red:");
//        GValue = Console.readLong("Green:");
//        BValue = Console.readLong("Blue:");
//
//        RValue = (RValue < 0) ? 0 : (RValue > 255) ? 255 : RValue;
//        GValue = (GValue < 0) ? 0 : (GValue > 255) ? 255 : GValue;
//        BValue = (BValue < 0) ? 0 : (BValue > 255) ? 255 : BValue;
    }

    public Color(long rgb) {
        RValue = rgb / 65536;
        GValue = (rgb / 256) % 256;
        BValue = rgb % 256;
        RGBValue = rgb;
    }
    
    public int compareTo(Object o) {
        if(this == o) return 0;
        if (o == null || getClass() != o.getClass()) return -2;
        Color color = (Color)o;
        return (color.RGBValue > RGBValue) ? 1 : (color.RGBValue < RGBValue) ? -1 : 0;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return RValue == color.GValue &&
                GValue == color.GValue &&
                BValue == color.BValue &&
                RGBValue == color.RGBValue;
    }

    public long getRValue() {
        return RValue;
    }

    public void setRValue(long rv) {
        GValue = (RGBValue / 256) % 256;
        BValue = RGBValue % 256;

        long newR = 256*256*rv;

        RGBValue = newR + GValue + BValue;

        this.RValue = (RValue < 0) ? 0 : (RValue > 255) ? 255 : RValue;
    }

    public long getGValue() {
        return GValue;
    }

    public void setGValue(long gv) {
        RValue = RGBValue / 65536;
        BValue = RGBValue % 256;

        long newG = 256 * gv;

        RGBValue = RValue + newG + BValue;
        this.GValue = (GValue < 0) ? 0 : (GValue > 255) ? 255 : GValue;
    }

    public long getBValue() {
        return BValue;
    }

    public void setBValue(long bv) {
        this.BValue = (bv < 0) ? 0 : (bv > 255) ? 255 : bv;
    }

    public long getRGBValue() {
        return RGBValue;
    }

    public void setRGBValue(long RGBValue) {
        this.RGBValue = RGBValue;
        RValue = RGBValue / 65536;
        GValue = (RGBValue / 256) % 256;
        BValue = RGBValue % 256;
        this.RGBValue = RGBValue;
    }

    public String toString() {
        return String.format("RGB(%1$s,%2$s,%3$s)", RValue, GValue, BValue);
    }
}
