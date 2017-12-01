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

    public LampItem(String lampID, int lampHue, int brightness, int saturation, boolean on) {
        this.lampID = lampID;
        this.lampHue = lampHue;
        this.brightness = brightness;
        this.on = on;
        this.saturation = saturation;
    }

    public void setOn(boolean on){
        this.on = on;
    }

    public void setBrightness(int brightness){
        this.brightness = brightness;
    }

    public void setLampHue(int lampHue){
        this.lampHue = lampHue;
    }

    public void setSaturation(int saturation){
        this.saturation = saturation;
    }

    public int getColor(){
        return Color.HSVToColor(new float[]{lampHue/254,brightness/254,saturation/10000});
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
