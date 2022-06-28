package com.thepot.differentsnakegame.service;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.thepot.differentsnakegame.Board;
import com.thepot.differentsnakegame.R;

public class AdsService {

    public static final String AD_UNIT_ID = "ca-app-pub-3436517585020059/5097995112";
    //    public static final String AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712"; // test
    private InterstitialAd mInterstitialAd;
    private int clickCount;
    private static final int CLICK_THRESHOLD = 2;

    private AppCompatActivity activity;
    private Board board;

    public AdsService(AppCompatActivity activity, Board board) {

        this.activity = activity;
        this.board = board;
        MobileAds.initialize(activity, initializationStatus -> {
        });
//        MobileAds.setRequestConfiguration(new RequestConfiguration.Builder().setTestDeviceIds(singletonList("35CC9854176EF7429B8898AC4FBB9CF6")).build()); // test
        activity.<AdView>findViewById(R.id.adView).loadAd(new AdRequest.Builder().build());

        load(activity, board);
        clickCount = CLICK_THRESHOLD - 1;
    }

    public boolean canShowAd() {
        clickCount++;
        if (mInterstitialAd == null) {
            load(activity, board);
            return false;
        }

        if (clickCount > CLICK_THRESHOLD) {
            clickCount = 0;
            return true;
        }

        return false;
    }

    private void load(AppCompatActivity activity, Board board) {
        InterstitialAd.load(activity, AD_UNIT_ID, new AdRequest.Builder().build(),
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                mInterstitialAd = null;
                                board.loadSave();
                            }
                        });

                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                    }
                });
    }

    public void showAd() {
        mInterstitialAd.show(activity);
    }

}


