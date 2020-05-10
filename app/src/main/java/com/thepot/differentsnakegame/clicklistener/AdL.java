package com.thepot.differentsnakegame.clicklistener;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.thepot.differentsnakegame.MainActivity;

public class AdL extends AdListener {
    private AppCompatActivity activity;
    private InterstitialAd interstitialAd;

    public AdL(final AppCompatActivity activity, InterstitialAd interstitialAd) {
        this.activity = activity;
        this.interstitialAd = interstitialAd;
    }

    @Override
    public void onAdClosed() {
        interstitialAd.loadAd(new AdRequest.Builder().build());
        Intent mainIntent = new Intent(activity, MainActivity.class);
        mainIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        activity.startActivity(mainIntent);
    }
}
