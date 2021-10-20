package com.game.components.entities.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public abstract class Platform extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider {

    public Platform(String resource, Coordinate2D initialLocation, Size size, double speed) {
        super(resource, initialLocation, size);
        setMotion(speed, Direction.DOWN);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        remove();
    }
}
