package com.game.components.entities.text;

import com.game.components.helpers.GameConstants;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class ScoreText extends Text {

    private int score = 0;

    public ScoreText() {
        super(new Coordinate2D(0, 0));
        setFill(Color.WHITE);
        setText(GameConstants.SCORE_TXT + score);
    }

    /**
     * Increment the score by the given incrementer
     * @param incrementer amount to increment the score with
     */
    public void incrementScore(int incrementer) {
        score += incrementer;
    }

    /**
     * Show the current score
     */
    public void showScore () {
        setText(GameConstants.SCORE_TXT + score);
    }

    public void setScore(int score) {
        this.score = score;
    }
}
