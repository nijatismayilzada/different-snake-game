package com.thepot.differentsnakegame.service.levels;

import com.thepot.differentsnakegame.service.LevelService;

import static com.thepot.differentsnakegame.service.LevelService.END_GAME;

public class LevelRandom implements Level {
    private LevelService levelService;

    public LevelRandom(LevelService levelService) {
        this.levelService = levelService;
    }

    @Override
    public void loadLevel() {
        levelService.loadRandomFood();
    }

    @Override
    public double levelNumber() {
        return END_GAME;
    }

    @Override
    public double nextLevelNumber() {
        return END_GAME;
    }
}
