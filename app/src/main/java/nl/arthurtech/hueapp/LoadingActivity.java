package nl.arthurtech.hueapp;

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

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, "http://192.168.1.3:80/api", null, r -> {
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
                    } catch (UnsupportedEncodingException e)
                    {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };
        MyVolleyRequestQueue.getInstance(this).getRequestQueue().add(request);
    }
}
