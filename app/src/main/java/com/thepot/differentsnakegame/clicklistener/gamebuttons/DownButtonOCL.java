package com.thepot.differentsnakegame.clicklistener.gamebuttons;

import android.view.View;

import com.thepot.differentsnakegame.model.CellType;
import com.thepot.differentsnakegame.service.SnakeService;

import static android.view.View.OnClickListener;

public class DownButtonOCL implements OnClickListener {
    private SnakeService snakeService;

    public DownButtonOCL(SnakeService snakeService) {
        this.snakeService = snakeService;
    }

    @Override
    public void onClick(View v) {
        snakeService.makeNewHead(snakeService.getSnakeHeadAndTurnIntoBody().getY() + 1,
                snakeService.getSnakeHeadAndTurnIntoBody().getX(), CellType.SNAKE_HEAD_DOWN);

    }
}
