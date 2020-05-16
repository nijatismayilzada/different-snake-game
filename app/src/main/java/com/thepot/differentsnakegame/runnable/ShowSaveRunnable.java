package com.thepot.differentsnakegame.runnable;

import com.thepot.differentsnakegame.service.ButtonService;

public class ShowSaveRunnable implements Runnable {
    private ButtonService buttonService;

    public ShowSaveRunnable(ButtonService buttonService) {
        this.buttonService = buttonService;
    }

    @Override
    public void run() {
        buttonService.showLoadSaveButton(true);
    }
}
