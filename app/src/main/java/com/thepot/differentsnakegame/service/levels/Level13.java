package com.thepot.differentsnakegame.service.levels;

import com.thepot.differentsnakegame.service.LevelService;

import static com.thepot.differentsnakegame.model.CellType.FOOD_MOVE_TO_NEXT_LEVEL;
import static com.thepot.differentsnakegame.model.CellType.WALL;

public class Level13 implements Level {
    private LevelService levelService;

    public Level13(LevelService levelService) {
        this.levelService = levelService;
    }

    @Override
    public void loadLevel() {
        levelService.makeWallTransparent(true);
        levelService.updateMoveCount(999);
        levelService.addLevelCell(13, 8, FOOD_MOVE_TO_NEXT_LEVEL);
        levelService.addLevelCell(14, 1, WALL);
        levelService.addLevelCell(13, 1, WALL);
        levelService.addLevelCell(12, 1, WALL);
        levelService.addLevelCell(11, 1, WALL);
        levelService.addLevelCell(10, 1, WALL);
        levelService.addLevelCell(10, 2, WALL);
        levelService.addLevelCell(10, 3, WALL);
        levelService.addLevelCell(10, 4, WALL);
        levelService.addLevelCell(10, 5, WALL);
        levelService.addLevelCell(10, 6, WALL);
        levelService.addLevelCell(10, 7, WALL);
        levelService.addLevelCell(10, 9, WALL);
        levelService.addLevelCell(10, 10, WALL);
        levelService.addLevelCell(10, 11, WALL);
        levelService.addLevelCell(10, 12, WALL);
        levelService.addLevelCell(10, 13, WALL);
        levelService.addLevelCell(14, 7, WALL);
        levelService.addLevelCell(13, 7, WALL);
        levelService.addLevelCell(12, 7, WALL);
        levelService.addLevelCell(11, 7, WALL);
        levelService.addLevelCell(11, 8, WALL);
        levelService.addLevelCell(12, 8, WALL);
        levelService.addLevelCell(14, 9, WALL);
        levelService.addLevelCell(13, 9, WALL);
        levelService.addLevelCell(12, 9, WALL);
        levelService.addLevelCell(11, 9, WALL);
        levelService.addLevelCell(11, 13, WALL);
        levelService.addLevelCell(12, 13, WALL);
        levelService.addLevelCell(13, 13, WALL);
        levelService.addLevelCell(14, 13, WALL);
        levelService.addLevelCell(0, 2, WALL);
        levelService.addLevelCell(1, 2, WALL);
        levelService.addLevelCell(2, 2, WALL);
        levelService.addLevelCell(3, 2, WALL);
        levelService.addLevelCell(4, 2, WALL);
        levelService.addLevelCell(5, 2, WALL);
        levelService.addLevelCell(5, 3, WALL);
        levelService.addLevelCell(5, 4, WALL);
        levelService.addLevelCell(5, 5, WALL);
        levelService.addLevelCell(5, 6, WALL);
        levelService.addLevelCell(5, 7, WALL);
        levelService.addLevelCell(5, 8, WALL);
        levelService.addLevelCell(5, 9, WALL);
        levelService.addLevelCell(5, 10, WALL);
        levelService.addLevelCell(5, 11, WALL);
        levelService.addLevelCell(4, 11, WALL);
        levelService.addLevelCell(3, 11, WALL);
        levelService.addLevelCell(2, 11, WALL);
        levelService.addLevelCell(1, 11, WALL);
        levelService.addLevelCell(0, 11, WALL);
        levelService.addLevelCell(0, 5, WALL);
        levelService.addLevelCell(1, 5, WALL);
        levelService.addLevelCell(2, 5, WALL);
        levelService.addLevelCell(3, 5, WALL);
        levelService.addLevelCell(3, 6, WALL);
        levelService.addLevelCell(3, 7, WALL);
        levelService.addLevelCell(3, 8, WALL);
        levelService.addLevelCell(3, 9, WALL);
        levelService.addLevelCell(2, 9, WALL);
        levelService.addLevelCell(1, 9, WALL);
        levelService.addLevelCell(0, 9, WALL);
    }

    @Override
    public double levelNumber() {
        return 13;
    }

    @Override
    public double nextLevelNumber() {
        return 14;
    }
}
