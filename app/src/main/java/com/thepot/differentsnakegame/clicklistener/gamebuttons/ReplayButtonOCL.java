package com.thepot.differentsnakegame.clicklistener.gamebuttons;

import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.Board;

public class ReplayButtonOCL implements View.OnClickListener {

    private AppCompatActivity activity;
    private ImageView boardHolder;
    private Board board;

    public ReplayButtonOCL(AppCompatActivity activity, ImageView boardHolder, Board board) {
        this.activity = activity;
        this.boardHolder = boardHolder;
        this.board = board;
    }

    @Override
    public void onClick(View v) {
        board.initialiseServices(activity, boardHolder);
        board.clearAndDraw();
    }
}
