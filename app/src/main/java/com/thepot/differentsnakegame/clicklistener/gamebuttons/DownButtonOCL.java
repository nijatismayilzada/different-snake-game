package com.thepot.differentsnakegame.clicklistener.gamebuttons;

import android.view.View;

import com.thepot.differentsnakegame.model.CellType;
import com.thepot.differentsnakegame.service.MovingService;
import com.thepot.differentsnakegame.service.SnakeService;

import static android.view.View.OnClickListener;

public class DownButtonOCL implements OnClickListener {
    private SnakeService snakeService;
    private MovingService movingService;

    public DownButtonOCL(SnakeService snakeService, MovingService movingService) {
        this.snakeService = snakeService;
        this.movingService = movingService;
    }

    @Override
    public void onClick(View v) {
        movingService.makeNewHead(snakeService.getSnakeHeadAndTurnIntoBody().getY() + 1,
                snakeService.getSnakeHeadAndTurnIntoBody().getX(), CellType.SNAKE_HEAD_DOWN);

    }
}
