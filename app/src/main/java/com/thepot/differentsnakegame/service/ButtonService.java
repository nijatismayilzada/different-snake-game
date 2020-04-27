package com.thepot.differentsnakegame.service;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.R;
import com.thepot.differentsnakegame.clicklistener.gamebuttons.DownButtonOCL;
import com.thepot.differentsnakegame.clicklistener.gamebuttons.LeftButtonOCL;
import com.thepot.differentsnakegame.clicklistener.gamebuttons.RightButtonOCL;
import com.thepot.differentsnakegame.clicklistener.gamebuttons.UpButtonOCL;
import com.thepot.differentsnakegame.model.Cell;

import static com.thepot.differentsnakegame.service.CageService.CELL_MAX_ID;
import static com.thepot.differentsnakegame.service.CageService.CELL_MIN_ID;

public class ButtonService {
    private ImageButton upButton;
    private ImageButton downButton;
    private ImageButton leftButton;
    private ImageButton rightButton;
    private TextView gameOver;

    private CageService cageService;
    private SnakeService snakeService;
    private LevelService levelService;

    public ButtonService(AppCompatActivity activity, CageService cageService, SnakeService snakeService, LevelService levelService) {
        this.cageService = cageService;
        this.snakeService = snakeService;
        this.levelService = levelService;

        upButton = activity.findViewById(R.id.upButton);
        upButton.setOnClickListener(new UpButtonOCL(snakeService));
        downButton = activity.findViewById(R.id.downButton);
        downButton.setOnClickListener(new DownButtonOCL(snakeService));
        leftButton = activity.findViewById(R.id.leftButton);
        leftButton.setOnClickListener(new LeftButtonOCL(snakeService));
        rightButton = activity.findViewById(R.id.rightButton);
        rightButton.setOnClickListener(new RightButtonOCL(snakeService));

        gameOver = activity.findViewById(R.id.gameOver);
    }

    public void updateButtons() {

        upButton.setClickable(true);
        downButton.setClickable(true);
        leftButton.setClickable(true);
        rightButton.setClickable(true);

        Cell snakeHead = snakeService.getSnakeHead();

        int yUp = snakeHead.getY() - 1;
        if (yUp < CELL_MIN_ID && levelService.getCurrentLevel().isTransparentWall()) {
            yUp = CELL_MAX_ID;
        }

        if (yUp < CELL_MIN_ID || cageService.getCage().cells[yUp][snakeHead.getX()].getCellType().isNotActionable() || levelService.getCurrentLevel().getMovesLeft() == 0) {
            upButton.setClickable(false);
        }


        int yBottom = snakeHead.getY() + 1;
        if (yBottom > CELL_MAX_ID && levelService.getCurrentLevel().isTransparentWall()) {
            yBottom = CELL_MIN_ID;
        }

        if (yBottom > CELL_MAX_ID || cageService.getCage().cells[yBottom][snakeHead.getX()].getCellType().isNotActionable() || levelService.getCurrentLevel().getMovesLeft() == 0) {
            downButton.setClickable(false);
        }


        int xLeft = snakeHead.getX() - 1;
        if (xLeft < CELL_MIN_ID && levelService.getCurrentLevel().isTransparentWall()) {
            xLeft = CELL_MAX_ID;
        }

        if (xLeft < CELL_MIN_ID || cageService.getCage().cells[snakeHead.getY()][xLeft].getCellType().isNotActionable() || levelService.getCurrentLevel().getMovesLeft() == 0) {
            leftButton.setClickable(false);
        }


        int xRight = snakeHead.getX() + 1;
        if (xRight > CELL_MAX_ID && levelService.getCurrentLevel().isTransparentWall()) {
            xRight = CELL_MIN_ID;
        }

        if (xRight > CELL_MAX_ID || cageService.getCage().cells[snakeHead.getY()][xRight].getCellType().isNotActionable() || levelService.getCurrentLevel().getMovesLeft() == 0) {
            rightButton.setClickable(false);
        }

        if (upButton.isClickable() || downButton.isClickable() || leftButton.isClickable() || rightButton.isClickable()) {
            gameOver.setVisibility(View.INVISIBLE);
        } else {
            gameOver.setVisibility(View.VISIBLE);
        }
    }
}
