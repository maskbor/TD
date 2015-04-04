package Game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TDGame implements ApplicationListener {

	private Texture fon;
    private Texture enemy;
	private SpriteBatch batch;
    private TextureRegion wall;
    private TextureRegion enemy1;
    private TextureRegion road;
    private TextureRegion base;
    private TextureRegion baseVrag;
    private TextureRegion tower;
    private long lastSec=System.currentTimeMillis();
    private int intervalGen = 3;
    private boolean baseAlive;

    private Texture win;
    private Texture lose;
    private Enemy[] masEnemy = new Enemy[10];
    private int enemyCount=0;

    private int SIZE_MAP = 60;
    private Cell[][] bmap = new Cell[SIZE_MAP][SIZE_MAP];
    int[][] map;

    @Override
    public void create() {
        win = new Texture("assets/data/win.png");
        fon = new Texture("assets/data/fon.jpg");
        lose = new Texture("assets/data/lose.jpg");
        enemy = new Texture("assets/data/enemy.png");
        batch = new SpriteBatch();
    	wall = new TextureRegion(fon, 0, 0, 10, 10);
        enemy1 = new TextureRegion(enemy, 0, 0, 10, 10);
        road = new TextureRegion(fon,10,0,10,10);
        base = new TextureRegion(fon,20,0,10,10);
        baseVrag = new TextureRegion(fon,30,0,10,10);
        tower = new TextureRegion(fon,40,0,10,10);
        Generator g = new Generator(SIZE_MAP);
        map = g.getMaze();
        bmap = new Cell[SIZE_MAP][SIZE_MAP];

        baseAlive=true;
        for (int i = 0; i < SIZE_MAP; i++){
            for (int j = 0; j < SIZE_MAP; j++)
                System.out.print(map[i][j]);
            System.out.println();}


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
                bmap[i][j].draw(batch, i*10, (59-j)*10);

        int countAliveEnemy=10;
        for(int i = 0; i<enemyCount; i++)
            if(masEnemy[i].getAlive()) masEnemy[i].draw(batch,masEnemy[i].getPosX(),(59-masEnemy[i].getPosY()/10)*10);
                else countAliveEnemy--;
        if(countAliveEnemy==0) batch.draw(win,0,0,600,600);
        if(!baseAlive)         batch.draw(lose, 0, 0, 600, 600);
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
            if(map[Gdx.input.getX()/10][Gdx.input.getY()/10]==1){
                bmap[Gdx.input.getX()/10][Gdx.input.getY()/10]=new Tower(tower);
                map[Gdx.input.getX()/10][Gdx.input.getY()/10]=4;
            }
        }
        for(int i=0;i<SIZE_MAP;i++)
            for (int j = 0; j < SIZE_MAP; j++){
                if (map[i][j]==3&&enemyCount<10&&(System.currentTimeMillis()/1000-lastSec/1000)>intervalGen){
                    masEnemy[enemyCount] = new Enemy(enemy1,i*10,j*10);
                    enemyCount++;
                    lastSec=System.currentTimeMillis();
                }

                if(map[i][j]==4){
                    bmap[i][j].update(i*10,j*10, masEnemy);
                }
                if(map[i][j]==2){
                    bmap[i][j].update(i*10,j*10, masEnemy);
                    baseAlive=bmap[i][j].getAlive();
                }

            }

        for (int i=0; i<enemyCount; i++) {
            masEnemy[i].update(map[masEnemy[i].getPosX()/10-1][masEnemy[i].getPosY()/10],
                               map[masEnemy[i].getPosX()/10][masEnemy[i].getPosY()/10+1],
                               map[masEnemy[i].getPosX()/10+1][masEnemy[i].getPosY()/10],
                               map[masEnemy[i].getPosX()/10][masEnemy[i].getPosY()/10-1],
                                Gdx.graphics.getDeltaTime());
        }
    }

    public Enemy[] getMasEnemy(){
        return masEnemy;
    }

}