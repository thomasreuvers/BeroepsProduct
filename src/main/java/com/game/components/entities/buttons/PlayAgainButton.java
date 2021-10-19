package com.game.components.entities.buttons;

import com.game.Game;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PlayAgainButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
  private final Game game;

  public PlayAgainButton(Coordinate2D initialLocation, Game game) {
    super(initialLocation, "Play Again");
    setFill(Color.PALEGREEN);
    setFont(Font.font("Roboto", FontWeight.BOLD, 30));

    this.game = game;
  }

  @Override
  public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
    game.setActiveScene(1);
  }

  @Override
  public void onMouseEntered() {
    setFill(Color.GREENYELLOW);
    setCursor(Cursor.HAND);
  }

  @Override
  public void onMouseExited() {
    setFill(Color.PALEGREEN);
    setCursor(Cursor.DEFAULT);
  }
}
