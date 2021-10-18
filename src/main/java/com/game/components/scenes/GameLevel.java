package com.game.components.scenes;

import com.game.Game;
import com.game.components.entities.Player;
import com.game.components.entities.PlayerIdle;
import com.game.components.spawners.PlatformSpawner;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {

  private Game game;

  public GameLevel(Game game){
    this.game = game;
  }

  @Override
  public void setupScene() {
    setBackgroundImage("backgrounds/game-level.jpg");
  }

  @Override
  public void setupEntities() {

    addEntity(new Player(new Coordinate2D(400,100), new Size(1000, 1000)));
  }

  @Override
  public void setupEntitySpawners() {
      addEntitySpawner(new PlatformSpawner(new Size(100, 300)));
  }

}
