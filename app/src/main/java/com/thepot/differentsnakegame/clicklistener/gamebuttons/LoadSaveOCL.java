package com.thepot.differentsnakegame.clicklistener.gamebuttons;

import android.view.View;
import android.view.View.OnClickListener;

import com.thepot.differentsnakegame.Board;
import com.thepot.differentsnakegame.service.AdsService;

public class LoadSaveOCL implements OnClickListener {
    private Board board;
    private AdsService adsService;

    public LoadSaveOCL(Board board, AdsService adsService) {
        this.board = board;
        this.adsService = adsService;
    }

    @Override
    public void onClick(View v) {
        if (adsService.canShowAd()) {
            adsService.showAd();
        } else {
            board.loadSave();
        }
    }
}
