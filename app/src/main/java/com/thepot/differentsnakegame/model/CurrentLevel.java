package com.thepot.differentsnakegame.model;

public class CurrentLevel {
    private int currentLevel;
    private int movesLeft;

    public CurrentLevel() {
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getMovesLeft() {
        return movesLeft;
    }

    public void setMovesLeft(int movesLeft) {
        this.movesLeft = movesLeft;
    }
}
