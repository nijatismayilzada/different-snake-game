package com.thepot.differentsnakegame.service.levels;

import com.thepot.differentsnakegame.service.LevelService;

import static com.thepot.differentsnakegame.model.CellType.FOOD;
import static com.thepot.differentsnakegame.model.CellType.POISON;
import static com.thepot.differentsnakegame.model.CellType.WALL;

public class Level7 implements Level {
    private LevelService levelService;

    public Level7(LevelService levelService) {
        this.levelService = levelService;
    }

    @Override
    public void loadLevel() {
        levelService.updateMoveCount(999);
        levelService.addLevelCell(11, 3, FOOD);
        levelService.addLevelCell(11, 11, FOOD);
        levelService.addLevelCell(12, 7, POISON);
        levelService.addLevelCell(11, 1, WALL);
        levelService.addLevelCell(10, 1, WALL);
        levelService.addLevelCell(10, 2, WALL);
        levelService.addLevelCell(10, 3, WALL);
        levelService.addLevelCell(10, 4, WALL);
        levelService.addLevelCell(11, 4, WALL);
        levelService.addLevelCell(12, 4, WALL);
        levelService.addLevelCell(13, 4, WALL);
        levelService.addLevelCell(13, 3, WALL);
        levelService.addLevelCell(13, 2, WALL);
        levelService.addLevelCell(13, 1, WALL);
        levelService.addLevelCell(11, 13, WALL);
        levelService.addLevelCell(10, 13, WALL);
        levelService.addLevelCell(10, 12, WALL);
        levelService.addLevelCell(10, 11, WALL);
        levelService.addLevelCell(10, 10, WALL);
        levelService.addLevelCell(11, 10, WALL);
        levelService.addLevelCell(12, 10, WALL);
        levelService.addLevelCell(13, 10, WALL);
        levelService.addLevelCell(13, 11, WALL);
        levelService.addLevelCell(13, 12, WALL);
        levelService.addLevelCell(13, 13, WALL);
    }

    @Override
    public double levelNumber() {
        return 7;
    }

    @Override
    public double nextLevelNumber() {
        return 8;
    }
}
