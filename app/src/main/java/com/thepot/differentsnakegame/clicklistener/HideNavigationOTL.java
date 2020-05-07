package com.thepot.differentsnakegame.clicklistener;

import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.R;

public class HideNavigationOTL implements View.OnTouchListener {

    private AppCompatActivity activity;

    public HideNavigationOTL(AppCompatActivity activity) {
        this.activity = activity;
        this.activity.findViewById(R.id.activity_main).setOnTouchListener(this);
        hideSystemUI();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        hideSystemUI();
        v.performClick();
        return v.onTouchEvent(event);
    }


    public void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }
}
