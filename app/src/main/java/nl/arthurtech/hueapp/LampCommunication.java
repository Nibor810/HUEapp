package nl.arthurtech.hueapp;

import android.content.Context;
import android.util.Log;

import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by Arthur on 18-11-2017.
 */

public class LampCommunication
{
    private String APIUrl;
    private String APIUserId;
    private Context context;

    public LampCommunication(String ipAdress, Context context)
    {
        APIUrl = ipAdress;
        this.context = context;

        getCallLampApi("", context);
    }

    public void getLamps()
    {
        getCallLampApi("/" + APIUserId, context);
    }

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

    public String getAPIUserId()
    {
        return APIUserId;
    }

    public void setAPIUserId(String APIUserId)
    {
        this.APIUserId = APIUserId;
    }
}


