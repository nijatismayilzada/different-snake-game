package com.thepot.differentsnakegame.service.levels;

import com.thepot.differentsnakegame.service.LevelService;

import static com.thepot.differentsnakegame.model.CellType.FOOD_MOVE_TO_NEXT_LEVEL;
import static com.thepot.differentsnakegame.model.CellType.OBSTACLE;
import static com.thepot.differentsnakegame.model.CellType.WALL;

public class Level15 implements Level {
    private LevelService levelService;

    public Level15(LevelService levelService) {
        this.levelService = levelService;
    }

    @Override
    public void loadLevel() {
        levelService.makeWallTransparent(true);
        levelService.updateMoveCount(999);

        levelService.addLevelCell(7, 7, FOOD_MOVE_TO_NEXT_LEVEL);
        levelService.addLevelCell(5, 5, WALL);
        levelService.addLevelCell(5, 6, WALL);
        levelService.addLevelCell(5, 7, WALL);
        levelService.addLevelCell(5, 8, WALL);
        levelService.addLevelCell(5, 9, WALL);
        levelService.addLevelCell(6, 9, OBSTACLE);
        levelService.addLevelCell(7, 9, WALL);
        levelService.addLevelCell(8, 9, WALL);
        levelService.addLevelCell(9, 9, WALL);
        levelService.addLevelCell(9, 8, WALL);
        levelService.addLevelCell(9, 7, WALL);
        levelService.addLevelCell(9, 6, WALL);
        levelService.addLevelCell(9, 5, WALL);
        levelService.addLevelCell(8, 5, WALL);
        levelService.addLevelCell(7, 5, WALL);
        levelService.addLevelCell(6, 5, WALL);
    }

    @Override
    public double levelNumber() {
        return 15;
    }

    @Override
    public double nextLevelNumber() {
        return 16;
    }
}
