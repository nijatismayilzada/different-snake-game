package com.thepot.differentsnakegame.service.levels;

import com.thepot.differentsnakegame.service.LevelService;

import static com.thepot.differentsnakegame.model.CellType.FOOD_MOVE_TO_NEXT_LEVEL;

public class Level1 implements Level {

    private LevelService levelService;

    public Level1(LevelService levelService) {
        this.levelService = levelService;
    }

    @Override
    public void loadLevel() {
        levelService.updateMoveCount(3);
        levelService.addLevelCell(7, 7, FOOD_MOVE_TO_NEXT_LEVEL);
    }

    @Override
    public double levelNumber() {
        return 1;
    }

    @Override
    public double nextLevelNumber() {
        return 2;
    }
}
