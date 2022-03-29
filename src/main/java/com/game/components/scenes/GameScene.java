package com.game.components.scenes;

import com.game.Game;
import com.game.components.entities.Player;
import com.game.components.entities.text.HealthText;
import com.game.components.entities.text.ScoreText;
import com.game.components.spawners.PlatformSpawner;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;

public class GameScene extends DynamicScene implements EntitySpawnerContainer {
  private final Game GAME;
  private final ScoreText SCORE_TEXT;
  private final HealthText HEALTH_TEXT;

  public GameScene(Game game, ScoreText scoreText, HealthText healthText){
    this.GAME = game;
    this.SCORE_TEXT = scoreText;
    this.HEALTH_TEXT = healthText;
  }

  @Override
  public void setupScene() {
    setBackgroundImage("backgrounds/game-bg.png");
    setBackgroundAudio("audio/mainGameTheme.mp3");
  }

  @Override
  public void setupEntities() {

    // Show current score to player
    SCORE_TEXT.setAnchorLocation(new Coordinate2D(0, 0));
    addEntity(this.SCORE_TEXT);

    // Show current health to player
    HEALTH_TEXT.setAnchorLocation(new Coordinate2D(0, 30));
    addEntity(this.HEALTH_TEXT);

    addEntity(new Player(new Coordinate2D(400,100), new Size(50, 50), SCORE_TEXT, HEALTH_TEXT, GAME));
  }

  @Override
  public void setupEntitySpawners() {
      addEntitySpawner(new PlatformSpawner(new Size(100, 300)));
  }

}
