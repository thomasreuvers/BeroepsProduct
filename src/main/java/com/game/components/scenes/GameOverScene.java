package com.game.components.scenes;

import com.game.Game;
import com.github.hanyaeger.api.scenes.DynamicScene;

public class GameOverScene extends DynamicScene {
  private final Game game;
  public GameOverScene(Game game) {
    this.game = game;
  }

  @Override
  public void setupScene() {
    setBackgroundImage("backgrounds/game-bg.png");
  }

  @Override
  public void setupEntities() {

  }
}
