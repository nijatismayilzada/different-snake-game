package com.thepot.differentsnakegame.model;

public class CurrentLevel {
    private double currentLevel;
    private int movesLeft;

    public CurrentLevel() {
    }

    public double getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(double currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getMovesLeft() {
        return movesLeft;
    }

    public void setMovesLeft(int movesLeft) {
        this.movesLeft = movesLeft;
    }
}
