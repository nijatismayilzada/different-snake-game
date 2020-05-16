package com.thepot.differentsnakegame.clicklistener.gamebuttons;

import android.view.View;
import android.view.View.OnClickListener;

import com.thepot.differentsnakegame.Board;

public class LoadSaveOCL implements OnClickListener {
    private Board board;

    public LoadSaveOCL(Board board) {
        this.board = board;
    }

    @Override
    public void onClick(View v) {
        board.loadSave();
    }
}
