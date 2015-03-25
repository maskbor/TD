package Game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class TDGame implements ApplicationListener {

	private Texture fon;
	private SpriteBatch batch;
    private TextureRegion wall;
    private TextureRegion road;
    private TextureRegion base;
    private TextureRegion baseVrag;
    private TextureRegion gun;

    private int SIZE_MAP = 60;
    private Cell[][] bmap = new Cell[SIZE_MAP][SIZE_MAP];
	
    @Override
    public void create() {   
    	fon = new Texture("assets/data/fon.jpg");
    	batch = new SpriteBatch();
    	wall = new TextureRegion(fon, 0, 0, 10, 10);
        road = new TextureRegion(fon,10,0,10,10);
        base = new TextureRegion(fon,20,0,10,10);
        baseVrag = new TextureRegion(fon,30,0,10,10);
        gun = new TextureRegion(fon,40,0,10,10);
        Generator g = new Generator(SIZE_MAP);
        int[][] map = g.getMaze();
        bmap = new Cell[SIZE_MAP][SIZE_MAP];

        for (int i = 0; i < SIZE_MAP; i++)
            for (int j = 0; j < SIZE_MAP; j++) {
                if (map[i][j] == 0) {
                    bmap[i][j] = new Road(road);
                }
                if (map[i][j] == 1)
                    bmap[i][j] = new Wall(wall);
                if(map[i][j] == 2)
                    bmap[i][j] = new Base(base,false);
                if(map[i][j] == 3)
                    bmap[i][j] = new Base(baseVrag,true);
            }
    }

    @Override
    public void dispose() {
    }


    @Override
    public void render() {
        update();
        batch.begin();
        for (int i = 0; i < SIZE_MAP; i++)
            for (int j = 0; j < SIZE_MAP; j++)
                bmap[i][j].draw(batch, i*10+5, j*10+5);
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

    public void update(){
        boolean isTouched = Gdx.input.isTouched();
        if(isTouched) {
            //bmap[Gdx.input.getX()/10][59-Gdx.input.getY()/10]
            bmap[Gdx.input.getX()/10][59-Gdx.input.getY()/10]=new Tower(gun);
        }
    }

}