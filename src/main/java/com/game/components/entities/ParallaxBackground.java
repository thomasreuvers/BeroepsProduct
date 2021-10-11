package com.game.components.entities;

import com.game.components.scenes.TitleScene;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.scenes.YaegerScene;

import java.util.Random;

public class ParallaxBackground extends DynamicSpriteEntity implements SceneBorderTouchingWatcher {
    private Size size;
    private String resource;
    private Coordinate2D initialLocation;
    private YaegerScene scene;
    private int viewIndex;
    private double speed;

    public ParallaxBackground(String resource, Coordinate2D initialLocation, Size size, YaegerScene scene, int viewIndex, double speed) {
        super(resource, initialLocation, size);

        this.resource = resource;
        this.initialLocation = initialLocation;
        this.size = size;
        this.scene = scene;
        this.viewIndex = viewIndex;
        this.speed = speed;

        setViewOrder(viewIndex);

        setPreserveAspectRatio(false);
        setMotion(speed, Direction.LEFT);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        if (border.equals(SceneBorder.LEFT) && (int)this.getAnchorLocation().getX() == -(this.size.width() / 2 )){
            System.out.println("Crossed boundary with mid");
            var x = new Coordinate2D((this.size.width() / 2) - 1, initialLocation.getY());
            System.out.println(x.getX());
            ((TitleScene)scene).addNewEntity(new ParallaxBackground(resource, x, size, scene, viewIndex, speed));
        }

//        if (border.equals(SceneBorder.LEFT) && (int)this.getAnchorLocation().getX() == -(this.size.width())){
//            this.remove();
//        }

//        System.out.println(this.getAnchorLocation().getX());
    }
}
