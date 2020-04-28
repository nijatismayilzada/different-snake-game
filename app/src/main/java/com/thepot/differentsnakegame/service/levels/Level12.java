package com.thepot.differentsnakegame.service.levels;

import com.thepot.differentsnakegame.service.LevelService;

import static com.thepot.differentsnakegame.model.CellType.FOOD;

public class Level12 implements Level {
    private LevelService levelService;

    public Level12(LevelService levelService) {
        this.levelService = levelService;
    }


    @Override
    public void loadLevel() {
        levelService.makeWallTransparent(true);
        levelService.updateMoveCount(24);
        levelService.addLevelCell(13, 14, FOOD);
        levelService.addLevelCell(12, 0, FOOD);
        levelService.addLevelCell(11, 14, FOOD);
        levelService.addLevelCell(10, 0, FOOD);
        levelService.addLevelCell(9, 14, FOOD);
        levelService.addLevelCell(8, 0, FOOD);
        levelService.addLevelCell(7, 14, FOOD);
        levelService.addLevelCell(6, 0, FOOD);
        levelService.addLevelCell(5, 14, FOOD);
        levelService.addLevelCell(4, 0, FOOD);
        levelService.addLevelCell(3, 14, FOOD);
        levelService.addLevelCell(2, 0, FOOD);
    }

    @Override
    public double levelNumber() {
        return 12;
    }

    @Override
    public double nextLevelNumber() {
        return 13;
    }
}
