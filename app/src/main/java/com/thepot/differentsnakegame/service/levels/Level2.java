package com.thepot.differentsnakegame.service.levels;

import com.thepot.differentsnakegame.service.LevelService;

import static com.thepot.differentsnakegame.model.CellType.FOOD_MOVE_TO_NEXT_LEVEL;
import static com.thepot.differentsnakegame.model.CellType.SAVE;

public class Level2 implements Level {
    private LevelService levelService;

    public Level2(LevelService levelService) {
        this.levelService = levelService;
    }

    @Override
    public void loadLevel() {
        levelService.updateMoveCount(12);
        levelService.addLevelCell(1, 1, FOOD_MOVE_TO_NEXT_LEVEL);
        levelService.addLevelCell(3, 4, SAVE);
    }

    @Override
    public double levelNumber() {
        return 2;
    }

    @Override
    public double nextLevelNumber() {
        return 3;
    }
}
