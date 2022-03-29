package com.game;

import com.game.components.entities.text.HealthText;
import com.game.components.entities.text.ScoreText;
import com.game.components.helpers.GameConstants;
import com.game.components.scenes.GameScene;
import com.game.components.scenes.GameOverScene;
import com.game.components.scenes.TitleScene;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class Game extends YaegerGame {

    private final ScoreText SCORE_TEXT = new ScoreText();
    private final HealthText HEALTH_TEXT = new HealthText();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle(GameConstants.GAME_NAME);
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameScene(this, SCORE_TEXT, HEALTH_TEXT));
        addScene(2, new GameOverScene(this));
    }
}
