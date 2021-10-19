package com.game.components.entities.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Platform extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider {
    private final Coordinate2D initialLocation;

    public Platform(String resource, Coordinate2D initialLocation, Size size, double speed) {
        super(resource, initialLocation, size);
        setMotion(speed, Direction.DOWN);

        this.initialLocation = initialLocation;
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {

    }

    public Coordinate2D getInitialLocation() {
        return initialLocation;
    }
}
