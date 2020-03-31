package com.thepot.differentsnakegame.clicklistener;

import android.view.View;

import com.thepot.differentsnakegame.model.CellType;
import com.thepot.differentsnakegame.model.Snake;
import com.thepot.differentsnakegame.service.MovingService;

public class RightButtonOCL  implements View.OnClickListener {
    private Snake snake;
    private MovingService movingService;

    public RightButtonOCL(Snake snake, MovingService movingService) {
        this.snake = snake;
        this.movingService = movingService;
    }

    @Override
    public void onClick(View v) {
        movingService.makeNewHead(snake.getSnakeHeadAndTurnIntoBody().getY(),
                snake.getSnakeHeadAndTurnIntoBody().getX() + 1, CellType.SNAKE_HEAD_RIGHT);

    }
}
