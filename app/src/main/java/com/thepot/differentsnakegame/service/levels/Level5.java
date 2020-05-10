package com.thepot.differentsnakegame.service.levels;

import com.thepot.differentsnakegame.service.LevelService;

import static com.thepot.differentsnakegame.model.CellType.FOOD;
import static com.thepot.differentsnakegame.model.CellType.SAVE;
import static com.thepot.differentsnakegame.model.CellType.WALL;

public class Level5 implements Level {
    private LevelService levelService;

    public Level5(LevelService levelService) {
        this.levelService = levelService;
    }

    @Override
    public void loadLevel() {
        levelService.updateMoveCount(16);
        levelService.addLevelCell(10, 4, FOOD);
        levelService.addLevelCell(12, 3, FOOD);
        levelService.addLevelCell(14, 3, FOOD);
        levelService.addLevelCell(12, 7, SAVE);
        levelService.addLevelCell(11, 3, WALL);
        levelService.addLevelCell(11, 4, WALL);
        levelService.addLevelCell(13, 3, WALL);
        levelService.addLevelCell(13, 4, WALL);
    }

    @Override
    public double levelNumber() {
        return 5;
    }

    @Override
    public double nextLevelNumber() {
        return 6;
    }
}
