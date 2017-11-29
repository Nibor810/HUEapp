package nl.arthurtech.hueapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        //Requests Key
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, "", null, r -> {
            System.out.println(r);
        }, error -> {
            Log.d("ERROR", "API CALL ERROR");
            Log.d("ERROR", error.getMessage());
        });
        MyVolleyRequestQueue.getInstance(this).getRequestQueue().add(request);
    }
}
