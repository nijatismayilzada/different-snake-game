package com.thepot.differentsnakegame;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.clicklistener.HideNavigationOTL;
import com.thepot.differentsnakegame.clicklistener.menu.ContinueGameOCL;
import com.thepot.differentsnakegame.clicklistener.menu.ExitGameOCL;
import com.thepot.differentsnakegame.clicklistener.menu.StartGameOCL;

public class MainActivity extends AppCompatActivity {

    private HideNavigationOTL hideNavigationOTL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideNavigationOTL = new HideNavigationOTL(this);
        hideNavigationOTL.hideSystemUI();
        findViewById(R.id.activity_main).setOnTouchListener(hideNavigationOTL);
        findViewById(R.id.newGame).setOnClickListener(new StartGameOCL(this));
        findViewById(R.id.continueGame).setOnClickListener(new ContinueGameOCL(this));
        findViewById(R.id.exit).setOnClickListener(new ExitGameOCL(this));
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onNewIntent(Intent intent) {
        hideNavigationOTL.hideSystemUI();
        super.onNewIntent(intent);
        overridePendingTransition(0, 0);
    }
}
