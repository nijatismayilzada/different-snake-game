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
        int newX = checkX(snakeService.getSnakeHeadAndTurnIntoBody().getX() - 1);
        int XAhead = checkX(newX - 1);

        int Y = snakeService.getSnakeHeadAndTurnIntoBody().getY();

        snakeService.makeNewHead(Y, newX, Y, XAhead, CellType.SNAKE_HEAD_LEFT);

    }

    private int checkX(int X) {
        if (X < CELL_MIN_ID) {
            return CELL_MAX_ID;
        }
        return X;
    }
}
