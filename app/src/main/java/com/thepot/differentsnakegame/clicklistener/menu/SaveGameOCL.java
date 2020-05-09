package com.thepot.differentsnakegame.clicklistener.menu;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.R;
import com.thepot.differentsnakegame.repository.LevelRepository;

import static com.thepot.differentsnakegame.repository.CellRepository.SAVE_ID_1;

public class SaveGameOCL implements View.OnClickListener {
    private AppCompatActivity activity;
    private LevelRepository levelRepository;
    private View saveButton;

    public SaveGameOCL(AppCompatActivity activity, LevelRepository levelRepository) {
        this.activity = activity;
        this.levelRepository = levelRepository;
        this.saveButton = this.activity.findViewById(R.id.loadSave);
        setupButton();
    }

    @Override
    public void onClick(View v) {

    }

    public void setupButton() {
        saveButton.setVisibility(View.VISIBLE);

        if (levelRepository.getCurrentLevelDetails(SAVE_ID_1) == null) {
            saveButton.setVisibility(View.GONE);
        }
    }
}
