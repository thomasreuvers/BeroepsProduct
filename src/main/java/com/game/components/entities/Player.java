package com.game.components.entities;

import com.game.components.entities.platforms.Platform;
import com.game.components.entities.text.ScoreText;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Collection;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, Collider, Collided, Newtonian {

    private boolean isFalling = true;

    public Player(Coordinate2D initialLocation, Size size, ScoreText scoreText) {
        super("sprites/player/player.png", initialLocation, size);

        setGravityConstant(0);
        setFrictionConstant(0);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.SPACE) && !isFalling) {
            setMotion(getSpeed() * 1.5, Direction.UP);
            setGravityConstant(0.3);
            setFrictionConstant(0.04);
            isFalling = true;
        }else if (pressedKeys.contains(KeyCode.SPACE) && pressedKeys.contains(KeyCode.A) && !isFalling){

        }
        else if (pressedKeys.contains(KeyCode.ENTER)) {
            setGravityConstant(0.3);
            setFrictionConstant(0.04);
        }else if (pressedKeys.contains(KeyCode.A)){
            setAnchorLocationX(this.getAnchorLocation().getX() - 1 * getSpeed());
        }else if (pressedKeys.contains(KeyCode.D)){
            setAnchorLocationX(this.getAnchorLocation().getX() + 1 * getSpeed());
        }
    }

    @Override
    public void onCollision(Collider collidingObject) {
        if (collidingObject instanceof Platform && this.getAnchorLocation().getY() + this.getHeight() > collidingObject.getBoundingBox().getMinY())
        {
            this.setAnchorLocationY(((Platform) collidingObject).getAnchorLocation().getY() - this.getHeight());
            this.isFalling = false;
        }
    }
}
