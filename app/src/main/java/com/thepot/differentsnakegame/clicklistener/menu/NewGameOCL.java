package com.thepot.differentsnakegame.clicklistener.menu;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.GameActivity;
import com.thepot.differentsnakegame.R;
import com.thepot.differentsnakegame.repository.CellRepository;
import com.thepot.differentsnakegame.repository.LevelRepository;

public class NewGameOCL implements View.OnClickListener {
    public static final String NEW_GAME = "NEW_GAME";
    private AppCompatActivity activity;
    private LevelRepository levelRepository;
    private CellRepository cellRepository;

    public NewGameOCL(AppCompatActivity activity, LevelRepository levelRepository, CellRepository cellRepository) {
        this.activity = activity;
        this.levelRepository = levelRepository;
        this.cellRepository = cellRepository;
        this.activity.findViewById(R.id.newGame).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        cellRepository.deleteAllCells();
        levelRepository.deleteLevelDetails();

        Intent intent = new Intent(activity, GameActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.putExtra(NEW_GAME, true);
        activity.startActivity(intent);
    }
}
