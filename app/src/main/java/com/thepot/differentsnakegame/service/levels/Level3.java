package com.thepot.differentsnakegame.service.levels;

import com.thepot.differentsnakegame.service.LevelService;

import static com.thepot.differentsnakegame.model.CellType.FOOD_MOVE_TO_NEXT_LEVEL;
import static com.thepot.differentsnakegame.model.CellType.WALL;

public class Level3 implements Level {
    private LevelService levelService;

    public Level3(LevelService levelService) {
        this.levelService = levelService;
    }

    @Override
    public void loadLevel() {
        levelService.updateMoveCount(12);
        levelService.addLevelCell(3, 9, FOOD_MOVE_TO_NEXT_LEVEL);
        levelService.addLevelCell(1, 7, WALL);
        levelService.addLevelCell(1, 8, WALL);
        levelService.addLevelCell(2, 6, WALL);
        levelService.addLevelCell(2, 7, WALL);
        levelService.addLevelCell(3, 6, WALL);
    }

    @Override
    public double levelNumber() {
        return 3;
    }

    @Override
    public double nextLevelNumber() {
        return 4;
    }
}
