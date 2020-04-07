package com.thepot.differentsnakegame.clicklistener.gamebuttons;

import android.view.View;

import com.thepot.differentsnakegame.model.CellType;
import com.thepot.differentsnakegame.service.MovingService;
import com.thepot.differentsnakegame.service.SnakeService;

public class LeftButtonOCL implements View.OnClickListener {
    private SnakeService snakeService;
    private MovingService movingService;

    public LeftButtonOCL(SnakeService snakeService, MovingService movingService) {
        this.snakeService = snakeService;
        this.movingService = movingService;
    }

    @Override
    public void onClick(View v) {
        movingService.makeNewHead(snakeService.getSnakeHeadAndTurnIntoBody().getY(),
                snakeService.getSnakeHeadAndTurnIntoBody().getX() - 1, CellType.SNAKE_HEAD_LEFT);

    }
}
