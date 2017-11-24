package nl.arthurtech.hueapp;

import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LampListActivity extends AppCompatActivity implements ListFragment.OnFragmentInteractionListener, LampDetailFragment.OnFragmentInteractionListener{
    //RecyclerView recyclerView;
    //LampRecyclerViewAdapter lampRecyclerViewAdapter;
    List<LampItem> lamps= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamp_list);

        //GetLamps();
        //recyclerView =findViewById(R.id.recyclerView);
        //recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //lampRecyclerViewAdapter = new LampRecyclerViewAdapter(this, lamps);
        //recyclerView.setAdapter(lampRecyclerViewAdapter);
    }

    //Moet de lampen in de lijst met lampitems stoppen
    private void GetLamps() {
        lamps.add(new LampItem("Lamp 1",1235));
        lamps.add(new LampItem("Lamp 2",2725));
        lamps.add(new LampItem("Lamp 3",9521));
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
