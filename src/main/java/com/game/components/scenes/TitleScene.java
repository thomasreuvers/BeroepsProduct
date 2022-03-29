package com.game.components.scenes;

import com.game.Game;
import com.game.components.entities.ParallaxBackground;
import com.game.components.entities.buttons.ExitButton;
import com.game.components.entities.buttons.StartButton;
import com.game.components.helpers.GameConstants;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends DynamicScene implements EntityScene {
    private final Game GAME;

    public TitleScene(Game game){ this.GAME = game; }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/parallax-demon-woods-bg.png");
        setBackgroundAudio("audio/titleTheme.mp3");
    }

    @Override
    public void setupEntities() {
        addEntity(new ParallaxBackground("backgrounds/parallax-demon-woods-far-trees.png", new Coordinate2D(0, 0), new Size(this.getWidth() * 2, this.getHeight()), this, 40, 1.5));
        addEntity(new ParallaxBackground("backgrounds/parallax-demon-woods-mid-trees.png", new Coordinate2D(0, 0), new Size(this.getWidth() * 2, this.getHeight()), this, 39, 1.75));
        addEntity(new ParallaxBackground("backgrounds/parallax-demon-woods-close-trees.png", new Coordinate2D(0, 0), new Size(this.getWidth() * 2, this.getHeight()), this, 38, 2.0));

        // Add TextEntities
        addEntity(setupText());

        StartButton startButton = new StartButton(new Coordinate2D(320, 350), GAME);
        addEntity(startButton);

        ExitButton exitButton = new ExitButton(new Coordinate2D(640,0), GAME);
        addEntity(exitButton);
    }

    /**
     * Construct game name text entity
     * @return new TextEntity
     */
    private TextEntity setupText() {
        var x = new TextEntity(new Coordinate2D(getWidth() / 2 , getHeight() / 2), GameConstants.GAME_NAME);
        x.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        x.setFill(Color.GREEN);
        x.setFont(Font.font("Roboto", FontWeight.EXTRA_BOLD, 80));
        return x;
    }

    /**
     * Add a new entity to the scene
     * @param entity YaegerEntity
     */
    public void addNewEntity(YaegerEntity entity){
        addEntity(entity);
    }
}
