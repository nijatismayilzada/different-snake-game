package com.thepot.differentsnakegame.clicklistener.gamebuttons;

import android.view.View;

import com.thepot.differentsnakegame.model.CellType;
import com.thepot.differentsnakegame.service.SnakeService;

import static com.thepot.differentsnakegame.service.CageService.CELL_MAX_ID;
import static com.thepot.differentsnakegame.service.CageService.CELL_MIN_ID;

public class UpButtonOCL implements View.OnClickListener {

    private SnakeService snakeService;

    public UpButtonOCL(SnakeService snakeService) {
        this.snakeService = snakeService;
    }

    @Override
    public void onClick(View v) {
        int newY = snakeService.getSnakeHeadAndTurnIntoBody().getY() - 1;

        if (newY < CELL_MIN_ID) {
            newY = CELL_MAX_ID;
        }

        snakeService.makeNewHead(newY, snakeService.getSnakeHeadAndTurnIntoBody().getX(), CellType.SNAKE_HEAD_UP);

    }
}
