package com.thepot.differentsnakegame.service.levels;

import com.thepot.differentsnakegame.service.LevelService;

import static com.thepot.differentsnakegame.model.CellType.FOOD_MOVE_TO_NEXT_LEVEL;

public class Level11 implements Level {
    private LevelService levelService;

    public Level11(LevelService levelService) {
        this.levelService = levelService;
    }


    @Override
    public void loadLevel() {
        levelService.makeWallTransparent(true);
        levelService.updateMoveCount(4);
        levelService.addLevelCell(14, 0, FOOD_MOVE_TO_NEXT_LEVEL);
    }

    @Override
    public double levelNumber() {
        return 11;
    }

    @Override
    public double nextLevelNumber() {
        return 12;
    }
}
