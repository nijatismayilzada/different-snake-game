package com.thepot.differentsnakegame.service.levels;

import com.thepot.differentsnakegame.service.LevelService;

import static com.thepot.differentsnakegame.model.CellType.FOOD_MOVE_TO_NEXT_LEVEL;
import static com.thepot.differentsnakegame.model.CellType.SAVE;

public class Level9_2 implements Level {
    private LevelService levelService;

    public Level9_2(LevelService levelService) {
        this.levelService = levelService;
    }

    @Override
    public void loadLevel() {
        levelService.makeWallTransparent(true);
        levelService.updateMoveCount(3);
        levelService.addLevelCell(13, 13, FOOD_MOVE_TO_NEXT_LEVEL);
        levelService.addLevelCell(13, 7, SAVE);
        levelService.addLevelCell(1, 1, SAVE);

    }

    @Override
    public double levelNumber() {
        return 9.2;
    }

    @Override
    public double nextLevelNumber() {
        return 10;
    }
}
