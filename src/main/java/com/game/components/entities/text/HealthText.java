package com.game.components.entities.text;

import com.game.components.helpers.GameConstants;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class HealthText extends Text {

    private double health = 3.0;

    public HealthText() {
        super(new Coordinate2D(0, 10));
        setFill(Color.RED);
        setText(GameConstants.HEALTH_TXT + health);
    }

    /**
     * Decrease the health by the given decreaser
     * @param decreaser amount to decrease the score with
     */
    public void decreaseHealth(double decreaser) {
        health -= decreaser;
    }

    /**
     * Show the current score
     */
    public void showHealth() {
        setText(GameConstants.HEALTH_TXT + health);
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getHealth(){
        return this.health;
    }
}
