package com.thepot.differentsnakegame;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.clicklistener.BoardHolderObserver;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ImageView boardHolder = this.findViewById(R.id.boardHolder);
        boardHolder.getViewTreeObserver().addOnGlobalLayoutListener(new BoardHolderObserver(GameActivity.this, boardHolder));
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
