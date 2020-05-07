package com.thepot.differentsnakegame.clicklistener.menu;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.R;

public class ExitGameOCL implements View.OnClickListener {
    private AppCompatActivity activity;

    public ExitGameOCL(AppCompatActivity activity) {
        this.activity = activity;
        this.activity.findViewById(R.id.exit).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        activity.finishAffinity();
        System.exit(0);
    }
}
