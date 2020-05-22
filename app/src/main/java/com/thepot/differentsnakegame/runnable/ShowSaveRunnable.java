package com.thepot.differentsnakegame.runnable;

import com.thepot.differentsnakegame.clicklistener.gamebuttons.LoadSaveOCL;

public class ShowSaveRunnable implements Runnable {
    private LoadSaveOCL loadSaveOCL;

    public ShowSaveRunnable(LoadSaveOCL loadSaveOCL) {
        this.loadSaveOCL = loadSaveOCL;
    }

    @Override
    public void run() {
        loadSaveOCL.clickableLoadSaveButton(true);
    }
}
