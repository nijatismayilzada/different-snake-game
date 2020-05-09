package com.thepot.differentsnakegame.model;

public class CurrentLevel {
    private double currentLevel;
    private int movesLeft;
    private boolean transparentWall;
    private int saveId;

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

    public boolean isTransparentWall() {
        return transparentWall;
    }

    public void setTransparentWall(boolean transparentWall) {
        this.transparentWall = transparentWall;
    }

    public int getSaveId() {
        return saveId;
    }

    public void setSaveId(int saveId) {
        this.saveId = saveId;
    }
}
