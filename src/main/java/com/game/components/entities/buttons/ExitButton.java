package com.game.components.entities.buttons;

import com.game.Game;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;

public class ExitButton extends Button {
    private final Game game;

    public ExitButton(Coordinate2D initialLocation, Game game) {
        super(initialLocation,"Quit Game");
        this.game = game;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        game.quit();
    }
}
