package nl.arthurtech.hueapp;

import android.content.Intent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

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

        try
        {
            for(int i = 1; i < (response.length() + 1); i++)
            {
                JSONObject lightObject = (JSONObject) response.get(Integer.toString(i));
                JSONObject stateObject = (JSONObject) lightObject.get("state");
                lampList.add(new LampItem(Integer.toString(i), ((Integer) stateObject.get("hue"))));
            }
        } catch (JSONException e)
        {
            e.printStackTrace();
        }


        return lampList;
    }


}
