package com.game.components.scenes;

import com.game.components.entities.platforms.GrassPlatform;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameLevel extends DynamicScene {

  public GameLevel(){
    super();
  }

  @Override
  public void setupScene() {
    setBackgroundImage("backgrounds/game-level.jpg");
  }

  @Override
  public void setupEntities() {

    // TODO extract code and make spawner class
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        var rand = new Random();

        var size = new Size(100, 300);
        addEntity(new GrassPlatform(rand.nextInt((int) (800 - size.width())), size, 2.0));
      }
    }, 0, 1000);

  }


}
