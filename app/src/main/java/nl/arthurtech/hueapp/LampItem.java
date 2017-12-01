package nl.arthurtech.hueapp;

import android.graphics.Color;

/**
 * Created by robin on 24-11-2017.
 */

public class LampItem {
    private String lampID;
    private int lampHue;
    private int brightness;
    private boolean on;
    private int saturation;

    public LampItem(String lampID, int lampHue) {
        this.lampID = lampID;
        this.lampHue = lampHue;
    }

    public String getLampID() {
        return lampID;
    }

    public int getLampHue() {
        return lampHue;
    }

    public int getBrightness() {
        return brightness;
    }

    public boolean getOn() {
        return on;
    }

    public int getSaturation() {
        return saturation;
    }
}
