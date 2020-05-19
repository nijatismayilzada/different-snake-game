package com.thepot.differentsnakegame.clicklistener;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.thepot.differentsnakegame.Board;

public class AdL extends AdListener {
    private InterstitialAd interstitialAd;
    private Board board;

    public AdL(InterstitialAd interstitialAd, Board board) {
        this.interstitialAd = interstitialAd;
        this.board = board;
    }

    @Override
    public void onAdClosed() {
        interstitialAd.loadAd(new AdRequest.Builder().build());
        board.loadSave();
    }
}
