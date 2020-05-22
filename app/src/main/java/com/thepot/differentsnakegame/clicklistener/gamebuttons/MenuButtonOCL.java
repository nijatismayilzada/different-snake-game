package com.thepot.differentsnakegame.clicklistener.gamebuttons;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.MainActivity;
import com.thepot.differentsnakegame.R;

public class MenuButtonOCL implements View.OnClickListener {

    private AppCompatActivity activity;

    public MenuButtonOCL(final AppCompatActivity activity) {
        this.activity = activity;
        this.activity.findViewById(R.id.menu).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        Intent mainIntent = new Intent(activity, MainActivity.class);
        mainIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        activity.startActivity(mainIntent);

    }
}
