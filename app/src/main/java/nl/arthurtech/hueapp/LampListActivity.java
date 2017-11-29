package nl.arthurtech.hueapp;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LampListActivity extends AppCompatActivity implements ListFragment.OnFragmentInteractionListener, LampDetailFragment.OnFragmentInteractionListener {
    //RecyclerView recyclerView;
    //LampRecyclerViewAdapter lampRecyclerViewAdapter;
    List<LampItem> lamps = new ArrayList<>();
    private static final String TAG = "LampListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lamp_list);
        String apiKey;
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            //TODO: what to do with empty key.
        } else {
            apiKey = extras.getString("APIKEY");
        }
        //TODO: Create Lamp Communication
    }

    @Override
    public void onFragmentInteraction(LampItem lamp) {
        LampDetailFragment lampDetailFragment = (LampDetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_lamp_list);
        Log.i(TAG, "ListitemClicked");
        lampDetailFragment.setLamp(lamp);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}
