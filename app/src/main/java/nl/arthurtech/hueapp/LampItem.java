package nl.arthurtech.hueapp;

import android.graphics.Color;

/**
 * Created by robin on 24-11-2017.
 */

public class LampItem {
    private String lampID;
    private Color lampColor;


    public LampItem(String lampID, Color lampColor) {
        this.lampID = lampID;
        this.lampColor = lampColor;
    }

    public String getLampID() {
        return lampID;
    }

    public Color getLampColor() {
        return lampColor;
    }
}
