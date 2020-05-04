package com.thepot.differentsnakegame.service.levels;

import com.thepot.differentsnakegame.service.LevelService;

import static com.thepot.differentsnakegame.model.CellType.FLARE;
import static com.thepot.differentsnakegame.model.CellType.FOOD;
import static com.thepot.differentsnakegame.model.CellType.OBSTACLE;
import static com.thepot.differentsnakegame.model.CellType.WALL;

public class Level17 implements Level {
    private LevelService levelService;

    public Level17(LevelService levelService) {
        this.levelService = levelService;
    }

    @Override
    public void loadLevel() {
        levelService.makeWallTransparent(true);
        levelService.updateMoveCount(999);

        levelService.addLevelCell(2, 7, WALL);
        levelService.addLevelCell(3, 6, WALL);
        levelService.addLevelCell(4, 5, WALL);
        levelService.addLevelCell(5, 4, WALL);
        levelService.addLevelCell(6, 3, WALL);
        levelService.addLevelCell(7, 2, WALL);
        levelService.addLevelCell(8, 3, WALL);
        levelService.addLevelCell(9, 4, WALL);
        levelService.addLevelCell(10, 5, WALL);
        levelService.addLevelCell(11, 6, WALL);
        levelService.addLevelCell(12, 7, OBSTACLE);
        levelService.addLevelCell(11, 8, OBSTACLE);
        levelService.addLevelCell(10, 9, WALL);
        levelService.addLevelCell(9, 10, WALL);
        levelService.addLevelCell(8, 11, WALL);
        levelService.addLevelCell(7, 12, WALL);
        levelService.addLevelCell(6, 11, WALL);
        levelService.addLevelCell(5, 10, WALL);
        levelService.addLevelCell(4, 9, WALL);
        levelService.addLevelCell(3, 8, WALL);


        levelService.addLevelCell(4, 7, OBSTACLE);
        levelService.addLevelCell(5, 6, OBSTACLE);
        levelService.addLevelCell(6, 5, OBSTACLE);
        levelService.addLevelCell(7, 4, OBSTACLE);
        levelService.addLevelCell(8, 5, OBSTACLE);
        levelService.addLevelCell(9, 6, OBSTACLE);
        levelService.addLevelCell(9, 8, OBSTACLE);
        levelService.addLevelCell(8, 9, OBSTACLE);
        levelService.addLevelCell(7, 10, OBSTACLE);
        levelService.addLevelCell(6, 9, OBSTACLE);
        levelService.addLevelCell(5, 8, OBSTACLE);
        levelService.addLevelCell(6, 7, OBSTACLE);
        levelService.addLevelCell(7, 6, OBSTACLE);
        levelService.addLevelCell(8, 7, OBSTACLE);
        levelService.addLevelCell(7, 8, OBSTACLE);


        levelService.addLevelCell(5, 7, FOOD);
        levelService.addLevelCell(6, 6, FOOD);
        levelService.addLevelCell(7, 5, FOOD);
        levelService.addLevelCell(8, 6, FOOD);
        levelService.addLevelCell(9, 7, FOOD);
        levelService.addLevelCell(8, 8, FOOD);
        levelService.addLevelCell(7, 9, FOOD);
        levelService.addLevelCell(6, 8, FOOD);
        levelService.addLevelCell(7, 7, FLARE);

    }

    @Override
    public double levelNumber() {
        return 17;
    }

    @Override
    public double nextLevelNumber() {
        return 18.1;
    }
}
