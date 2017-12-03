package nl.arthurtech.hueapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    Button avansButton;
    Button emulatorButton;
    EditText addressBox;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        avansButton = findViewById(R.id.buttonReal);
        emulatorButton = findViewById(R.id.buttonSimulator);
        addressBox = findViewById(R.id.editAdres);

        avansButton.setOnClickListener((View v) -> {
            saveIP("http://145.48.205.33");
            LampCommunication.lampCommunication = new LampCommunication(this,"iYrmsQq1wu5FxF9CPqpJCnm1GpPVylKBWDUsNDhB",getFromSharedPreferences("IP"));
            startActivity(new Intent(this, LampListActivity.class));
        });

        emulatorButton.setOnClickListener((View v) -> {
            saveIP("http://192.168.1.3:80");
            startActivity(new Intent(this, LoadingActivity.class));
        });
    }

    private void saveIP(String ip){
        //TODO:Sla IP op in file om later op te kunnen halen
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MY_PREF",this.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("IP", ip);
        editor.commit();
    }

    private String getFromSharedPreferences(String key){
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MY_PREF",this.MODE_PRIVATE);
        return sharedPref.getString(key,"127.0.0.1");
    }
}
