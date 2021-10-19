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
  private final ScoreText scoreText;

  public GameScene(Game game, ScoreText scoreText){
    this.game = game;
    this.scoreText = scoreText;
  }

  @Override
  public void setupScene() {
    setBackgroundImage("backgrounds/game-bg.png");
    setBackgroundAudio("audio/mainGameTheme.mp3");
  }

  @Override
  public void setupEntities() {

    // Show current score to player
    scoreText.setAnchorLocation(new Coordinate2D(0, 0));
    addEntity(this.scoreText);

    addEntity(new Player(new Coordinate2D(400,100), new Size(50, 50), scoreText, game));
  }

  @Override
  public void setupEntitySpawners() {
      addEntitySpawner(new PlatformSpawner(new Size(100, 300)));
  }

}
