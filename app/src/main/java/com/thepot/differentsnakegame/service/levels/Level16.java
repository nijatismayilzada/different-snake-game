package com.thepot.differentsnakegame.service.levels;

import com.thepot.differentsnakegame.service.LevelService;

import static com.thepot.differentsnakegame.model.CellType.FOOD;
import static com.thepot.differentsnakegame.model.CellType.OBSTACLE;
import static com.thepot.differentsnakegame.model.CellType.WALL;

public class Level16 implements Level {
    private LevelService levelService;

    public Level16(LevelService levelService) {
        this.levelService = levelService;
    }

    @Override
    public void loadLevel() {
        levelService.makeWallTransparent(true);
        levelService.updateMoveCount(-1);


        levelService.addLevelCell(1, 2, OBSTACLE);
        levelService.addLevelCell(1, 3, OBSTACLE);
        levelService.addLevelCell(2, 1, OBSTACLE);
        levelService.addLevelCell(3, 1, OBSTACLE);

        levelService.addLevelCell(1, 11, OBSTACLE);
        levelService.addLevelCell(1, 12, OBSTACLE);
        levelService.addLevelCell(2, 13, OBSTACLE);
        levelService.addLevelCell(3, 13, OBSTACLE);

        levelService.addLevelCell(11, 1, OBSTACLE);
        levelService.addLevelCell(12, 1, OBSTACLE);
        levelService.addLevelCell(13, 2, OBSTACLE);
        levelService.addLevelCell(13, 3, OBSTACLE);

        levelService.addLevelCell(13, 11, OBSTACLE);
        levelService.addLevelCell(13, 12, OBSTACLE);
        levelService.addLevelCell(11, 13, OBSTACLE);
        levelService.addLevelCell(12, 13, OBSTACLE);


        levelService.addLevelCell(3, 3, FOOD);
        levelService.addLevelCell(3, 11, FOOD);
        levelService.addLevelCell(11, 3, FOOD);
        levelService.addLevelCell(11, 11, FOOD);


        levelService.addLevelCell(0, 4, WALL);
        levelService.addLevelCell(1, 4, WALL);
        levelService.addLevelCell(2, 4, WALL);
        levelService.addLevelCell(3, 4, WALL);
        levelService.addLevelCell(4, 4, WALL);
        levelService.addLevelCell(4, 3, WALL);
        levelService.addLevelCell(4, 2, WALL);
        levelService.addLevelCell(4, 1, WALL);
        levelService.addLevelCell(4, 0, WALL);


        levelService.addLevelCell(0, 10, WALL);
        levelService.addLevelCell(1, 10, WALL);
        levelService.addLevelCell(2, 10, WALL);
        levelService.addLevelCell(3, 10, WALL);
        levelService.addLevelCell(4, 10, WALL);
        levelService.addLevelCell(4, 11, WALL);
        levelService.addLevelCell(4, 12, WALL);
        levelService.addLevelCell(4, 13, WALL);
        levelService.addLevelCell(4, 14, WALL);


        levelService.addLevelCell(10, 0, WALL);
        levelService.addLevelCell(10, 1, WALL);
        levelService.addLevelCell(10, 2, WALL);
        levelService.addLevelCell(10, 3, WALL);
        levelService.addLevelCell(10, 4, WALL);
        levelService.addLevelCell(11, 4, WALL);
        levelService.addLevelCell(12, 4, WALL);
        levelService.addLevelCell(13, 4, WALL);
        levelService.addLevelCell(14, 4, OBSTACLE);


        levelService.addLevelCell(10, 14, WALL);
        levelService.addLevelCell(10, 13, WALL);
        levelService.addLevelCell(10, 12, WALL);
        levelService.addLevelCell(10, 11, WALL);
        levelService.addLevelCell(10, 10, WALL);
        levelService.addLevelCell(11, 10, WALL);
        levelService.addLevelCell(12, 10, WALL);
        levelService.addLevelCell(13, 10, WALL);
        levelService.addLevelCell(14, 10, WALL);

    }

    @Override
    public double levelNumber() {
        return 16;
    }

    @Override
    public double nextLevelNumber() {
        return 17;
    }
}
