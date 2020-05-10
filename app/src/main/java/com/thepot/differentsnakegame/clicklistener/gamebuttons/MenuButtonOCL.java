package com.thepot.differentsnakegame.clicklistener.gamebuttons;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.MainActivity;
import com.thepot.differentsnakegame.service.AdsService;

public class MenuButtonOCL implements View.OnClickListener {

    private AppCompatActivity activity;
    private AdsService adsService;

    public MenuButtonOCL(final AppCompatActivity activity, AdsService adsService) {
        this.activity = activity;
        this.adsService = adsService;
    }


    @Override
    public void onClick(View v) {
        if (adsService.canShowAd()) {
            adsService.showAd();
        } else {
            Intent mainIntent = new Intent(activity, MainActivity.class);
            mainIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            mainIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            activity.startActivity(mainIntent);
        }
    }
}
