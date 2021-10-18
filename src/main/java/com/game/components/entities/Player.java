package com.game.components.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, Newtonian {

    private final Coordinate2D initialLocation;

    public Player(Coordinate2D initialLocation, Size size) {
        super("sprites/player/player_sheet.png",initialLocation, size, 19, 1);
        this.initialLocation = initialLocation;


        setAutoCycle(40, 0);

        setGravityConstant(0.3);
        setFrictionConstant(0.04);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.SPACE)){
            this.setAnchorLocationY(this.getAnchorLocation().getY() + -25.0);
            System.out.println("Jump");
        }
    }
}
