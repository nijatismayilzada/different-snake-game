package com.thepot.differentsnakegame.clicklistener.menu;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ExitGameOCL implements View.OnClickListener {
    private AppCompatActivity activity;

    public ExitGameOCL(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        activity.finishAffinity();
        System.exit(0);
    }
}
