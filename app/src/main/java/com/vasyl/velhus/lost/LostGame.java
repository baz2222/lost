package com.vasyl.velhus.lost;

import com.badlogic.gdx.Game;

public class LostGame extends Game {
    @Override
    public void create() {
        setScreen(new LogoSplashScreen(this));
    }

    @Override
    public void dispose() {
    }
}
