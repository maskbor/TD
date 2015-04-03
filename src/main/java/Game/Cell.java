package Game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Александр on 24.03.2015.
 */
public abstract class Cell {
    int SIZE_MAP;
    Sprite sprite;

    public Cell(TextureRegion texture){
        this.sprite = new Sprite(texture);
        this.sprite.setSize(10, 10);
        this.SIZE_MAP=60;
    }
    public void setSize(int size){
        this.SIZE_MAP=size;
    }

    public abstract void update(int x, int y, Enemy[] masEnemy);

    public void setTexture(TextureRegion texture){
    this.sprite = new Sprite(texture);
    this.sprite.setSize(10, 10);

}

    public void draw(SpriteBatch batch,int x, int y){

        //sprite.setPosition(x-SIZE_MAP/2-sprite.getWidth()/2, y-SIZE_MAP/2-sprite.getHeight()/2);
        sprite.setPosition(x, y);
        sprite.draw(batch);
    }
}