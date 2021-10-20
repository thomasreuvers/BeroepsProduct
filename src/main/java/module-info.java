module beroepsProduct {
    requires hanyaeger;

    exports com.game;

    opens audio;
    opens backgrounds;
    opens sprites.player;
    opens sprites.platform;
}