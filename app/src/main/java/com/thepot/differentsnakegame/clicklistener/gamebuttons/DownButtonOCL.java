package com.thepot.differentsnakegame.clicklistener.gamebuttons;

import android.view.View;

import com.thepot.differentsnakegame.model.CellType;
import com.thepot.differentsnakegame.service.SnakeService;

import static android.view.View.OnClickListener;
import static com.thepot.differentsnakegame.service.CageService.CELL_MAX_ID;
import static com.thepot.differentsnakegame.service.CageService.CELL_MIN_ID;

public class DownButtonOCL implements OnClickListener {
    private SnakeService snakeService;

    public DownButtonOCL(SnakeService snakeService) {
        this.snakeService = snakeService;
    }

    @Override
    public void onClick(View v) {
        int newY = checkY(snakeService.getSnakeHeadAndTurnIntoBody().getY() + 1);
        int YAhead = checkY(newY + 1);

        int X = snakeService.getSnakeHeadAndTurnIntoBody().getX();

        snakeService.makeNewHead(newY, X, YAhead, X, CellType.SNAKE_HEAD_DOWN);

    }

    private int checkY(int Y) {
        if (Y > CELL_MAX_ID) {
            return CELL_MIN_ID;
        }
        return Y;
    }
}
