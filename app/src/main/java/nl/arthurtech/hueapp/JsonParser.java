package nl.arthurtech.hueapp;

import android.content.Intent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
}
