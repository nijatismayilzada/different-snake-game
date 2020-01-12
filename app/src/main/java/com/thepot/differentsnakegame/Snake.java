package com.thepot.differentsnakegame;

import android.graphics.Rect;

import java.util.ArrayList;

public class Snake {
    private int maxSnakeSize;
    private ArrayList<Rect> rects;
    private SnakeHeadDirection snakeHeadDirection;

    public Snake(int maxSnakeSize, int w, int h) {
        this.maxSnakeSize = maxSnakeSize;
        rects = new ArrayList<>(maxSnakeSize);

        Rect rect = new Rect();
        rect.set(w / 2 - 100, h / 2 - 100, w / 2 + 100, h / 2 + 100);
        rects.add(rect);

        snakeHeadDirection = SnakeHeadDirection.RIGHT;

    }

    public Rect getHead(){
        return rects.get(rects.size()-1);
    }

    public Rect getHeadToMove(){
        Rect rect = new Rect(getHead());
        addRect(rect);
        return rect;

    }


    public ArrayList<Rect> getRects() {
        return rects;
    }

    public void addRect(Rect rect){
        rects.add(rect);
        if(rects.size() > maxSnakeSize){
            rects.remove(0);
        }
    }

    public SnakeHeadDirection getSnakeHeadDirection() {
        return snakeHeadDirection;
    }

    public void setSnakeHeadDirection(SnakeHeadDirection snakeHeadDirection) {
        this.snakeHeadDirection = snakeHeadDirection;
    }
}
