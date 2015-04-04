package Game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Александр on 04.04.2015.
 */
public class Bullet {
    private Sprite sprite;
    private boolean alive;
    private int offsetX;
    private int offsetY;
    private int posX, posY;

    public Bullet(int posX, int posY, int EnemyX, int EnemyY) {
        this.sprite = new Sprite(new Texture("assets/data/Bullet.png"));
        this.posX = posX;
        this.posY = posY;
        this.offsetX=EnemyX - posX;
        this.offsetY=EnemyY - posY;
        this.sprite.setSize(2, 2);
        this.alive = true;
    }

    public void update(Enemy[] masEnemy) {
        for(int i=0;i<masEnemy.length;i++){
        //    if(masEnemy[i]!=null&&getDistance(masEnemy[i].getPosX(),masEnemy[i].getPosY(), x, y)<R)
        }
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public boolean getAlive() {
        return this.alive;
    }

    public void draw(SpriteBatch batch, int x, int y) {

        //sprite.setPosition(x-SIZE_MAP/2-sprite.getWidth()/2, y-SIZE_MAP/2-sprite.getHeight()/2);
        sprite.setPosition(x, y);
        sprite.draw(batch);
    }}
