package com.thepot.differentsnakegame.runnable;

import com.thepot.differentsnakegame.clicklistener.gamebuttons.LoadSaveOCL;

public class HideSaveRunnable implements Runnable {
    private LoadSaveOCL loadSaveOCL;

    public HideSaveRunnable(LoadSaveOCL loadSaveOCL) {
        this.loadSaveOCL = loadSaveOCL;
    }

    @Override
    public void run() {
        loadSaveOCL.clickableLoadSaveButton(false);
    }
}
