package com.thepot.differentsnakegame.clicklistener.gamebuttons;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.Board;
import com.thepot.differentsnakegame.R;
import com.thepot.differentsnakegame.service.AdsService;
import com.thepot.differentsnakegame.service.LevelService;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class LoadSaveOCL implements OnClickListener {
    private Board board;
    private AdsService adsService;
    private ImageButton loadSaveButton;

    public LoadSaveOCL(AppCompatActivity activity, Board board, AdsService adsService, LevelService levelService) {
        this.board = board;
        this.adsService = adsService;
        loadSaveButton = activity.findViewById(R.id.loadSave);
        loadSaveButton.setOnClickListener(this);
        showLoadSaveButton(levelService.gameSaveExists());
    }

    private void showLoadSaveButton(boolean show) {
        if (show) {
            loadSaveButton.setVisibility(VISIBLE);
        } else {
            loadSaveButton.setVisibility(GONE);
        }
    }

    public void clickableLoadSaveButton(boolean show) {
        loadSaveButton.setClickable(show);
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
