package com.thepot.differentsnakegame.model;

import com.thepot.differentsnakegame.R;

public enum CellType {
    EMPTY(0, true),
    SNAKE_HEAD_UP(R.drawable.ic_backspace_24px_up, false),
    SNAKE_HEAD_DOWN(R.drawable.ic_backspace_24px_down, false),
    SNAKE_HEAD_LEFT(R.drawable.ic_backspace_24px_left, false),
    SNAKE_HEAD_RIGHT(R.drawable.ic_backspace_24px_right, false),
    SNAKE_BODY(R.drawable.ic_add_box_24px, false),
    FOOD(R.drawable.ic_add_circle_24px, true),
    WALL(R.drawable.ic_wall_24px, false);


    private int resource;
    private boolean actionable;


    CellType(int resource, boolean actionable) {
        this.resource = resource;
        this.actionable = actionable;
    }

    public int getResource() {
        return resource;
    }

    public boolean isActionable() {
        return actionable;
    }

    public boolean isNotActionable() {
        return !actionable;
    }
}
