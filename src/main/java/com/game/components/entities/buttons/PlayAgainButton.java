package com.game.components.entities.buttons;

import com.game.Game;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;

public class PlayAgainButton extends Button {
  private final Game game;

  public PlayAgainButton(Coordinate2D initialLocation, Game game) {
    super(initialLocation, "Play Again");
    this.game = game;
  }

  @Override
  public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
    game.setActiveScene(1);
  }
}
