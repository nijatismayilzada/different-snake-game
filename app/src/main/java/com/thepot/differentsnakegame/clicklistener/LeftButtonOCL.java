package com.thepot.differentsnakegame.clicklistener;

import android.view.View;

import com.thepot.differentsnakegame.model.CellType;
import com.thepot.differentsnakegame.model.Snake;
import com.thepot.differentsnakegame.service.MovingService;

public class LeftButtonOCL implements View.OnClickListener {
    private Snake snake;
    private MovingService movingService;

    public LeftButtonOCL(Snake snake, MovingService movingService) {
        this.snake = snake;
        this.movingService = movingService;
    }

    @Override
    public void onClick(View v) {
        movingService.makeNewHead(snake.getSnakeHeadAndTurnIntoBody().getY(),
                snake.getSnakeHeadAndTurnIntoBody().getX() - 1, CellType.SNAKE_HEAD_LEFT);

    }
}
