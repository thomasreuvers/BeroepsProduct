package com.game.components.scenes;

import com.game.Game;
import com.game.components.entities.Player;
import com.game.components.entities.text.ScoreText;
import com.game.components.spawners.PlatformSpawner;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;

public class GameScene extends DynamicScene implements EntitySpawnerContainer {
  private final Game game;
  public GameScene(Game game){
    this.game = game;
  }

  @Override
  public void setupScene() {
    setBackgroundImage("backgrounds/game-bg.png");
  }

  @Override
  public void setupEntities() {

    var scoreText = new ScoreText(new Coordinate2D(0,0));
    addEntity(scoreText);

    addEntity(new Player(new Coordinate2D(400,100), new Size(50, 50), scoreText, game));
  }

  @Override
  public void setupEntitySpawners() {
      addEntitySpawner(new PlatformSpawner(new Size(100, 300)));
  }

}
