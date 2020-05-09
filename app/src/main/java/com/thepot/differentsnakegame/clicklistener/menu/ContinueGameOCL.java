package com.thepot.differentsnakegame.clicklistener.menu;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.GameActivity;
import com.thepot.differentsnakegame.R;
import com.thepot.differentsnakegame.repository.LevelRepository;

import static com.thepot.differentsnakegame.repository.CellRepository.SAVE_ID_0;

public class ContinueGameOCL implements View.OnClickListener {
    private AppCompatActivity activity;
    private LevelRepository levelRepository;
    private View continueButton;

    public ContinueGameOCL(AppCompatActivity activity, LevelRepository levelRepository) {
        this.activity = activity;
        this.levelRepository = levelRepository;
        this.continueButton = this.activity.findViewById(R.id.continueGame);
        this.continueButton.setOnClickListener(this);
        setupButton();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(activity, GameActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        activity.startActivity(intent);
    }

    public void setupButton() {
        continueButton.setVisibility(View.VISIBLE);

        if (levelRepository.getCurrentLevelDetails(SAVE_ID_0) == null) {
            continueButton.setVisibility(View.GONE);
        }
    }
}
