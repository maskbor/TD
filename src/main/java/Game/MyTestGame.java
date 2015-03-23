package Game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyTestGame implements ApplicationListener {
	
	private Texture quadTexture;
	private SpriteBatch batch;
	private TextureRegion redRegion;
	
    @Override
    public void create() {   
    	quadTexture = new Texture("data/quads.png");
    	batch = new SpriteBatch();
    	redRegion = new TextureRegion(quadTexture, 0, 0, 32, 32);
    }

    @Override
    public void dispose() {
    }

    @Override
    public void render() {  
    	batch.begin();
    	batch.draw(redRegion, 30, 30, 50, 50);
    	batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}