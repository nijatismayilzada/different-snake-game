package com.thepot.differentsnakegame.clicklistener.gamebuttons;

import android.view.View;
import android.view.View.OnClickListener;

import com.thepot.differentsnakegame.Board;
import com.thepot.differentsnakegame.service.CageService;
import com.thepot.differentsnakegame.service.LevelService;
import com.thepot.differentsnakegame.service.SnakeService;

public class LoadSaveOCL implements OnClickListener {
    private SnakeService snakeService;
    private CageService cageService;
    private LevelService levelService;
    private Board board;

    public LoadSaveOCL(SnakeService snakeService, CageService cageService, LevelService levelService, Board board) {
        this.snakeService = snakeService;
        this.cageService = cageService;
        this.levelService = levelService;
        this.board = board;
    }

    @Override
    public void onClick(View v) {
        cageService.loadSavedCage();
        levelService.loadLevelSave();
        snakeService.getSnake(true);
        board.clearAndDraw();
    }
}
