package com.vasyl.velhus.lost;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LoaderScreen extends ScreenAdapter {
    LostGame game;
    SpriteBatch loader_screen_batch;
    Texture loader_screen_texture;
    int loader_texture_position_x;
    int loader_texture_position_y;

    LoaderScreen(LostGame game){
        this.game=game;
        loader_screen_batch=new SpriteBatch();
        loader_screen_texture=getAdjustedLoaderScreenTexture("app/loader-screen-background.png");
        loader_screen_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        loader_texture_position_x=(int)(0.5*Gdx.app.getGraphics().getWidth()-0.5*loader_screen_texture.getWidth());
        loader_texture_position_y=(int)(0.5*Gdx.app.getGraphics().getHeight()-0.5*loader_screen_texture.getHeight());
    }

    private Texture getAdjustedLoaderScreenTexture(String path) {
        Pixmap original_image_pixmap;
        Pixmap adjusted_image_pixmap;
        original_image_pixmap=new Pixmap(Gdx.files.internal(path));
        adjusted_image_pixmap=new Pixmap(Gdx.app.getGraphics().getWidth(),Gdx.app.getGraphics().getHeight(),original_image_pixmap.getFormat());
        adjusted_image_pixmap.drawPixmap(original_image_pixmap,0,(int)(0.5*original_image_pixmap.getHeight()-0.5*adjusted_image_pixmap.getHeight()),original_image_pixmap.getWidth(),adjusted_image_pixmap.getHeight(),0,0,adjusted_image_pixmap.getWidth(),adjusted_image_pixmap.getHeight());
        return new Texture(adjusted_image_pixmap);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        loader_screen_batch.begin();
        loader_screen_batch.draw(loader_screen_texture,loader_texture_position_x,loader_texture_position_y);
        loader_screen_batch.end();

    }

}
