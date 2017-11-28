package nl.arthurtech.hueapp;

import android.graphics.Color;

/**
 * Created by robin on 24-11-2017.
 */

public class LampItem {
    private String lampID;
    private int lampColor;


    public LampItem(String lampID, int lampColor) {
        this.lampID = lampID;
        this.lampColor = lampColor;
    }

    public String getLampID() {
        return lampID;
    }

    public int getLampColor() {
        return lampColor;
    }
}
