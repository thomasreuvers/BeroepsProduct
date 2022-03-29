package com.game.components.entities.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class SpikePlatform extends Platform {

    public SpikePlatform(Coordinate2D initialLocation, Size size, double speed) {
        super("sprites/platform/spikePlatform.png", initialLocation, size, speed);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        super.notifyBoundaryCrossing(border);
    }

    @Override
    public double doDamage() {
        return 0.5;
    }
}
