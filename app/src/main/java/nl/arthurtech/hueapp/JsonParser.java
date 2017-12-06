package nl.arthurtech.hueapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Arthur on 30-11-2017.
 */

public class JsonParser
{
    public String parseApiKeyResponse(JSONArray response)
    {
        String key = "";

        try
        {
            JSONObject succes = response.getJSONObject(0);
            JSONObject keyObject = (JSONObject) succes.get("success");
            key = (String) keyObject.get("username");
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return key;
    }

    public ArrayList<LampItem> parseLampList(JSONObject response) throws JSONException
    {
        ArrayList<LampItem> lampList = new ArrayList<LampItem>();

        Iterator<String> iterator = response.keys();
        while (iterator.hasNext())
        {
            String key = iterator.next();
            try
            {
                JSONObject lightObject = (JSONObject) response.get(key);
                JSONObject stateObject = (JSONObject) lightObject.get("state");
                LampItem lamp = new LampItem(key, ((Integer) stateObject.get("hue")), ((Integer) stateObject.get("bri")), ((Integer) stateObject.get("sat")), ((boolean) stateObject.get("on")));
                Log.i("LAMP",lamp.toString());
                lampList.add(lamp);
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }

        return lampList;
    }
}
