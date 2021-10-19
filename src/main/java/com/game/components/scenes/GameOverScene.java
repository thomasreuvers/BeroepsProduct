package com.game.components.scenes;

import com.game.Game;
import com.game.components.entities.buttons.ExitButton;
import com.game.components.entities.buttons.PlayAgainButton;
import com.game.components.entities.text.ScoreText;
import com.game.components.helpers.GameConstants;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOverScene extends DynamicScene {
  private final Game game;
  private final ScoreText scoreText;

  public GameOverScene(Game game, ScoreText scoreText) {
    this.game = game;
    this.scoreText = scoreText;
  }

  @Override
  public void setupScene() {
    setBackgroundImage("backgrounds/game-bg.png");
  }

  @Override
  public void setupEntities() {
    addEntity(setupText());

    addEntity(new PlayAgainButton(new Coordinate2D(320, 350), game));

    addEntity(new ExitButton(new Coordinate2D(640,0), game));
  }

  private TextEntity setupText() {
    var x = new TextEntity(new Coordinate2D(getWidth() / 2 , getHeight() / 2), GameConstants.GAME_OVER_TXT);
    x.setAnchorPoint(AnchorPoint.CENTER_CENTER);
    x.setFill(Color.GREEN);
    x.setFont(Font.font("Roboto", FontWeight.EXTRA_BOLD, 80));
    return x;
  }
}
