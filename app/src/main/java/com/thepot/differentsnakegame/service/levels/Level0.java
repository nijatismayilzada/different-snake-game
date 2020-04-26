package com.thepot.differentsnakegame.service.levels;

public class Level0 implements Level {

    @Override
    public void loadLevel() {
        // game initialise
    }

    @Override
    public double levelNumber() {
        return 0;
    }

    @Override
    public double nextLevelNumber() {
        return 1;
    }
}
