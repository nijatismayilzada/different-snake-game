package com.thepot.differentsnakegame.service.levels;

import com.thepot.differentsnakegame.service.LevelService;

import static com.thepot.differentsnakegame.model.CellType.FOOD;
import static com.thepot.differentsnakegame.model.CellType.POISON;
import static com.thepot.differentsnakegame.model.CellType.WALL;

public class Level14 implements Level {

    private LevelService levelService;

    public Level14(LevelService levelService) {
        this.levelService = levelService;
    }

    @Override
    public void loadLevel() {

        levelService.makeWallTransparent(true);
        levelService.updateMoveCount(999);
        levelService.addLevelCell(6, 3, FOOD);
        levelService.addLevelCell(8, 12, FOOD);
        levelService.addLevelCell(10, 0, FOOD);
        levelService.addLevelCell(8, 2, POISON);
        levelService.addLevelCell(6, 11, POISON);
        levelService.addLevelCell(4, 0, WALL);
        levelService.addLevelCell(5, 1, WALL);
        levelService.addLevelCell(5, 2, WALL);
        levelService.addLevelCell(5, 3, WALL);
        levelService.addLevelCell(5, 4, WALL);
        levelService.addLevelCell(6, 4, WALL);
        levelService.addLevelCell(7, 4, WALL);
        levelService.addLevelCell(8, 4, WALL);
        levelService.addLevelCell(8, 3, WALL);
        levelService.addLevelCell(9, 3, WALL);
        levelService.addLevelCell(9, 2, WALL);
        levelService.addLevelCell(7, 1, WALL);
        levelService.addLevelCell(8, 1, WALL);
        levelService.addLevelCell(9, 1, WALL);
        levelService.addLevelCell(10, 1, WALL);
        levelService.addLevelCell(11, 1, WALL);
        levelService.addLevelCell(12, 1, WALL);
        levelService.addLevelCell(8, 0, WALL);
        levelService.addLevelCell(12, 0, WALL);


        levelService.addLevelCell(6, 14, WALL);
        levelService.addLevelCell(5, 13, WALL);
        levelService.addLevelCell(5, 12, WALL);
        levelService.addLevelCell(5, 11, WALL);
        levelService.addLevelCell(5, 10, WALL);
        levelService.addLevelCell(6, 10, WALL);
        levelService.addLevelCell(7, 10, WALL);
        levelService.addLevelCell(8, 10, WALL);
        levelService.addLevelCell(8, 11, WALL);
        levelService.addLevelCell(9, 11, WALL);
        levelService.addLevelCell(9, 12, WALL);
        levelService.addLevelCell(8, 13, WALL);
        levelService.addLevelCell(9, 13, WALL);
        levelService.addLevelCell(10, 13, WALL);
        levelService.addLevelCell(11, 13, WALL);
        levelService.addLevelCell(12, 13, WALL);
        levelService.addLevelCell(10, 14, WALL);

    }

    @Override
    public double levelNumber() {
        return 14;
    }

    @Override
    public double nextLevelNumber() {
        return 15;
    }
}
