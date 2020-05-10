package com.thepot.differentsnakegame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.clicklistener.AdsOICL;
import com.thepot.differentsnakegame.clicklistener.BoardHolderObserver;
import com.thepot.differentsnakegame.clicklistener.HideNavigationOTL;

import static com.thepot.differentsnakegame.clicklistener.menu.NewGameOCL.NEW_GAME;

public class GameActivity extends AppCompatActivity {

    private HideNavigationOTL hideNavigationOTL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        newGame();
    }

    private void newGame() {
        hideNavigationOTL = new HideNavigationOTL(this);
        findViewById(R.id.activity_game).setOnTouchListener(hideNavigationOTL);
        ImageView boardHolder = findViewById(R.id.boardHolder);
        boardHolder.getViewTreeObserver().addOnGlobalLayoutListener(new BoardHolderObserver(GameActivity.this, boardHolder));
    }

    @Override
    public void onBackPressed() {
        Intent mainIntent = new Intent(this, MainActivity.class);
        mainIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(mainIntent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        hideNavigationOTL.hideSystemUI();
        super.onNewIntent(intent);
        overridePendingTransition(0, 0);

        if (intent.getBooleanExtra(NEW_GAME, false)) {
            newGame();
        }

    }
}
