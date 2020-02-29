package com.thepot.differentsnakegame.model;

import com.thepot.differentsnakegame.R;

public enum CellType {
    EMPTY(0),
    SNAKE_HEAD_UP(R.drawable.ic_backspace_24px_up),
    SNAKE_HEAD_DOWN(R.drawable.ic_backspace_24px_down),
    SNAKE_HEAD_LEFT(R.drawable.ic_backspace_24px_left),
    SNAKE_HEAD_RIGHT(R.drawable.ic_backspace_24px_right),
    SNAKE_BODY(R.drawable.ic_add_box_24px);


    private int resource;

    CellType(int resource) {
        this.resource = resource;
    }

    public int getResource() {
        return resource;
    }
}
