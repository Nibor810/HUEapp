package nl.arthurtech.hueapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button avansButton;
    Button emulatorButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        avansButton = findViewById(R.id.buttonReal);
        emulatorButton = findViewById(R.id.buttonSimulator);

        avansButton.setOnClickListener((View v) -> {
            
        });

    }
}
