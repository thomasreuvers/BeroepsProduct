package com.game.components.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class PlayerIdle extends DynamicSpriteEntity {
    public PlayerIdle(Coordinate2D initialLocation, Size size) {
        super("sprites/player/player_sheet.png", initialLocation, size, 19, 7);
        setAutoCycle(60, 1);
    }
}
