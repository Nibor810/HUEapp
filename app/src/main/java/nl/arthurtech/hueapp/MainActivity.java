package nl.arthurtech.hueapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button avansButton;
    Button emulatorButton;
    String ipAdress;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        avansButton = findViewById(R.id.buttonReal);
        emulatorButton = findViewById(R.id.buttonSimulator);

        avansButton.setOnClickListener((View v) -> {
            saveIP("avansIP");
            startActivity(new Intent(this, LampListActivity.class));
        });

        emulatorButton.setOnClickListener((View v) -> {
            saveIP("127.0.0.1");
            startActivity(new Intent(this, LoadingActivity.class));
        });

        //lampCommunication = new LampCommunication(ipAdress, this);
        //lampCommunication.getLamps();
    }

    private void saveIP(String ip){
        //TODO:Sla IP op in file om later op te kunnen halen
        SharedPreferences sharedPref = this.getPreferences(this.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("IP", ip);
        editor.commit();
    }
}
