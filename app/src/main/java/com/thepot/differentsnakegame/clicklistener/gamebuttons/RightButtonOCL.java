package com.thepot.differentsnakegame.clicklistener.gamebuttons;

import android.view.View;

import com.thepot.differentsnakegame.model.CellType;
import com.thepot.differentsnakegame.service.SnakeService;

public class RightButtonOCL implements View.OnClickListener {
    private SnakeService snakeService;

    public RightButtonOCL(SnakeService snakeService) {
        this.snakeService = snakeService;
    }

    @Override
    public void onClick(View v) {
        snakeService.makeNewHead(snakeService.getSnakeHeadAndTurnIntoBody().getY(),
                snakeService.getSnakeHeadAndTurnIntoBody().getX() + 1, CellType.SNAKE_HEAD_RIGHT);

    }
}
