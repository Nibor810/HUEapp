package nl.arthurtech.hueapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.android.volley.*;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by Arthur on 18-11-2017.
 */

public class LampCommunication
{
    private String APIUrl;
    private String APIUserId;
    private Context context;
    private JsonParser jsonParser;

    public LampCommunication(Context context, String APIUserId)
    {
        this.context = context;
        this.APIUserId = APIUserId;

        jsonParser = new JsonParser();

        getLamps();
    }

    public void getLamps()
    {
        /*
        //Request the API Key
        String url = "http://192.168.1.3:80/api/" + APIUserId;

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, r -> {
            try
            {
                jsonParser.parseLampList(r);
            } catch (JSONException e)
            {
                e.printStackTrace();
            }
        }, error -> {
            Log.d("ERROR", "API CALL ERROR");
            Log.d("ERROR", error.getMessage());
        });
        MyVolleyRequestQueue.getInstance(context).getRequestQueue().add(request);*/

        String url = "http://192.168.1.3:80/api/" + APIUserId + "/lights";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                result ->
                {
                    try
                    {
                        ArrayList<LampItem> lamps = jsonParser.parseLampList(new JSONObject(result));
                    } catch (JSONException e)
                    {
                        e.printStackTrace();
                    }
                },
                error ->
                {
                    Log.d("ERROR", "API CALL ERROR");
                    Log.d("ERROR", error.getMessage());
                });

        MyVolleyRequestQueue.getInstance(context).getRequestQueue().add(stringRequest);
    }
}


