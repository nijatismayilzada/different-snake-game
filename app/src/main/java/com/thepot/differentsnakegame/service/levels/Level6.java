package com.thepot.differentsnakegame.service.levels;

import com.thepot.differentsnakegame.service.LevelService;

import static com.thepot.differentsnakegame.model.CellType.FOOD;
import static com.thepot.differentsnakegame.model.CellType.WALL;

public class Level6 implements Level {
    private LevelService levelService;

    public Level6(LevelService levelService) {
        this.levelService = levelService;
    }

    @Override
    public void loadLevel() {
        levelService.updateMoveCount(999);
        levelService.addLevelCell(2, 3, FOOD);
        levelService.addLevelCell(2, 11, FOOD);
        levelService.addLevelCell(2, 1, WALL);
        levelService.addLevelCell(1, 1, WALL);
        levelService.addLevelCell(1, 2, WALL);
        levelService.addLevelCell(1, 3, WALL);
        levelService.addLevelCell(1, 4, WALL);
        levelService.addLevelCell(2, 4, WALL);
        levelService.addLevelCell(3, 4, WALL);
        levelService.addLevelCell(4, 4, WALL);
        levelService.addLevelCell(4, 3, WALL);
        levelService.addLevelCell(4, 2, WALL);
        levelService.addLevelCell(4, 1, WALL);
        levelService.addLevelCell(1, 13, WALL);
        levelService.addLevelCell(1, 12, WALL);
        levelService.addLevelCell(1, 11, WALL);
        levelService.addLevelCell(1, 10, WALL);
        levelService.addLevelCell(2, 10, WALL);
        levelService.addLevelCell(3, 10, WALL);
        levelService.addLevelCell(4, 10, WALL);
        levelService.addLevelCell(4, 11, WALL);
        levelService.addLevelCell(4, 12, WALL);
        levelService.addLevelCell(4, 13, WALL);
    }

    @Override
    public double levelNumber() {
        return 6;
    }

    @Override
    public double nextLevelNumber() {
        return 7;
    }
}
