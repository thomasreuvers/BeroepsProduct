package com.game.components.entities;

import com.game.Game;
import com.game.components.entities.platforms.Platform;
import com.game.components.entities.text.ScoreText;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, Collider, Collided, Newtonian, SceneBorderCrossingWatcher {
    private final Game game;
    private final ScoreText scoreText;
    private boolean isFalling = true;

    private Collider colliderObj;

    public Player(Coordinate2D initialLocation, Size size, ScoreText scoreText, Game game) {

        super("sprites/player/player.png", initialLocation, size);
        this.game = game;

        // Initialize player score
        this.scoreText = scoreText;

        setGravityConstant(0);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.SPACE) && !isFalling) {
            setMotion(getSpeed() * 1.7, Direction.UP);
            isFalling = true;
        }else if (pressedKeys.contains(KeyCode.A)){
            setMotion(1.2, Direction.LEFT);
        }else if (pressedKeys.contains(KeyCode.D)){
            setMotion(1.2, Direction.RIGHT);
        }else if(pressedKeys.contains(KeyCode.ENTER)){
            setGravityConstant(0.3);
            setFrictionConstant(0.04);
        }
    }

    @Override
    public void onCollision(Collider collidingObject) {
        if (collidingObject instanceof Platform && this.getAnchorLocation().getY() + this.getHeight() >= collidingObject.getBoundingBox().getMinY())
        {
            // Only increment score if player touches a platform which has not been touched before.
            if (colliderObj == null || !colliderObj.equals(collidingObject))
            {
                scoreText.incrementScore(1);
                scoreText.showScore();
            }
            colliderObj = collidingObject;

            setGravityConstant(0.3);
            setFrictionConstant(0.04);
            this.setAnchorLocationY(((Platform) collidingObject).getAnchorLocation().getY() - this.getHeight());
            this.isFalling = false;
        }
    }

  @Override
  public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        if (sceneBorder.equals(SceneBorder.BOTTOM))
        {
            this.game.setActiveScene(2);
        }
  }
}
