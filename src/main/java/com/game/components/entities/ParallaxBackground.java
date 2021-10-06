package com.game.components.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class ParallaxBackground extends DynamicSpriteEntity implements SceneBorderTouchingWatcher {
    public ParallaxBackground(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);

        setPreserveAspectRatio(false);
        setMotion(getRandomSpeed(), Direction.LEFT);
    }

    private double getRandomSpeed(){
        double x;
        do {
            x = new Random().nextDouble() * (1 - 0.5) + 0.5;
        } while (x <= 0.5);
        return x;
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        if (sceneBorder.equals(SceneBorder.LEFT) && this.getAnchorLocation().getX() <= -getSceneWidth()){
            setAnchorLocationX(0);
            System.out.println("X");
        }
    }
}
