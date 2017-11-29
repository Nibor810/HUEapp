package nl.arthurtech.hueapp;

import android.content.Context;
import android.util.Log;

import com.android.volley.*;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

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

    public LampCommunication(Context context, String APIUserId)
    {
        this.context = context;
        this.APIUserId = APIUserId;

        getLamps();
    }

    public void getLamps()
    {
        //Request the API Key
        JSONObject json = new JSONObject();
        try
        {
            json.put("devicetype", "Phone");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        final String jsonBody = json.toString();
        String url = "http://192.168.1.3:80/api/" + APIUserId;

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, r -> {
            System.out.println(r);
        }, error -> {
            Log.d("ERROR", "API CALL ERROR");
            Log.d("ERROR", error.getMessage());
        })
        {
            @Override
            public String getBodyContentType()
            {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody()
            {
                if(jsonBody != null)
                {
                    try
                    {
                        return jsonBody.getBytes("utf-8");
                    }
                    catch (UnsupportedEncodingException e)
                    {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };
        MyVolleyRequestQueue.getInstance(context).getRequestQueue().add(request);
    }

    /*
    private void getCallLampApi(String resource, Context context)
    {
        String url = APIUrl + resource;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String r)
                    {
                        System.out.println(r);

                        //TODO: CALL CALLBACK LOADING ACTIVITY
                    }
                }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.d("ERROR", "API CALL ERROR");
                Log.d("ERROR", error.getMessage());
            }
        });

        MyVolleyRequestQueue.getInstance(context).getRequestQueue().add(stringRequest);
    }

    private String putCallLampApi(String resource, String data)
    {
        return "";
    }

    private void postCallLampApi(String resource, String data)
    {
        String url = APIUrl + resource;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        //loadJsonArray(response);
                    }
                },
                new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.d("ERROR", "API CALL ERROR");
            }
        });
    }

    public void setAPIUserId(String APIUserId)
    {
        this.APIUserId = APIUserId;
    }

    public ArrayList<LampItem> getLampList()
    {
        return  new ArrayList<LampItem>();
    }
    */
}


