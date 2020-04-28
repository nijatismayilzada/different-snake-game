package com.thepot.differentsnakegame.service.levels;

import com.thepot.differentsnakegame.service.LevelService;

import static com.thepot.differentsnakegame.model.CellType.FOOD_MOVE_TO_NEXT_LEVEL;
import static com.thepot.differentsnakegame.model.CellType.WALL;

public class Level10 implements Level {
    private LevelService levelService;

    public Level10(LevelService levelService) {
        this.levelService = levelService;
    }

    @Override
    public void loadLevel() {
        levelService.makeWallTransparent(true);
        levelService.updateMoveCount(3);
        levelService.addLevelCell(1, 13, FOOD_MOVE_TO_NEXT_LEVEL);
        levelService.addLevelCell(0, 11, WALL);
        levelService.addLevelCell(1, 11, WALL);
        levelService.addLevelCell(2, 11, WALL);
        levelService.addLevelCell(3, 11, WALL);
        levelService.addLevelCell(3, 12, WALL);
        levelService.addLevelCell(3, 13, WALL);
        levelService.addLevelCell(3, 14, WALL);

    }

    @Override
    public double levelNumber() {
        return 10;
    }

    @Override
    public double nextLevelNumber() {
        return 11;
    }
}
