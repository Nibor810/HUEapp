package nl.arthurtech.hueapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    public LampCommunication lampCommunication;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lampCommunication = new LampCommunication(true, this);
        lampCommunication.getLamps();
    }

    public LampCommunication getLampCommunication()
    {
        return lampCommunication;
    }
}
