package nl.arthurtech.hueapp;

import java.util.List;

/**
 * Created by Gebruiker on 1-12-2017.
 */

public interface LampUpdateCallback {
    void updateLampList(List<LampItem> lamps);
}
