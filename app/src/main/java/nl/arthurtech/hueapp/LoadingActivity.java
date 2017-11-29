package nl.arthurtech.hueapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://145.49.19.85:80/api",
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String r)
                    {
                        System.out.println(r);

                        //TODO: Make seperate Request for API Key.
                        //TODO: CALL CALLBACK LOADING ACTIVITY
                    }
                },
                new Response.ErrorListener()
        {

            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.d("ERROR", "API CALL ERROR");
                Log.d("ERROR", error.getMessage());
            }
        })
        {
            /* Possible PARAMS.
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("devicetype", "Phone");

                return params;
            }*/
        };

        MyVolleyRequestQueue.getInstance(this).getRequestQueue().add(stringRequest);
    }
}
