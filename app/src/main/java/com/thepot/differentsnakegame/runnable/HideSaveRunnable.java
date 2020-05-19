package com.thepot.differentsnakegame.runnable;

import com.thepot.differentsnakegame.service.ButtonService;

public class HideSaveRunnable implements Runnable {
    private ButtonService buttonService;

    public HideSaveRunnable(ButtonService buttonService) {
        this.buttonService = buttonService;
    }

    @Override
    public void run() {
        buttonService.clickableLoadSaveButton(false);
    }
}
