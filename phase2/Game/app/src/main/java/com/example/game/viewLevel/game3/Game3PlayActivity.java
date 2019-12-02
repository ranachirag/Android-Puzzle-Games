package com.example.game.viewLevel.game3;

import android.content.Intent;
import android.os.Bundle;

import com.example.game.BaseActivity;
import com.example.game.GameOver;

/**
 * Play Activity for Game 3.
 */
public class Game3PlayActivity extends BaseActivity {

    /**
     * Game Loop for this Game.
     */
    private Game3View game3View;

    /**
     * Code to execute when the Activity is created.
     *
     * @param savedInstanceState A Bundle containing possibly previous states of this Activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Creates view for Game 3.
        super.onCreate(savedInstanceState);
        String difficulty = getIntent().getStringExtra("DIFFICULTY");
        game3View = new Game3View(this, difficulty);
        setContentView(game3View);

        //Customizes the Activity based on User preference.
        getWindow().getDecorView().setBackgroundResource(account.getBackground());
    }

    /**
     * Handles cases when Activity is paused.
     */
    @Override
    protected void onPause() {
        super.onPause();
        game3View.pause();
    }

    /**
     * Handles cases when Activity is resumed.
     */
    @Override
    protected void onResume() {
        super.onResume();
        game3View.resume();
    }

    /**
     * Handles the case when the game is done.
     *
     * @param winner    The winner of the game.
     * @param numMoves  The number of moves the Player played.
     * @param gameEnded Whether the game has ended or not.
     */
    protected void gameOver(String winner, int numMoves, boolean gameEnded) {
        Intent intent = new Intent(this, Game3ExitActivity.class);
        intent.putExtra("EXTRA_WINNER", winner);
        intent.putExtra("EXTRA_MOVES", numMoves);

        if (gameEnded) {
            //Ran out of lives
            intent = new Intent(this, GameOver.class);
        }
        startActivity(intent);
    }

    /**
     * Handles cases when Activity is stopped.
     */
    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
