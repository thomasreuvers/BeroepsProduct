package com.game.components.entities.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Platform extends DynamicSpriteEntity implements SceneBorderCrossingWatcher {
    protected Platform(String resource, double x, Size size, double speed) {
        super(resource, new Coordinate2D(x, 0), size);
        setMotion(speed, Direction.DOWN);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        this.remove();
        System.out.println("Removed platform");
    }
}
