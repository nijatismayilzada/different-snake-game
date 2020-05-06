package com.thepot.differentsnakegame.clicklistener;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.thepot.differentsnakegame.R;

import static java.util.Collections.singletonList;

public class AdsOICL implements OnInitializationCompleteListener {

    public AdsOICL(AppCompatActivity appCompatActivity) {
        MobileAds.initialize(appCompatActivity, this);
        MobileAds.setRequestConfiguration(new RequestConfiguration.Builder().setTestDeviceIds(singletonList("35CC9854176EF7429B8898AC4FBB9CF6")).build());
        appCompatActivity.<AdView>findViewById(R.id.adView).loadAd(new AdRequest.Builder().build());
    }

    @Override
    public void onInitializationComplete(InitializationStatus initializationStatus) {

    }
}
