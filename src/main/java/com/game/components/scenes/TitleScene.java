package com.game.components.scenes;

import com.game.components.entities.ParallaxBackground;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;

public class TitleScene extends DynamicScene {

    @Override
    public void setupScene() {
//        setBackgroundImage("backgrounds/titleScreen.jpg");
        setBackgroundImage("backgrounds/parallax-demon-woods-bg.png");
    }

    @Override
    public void setupEntities() {
        addEntity(new ParallaxBackground("backgrounds/parallax-demon-woods-far-trees.png", new Coordinate2D(0, 0), new Size(this.getWidth() * 2, this.getHeight())));
        addEntity(new ParallaxBackground("backgrounds/parallax-demon-woods-mid-trees.png", new Coordinate2D(0, 0), new Size(this.getWidth() * 2, this.getHeight())));
        addEntity(new ParallaxBackground("backgrounds/parallax-demon-woods-close-trees.png", new Coordinate2D(0, 0), new Size(this.getWidth() * 2, this.getHeight())));
    }
}
