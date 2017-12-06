package nl.arthurtech.hueapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        JsonParser jsonParser = new JsonParser();

        String address = getFromSharedPreferences("IP");

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

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, address+"/api", null, r -> {
            System.out.println(r);
            LampCommunication.lampCommunication = new LampCommunication(this,jsonParser.parseApiKeyResponse(r),address);
            Intent intent = new Intent(this, LampListActivity.class);
            startActivity(intent);
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
        MyVolleyRequestQueue.getInstance(this).getRequestQueue().add(request);
    }

    private String getFromSharedPreferences(String key){
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MY_PREF",this.MODE_PRIVATE);
        return sharedPref.getString(key,"127.0.0.1");
    }


}
