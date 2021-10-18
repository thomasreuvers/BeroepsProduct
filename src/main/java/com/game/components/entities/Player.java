package com.game.components.entities;

import com.game.components.entities.platforms.GrassPlatform;
import com.game.components.entities.platforms.Platform;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.core.entities.motion.MotionApplier;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, Collider, Collided, Newtonian {

    private final Coordinate2D initialLocation;

    public Player(Coordinate2D initialLocation, Size size) {
        super("sprites/player/player.png", initialLocation, size);
        this.initialLocation = initialLocation;


//        setAutoCycle(40, 0);
        setGravityConstant(0);
        setFrictionConstant(0);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.SPACE)){
            this.setAnchorLocationY(this.getAnchorLocation().getY() - 100.0);
            System.out.println("Jump");
        }else if (pressedKeys.contains(KeyCode.ENTER)) {
            setGravityConstant(0.3);
            setFrictionConstant(0.04);
        }else if (pressedKeys.contains(KeyCode.A)){
            setAnchorLocationX(this.getAnchorLocation().getX() - 10);
        }else if (pressedKeys.contains(KeyCode.D)){
            setAnchorLocationX(this.getAnchorLocation().getX() + 10);
        }
    }

    @Override
    public void onCollision(Collider collidingObject) {
        if (collidingObject instanceof Platform)
        {
            if (this.getAnchorLocation().getY() + this.getHeight() > collidingObject.getBoundingBox().getMinY()){
                this.setAnchorLocationY(((Platform) collidingObject).getAnchorLocation().getY() - this.getHeight());
            }
        }
    }
}
