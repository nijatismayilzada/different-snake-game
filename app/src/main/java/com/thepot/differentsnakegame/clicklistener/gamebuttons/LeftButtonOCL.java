package com.thepot.differentsnakegame.clicklistener.gamebuttons;

import android.view.View;

import com.thepot.differentsnakegame.model.CellType;
import com.thepot.differentsnakegame.service.SnakeService;

import static com.thepot.differentsnakegame.service.CageService.CELL_MAX_ID;
import static com.thepot.differentsnakegame.service.CageService.CELL_MIN_ID;

public class LeftButtonOCL implements View.OnClickListener {
    private SnakeService snakeService;

    public LeftButtonOCL(SnakeService snakeService) {
        this.snakeService = snakeService;
    }

    @Override
    public void onClick(View v) {
        int newX = snakeService.getSnakeHeadAndTurnIntoBody().getX() - 1;

        if (newX < CELL_MIN_ID) {
            newX = CELL_MAX_ID;
        }

        snakeService.makeNewHead(snakeService.getSnakeHeadAndTurnIntoBody().getY(), newX, CellType.SNAKE_HEAD_LEFT);

    }
}
