package com.game.components.entities.platforms;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class GrassPlatform extends Platform {

    public GrassPlatform(double x, Size size, double speed) {
        super("sprites/platform.png", x, size, speed);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        super.notifyBoundaryCrossing(border);
    }
}
