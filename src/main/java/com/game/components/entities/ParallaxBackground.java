package com.game.components.entities;

import com.game.components.scenes.EntityScene;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class ParallaxBackground extends DynamicSpriteEntity implements SceneBorderTouchingWatcher {
    private final Size size;
    private final String resource;
    private final Coordinate2D initialLocation;
    private final EntityScene scene;
    private final int viewIndex;
    private final double speed;

    public ParallaxBackground(String resource, Coordinate2D initialLocation, Size size, EntityScene scene, int viewIndex, double speed) {
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

        // Check if middle of image touched boundary, if so spawn new image
        if (border.equals(SceneBorder.LEFT) && Math.round(this.getAnchorLocation().getX() / speed) == -(int)((this.size.width() / speed) / 2 )){
            System.out.println("Crossed boundary with middle of image: " + resource); // DEBUG
            var newLocation = new Coordinate2D((this.size.width() / 2), initialLocation.getY());
            scene.addNewEntity(new ParallaxBackground(resource, newLocation, size, scene, viewIndex, speed));
        }

        // Remove current image from scene if it's past the view
        if (border.equals(SceneBorder.LEFT) && Math.round(this.getAnchorLocation().getX() / speed) == -(int)(this.size.width() / speed)){
            System.out.println("Removed: " + resource); // DEBUG
            this.remove();
        }
    }
}
