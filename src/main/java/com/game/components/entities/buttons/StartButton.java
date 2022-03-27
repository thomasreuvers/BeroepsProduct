package com.game.components.entities.buttons;

import com.game.Game;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;

public class StartButton extends Button {
  private final Game game;

  public StartButton(Coordinate2D initialLocation, Game game) {
    super(initialLocation,"Play game");
    this.game = game;
  }

  @Override
  public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
      game.setActiveScene(1);
  }
}
