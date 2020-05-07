package com.thepot.differentsnakegame;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.clicklistener.HideNavigationOTL;
import com.thepot.differentsnakegame.clicklistener.menu.ContinueGameOCL;
import com.thepot.differentsnakegame.clicklistener.menu.ExitGameOCL;
import com.thepot.differentsnakegame.clicklistener.menu.NewGameOCL;
import com.thepot.differentsnakegame.clicklistener.menu.SaveGameOCL;
import com.thepot.differentsnakegame.repository.CellRepository;
import com.thepot.differentsnakegame.repository.DatabaseDetails;
import com.thepot.differentsnakegame.repository.LevelRepository;

public class MainActivity extends AppCompatActivity {

    private HideNavigationOTL hideNavigationOTL;
    private ContinueGameOCL continueGameOCL;
    private SaveGameOCL saveGameOCL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseDetails databaseDetails = new DatabaseDetails(this);
        LevelRepository levelRepository = new LevelRepository(databaseDetails);
        CellRepository cellRepository = new CellRepository(databaseDetails);

        hideNavigationOTL = new HideNavigationOTL(this);
        new NewGameOCL(this, levelRepository, cellRepository);
        continueGameOCL = new ContinueGameOCL(this, levelRepository);
        saveGameOCL = new SaveGameOCL(this, levelRepository);
        new ExitGameOCL(this);
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onNewIntent(Intent intent) {
        hideNavigationOTL.hideSystemUI();
        continueGameOCL.setupButton();
        saveGameOCL.setupButton();
        super.onNewIntent(intent);
        overridePendingTransition(0, 0);
    }
}
