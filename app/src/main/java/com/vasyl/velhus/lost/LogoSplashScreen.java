package com.vasyl.velhus.lost;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

public class LogoSplashScreen extends ScreenAdapter {
    SpriteBatch logo_splash_batch;
    Texture logo_splash_texture;
    int logo_texture_position_x;
    int logo_texture_position_y;
    float splash_screen_delay;
    float splash_screen_elapsed_time;
    LostGame game;
    LogoSplashScreen(LostGame game){
        this.game=game;
        logo_splash_batch=new SpriteBatch();
        logo_splash_texture=getAdjustedLogoTexture("app/logo.png");
        logo_splash_texture.setFilter(TextureFilter.Linear,TextureFilter.Linear);
        logo_texture_position_x=(int)(0.5*Gdx.app.getGraphics().getWidth()-0.5*logo_splash_texture.getWidth());
        logo_texture_position_y=(int)(0.5*Gdx.app.getGraphics().getHeight()-0.5*logo_splash_texture.getHeight());
        splash_screen_delay=2;
    }//constructor
    private Texture getAdjustedLogoTexture(String path){
        Pixmap original_logo_pixmap;
        Pixmap adjusted_logo_pixmap;
        original_logo_pixmap=new Pixmap(Gdx.files.internal(path));
        adjusted_logo_pixmap = new Pixmap((int)(0.5*Gdx.app.getGraphics().getHeight()),(int)(0.5*Gdx.app.getGraphics().getHeight()),original_logo_pixmap.getFormat());
        adjusted_logo_pixmap.drawPixmap(original_logo_pixmap,0,0,original_logo_pixmap.getWidth(),original_logo_pixmap.getHeight(),0,0,adjusted_logo_pixmap.getWidth(),adjusted_logo_pixmap.getHeight());
        return new Texture(adjusted_logo_pixmap);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        splash_screen_elapsed_time+=v;
        if(splash_screen_elapsed_time>splash_screen_delay){
            game.setScreen(new LoaderScreen(game));
        }
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        logo_splash_batch.begin();
        logo_splash_batch.draw(logo_splash_texture,logo_texture_position_x,logo_texture_position_y);
        logo_splash_batch.end();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        logo_splash_batch.dispose();
        logo_splash_texture.dispose();
    }
}
