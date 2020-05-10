package com.thepot.differentsnakegame.service.levels;

import com.thepot.differentsnakegame.service.LevelService;

import static com.thepot.differentsnakegame.model.CellType.FOOD_MOVE_TO_NEXT_LEVEL;
import static com.thepot.differentsnakegame.model.CellType.SAVE;
import static com.thepot.differentsnakegame.model.CellType.WALL;

public class Level4 implements Level {
    private LevelService levelService;

    public Level4(LevelService levelService) {
        this.levelService = levelService;
    }

    @Override
    public void loadLevel() {
        levelService.updateMoveCount(12);
        levelService.addLevelCell(11, 7, FOOD_MOVE_TO_NEXT_LEVEL);
        levelService.addLevelCell(8, 10, SAVE);
        levelService.addLevelCell(9, 7, WALL);
        levelService.addLevelCell(10, 8, WALL);
        levelService.addLevelCell(11, 9, WALL);
    }

    @Override
    public double levelNumber() {
        return 4;
    }

    @Override
    public double nextLevelNumber() {
        return 5;
    }
}
