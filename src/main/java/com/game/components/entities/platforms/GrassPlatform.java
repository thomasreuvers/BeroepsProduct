package com.game.components.entities.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class GrassPlatform extends Platform {

    public GrassPlatform(Coordinate2D initialLocation, Size size, double speed) {
        super("sprites/platform/platform.png", initialLocation , size, speed);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        super.notifyBoundaryCrossing(border);
    }
}
