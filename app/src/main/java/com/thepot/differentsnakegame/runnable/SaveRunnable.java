package com.thepot.differentsnakegame.runnable;

import com.thepot.differentsnakegame.Board;

public class SaveRunnable implements Runnable {
    private Board board;

    public SaveRunnable(Board board) {
        this.board = board;
    }

    @Override
    public void run() {
        board.saveGame();
    }
}
