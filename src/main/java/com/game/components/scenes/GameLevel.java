package com.game.components.scenes;

import com.game.Game;
import com.github.hanyaeger.api.scenes.DynamicScene;

public class GameLevel extends DynamicScene {
  private Game game;

  public GameLevel(Game game){
    this.game = game;
  }

  @Override
  public void setupScene() {
      setBackgroundImage("backgrounds/background.png");
  }

  @Override
  public void setupEntities() {

  }
}
