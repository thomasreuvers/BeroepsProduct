package com.game.components.spawners;

import com.game.components.entities.platforms.GrassPlatform;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.EntitySpawner;

import java.util.Random;

public class PlatformSpawner extends EntitySpawner {

    private final Size platformSize;

    public PlatformSpawner(Size platformSize) {
        super(500);

        this.platformSize = platformSize;
    }

    @Override
    protected void spawnEntities() {
//        var rand = new Random().nextInt(10);

//        if (rand <= 5){
//            spawn(new GrassPlatform(randomLocation(), platformSize, randomSpeed()));
//        }

        spawn(new GrassPlatform(randomLocation(), platformSize, randomSpeed()));
    }

    private int randomLocation() {
        return new Random().nextInt((int) (800 - platformSize.width()));
    }

    private double randomSpeed()
    {
        return 1.0 + (2.5 - 1.0) * new Random().nextDouble();
    }
}