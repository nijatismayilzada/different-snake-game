package com.thepot.differentsnakegame;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Intent gameIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        button = findViewById(R.id.specialButton);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(gameIntent==null) {
                    gameIntent = new Intent(MainActivity.this, GameActivity.class);
                    gameIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                }
                startActivity(gameIntent);
            }
        });


    }

}
