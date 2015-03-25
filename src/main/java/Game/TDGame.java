package Game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TDGame implements ApplicationListener {

	private Texture fon;
	private SpriteBatch batch;
    private TextureRegion wall;
    private TextureRegion road;
    private int SIZE_MAP = 48;
    private Cell[][] bmap;
	
    @Override
    public void create() {   
    	fon = new Texture("assets/data/fon.jpg");
    	batch = new SpriteBatch();
    	wall = new TextureRegion(fon, 0, 0, 10, 10);
        road = new TextureRegion(fon,10,0,10,10);


        Generator g = new Generator(SIZE_MAP);
        boolean[][] map = g.getMaze();
        bmap = new Cell[SIZE_MAP][SIZE_MAP];

        for (int i = 0; i < SIZE_MAP; i++)
            for (int j = 0; j < SIZE_MAP; j++) {
                if (map[i][j] == false)
                    bmap[i][j] = new Cell(road);
                if (map[i][j] == true)
                    bmap[i][j] = new Cell(wall);
            }
    }

    @Override
    public void dispose() {
    }

    @Override
    public void render() {
        batch.begin();
        for (int i = 0; i < SIZE_MAP; i++)
            for (int j = 0; j < SIZE_MAP; j++)
                bmap[i][j].draw(batch, i*10, j*10);
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