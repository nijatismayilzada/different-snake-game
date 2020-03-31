package com.thepot.differentsnakegame.clicklistener;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.Board;

public class BoardHolderObserver implements OnGlobalLayoutListener {

    private Board board;
    private AppCompatActivity activity;
    private ImageView boardHolder;

    public BoardHolderObserver(AppCompatActivity activity, ImageView boardHolder) {
        this.activity = activity;
        this.boardHolder = boardHolder;
    }

    @Override
    public void onGlobalLayout() {
        if (board == null) {
            board = new Board(activity, boardHolder);
        }
    }
}
