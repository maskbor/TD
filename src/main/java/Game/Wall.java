package Game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Александр on 25.03.2015.
 */
public class Wall extends Cell {
    public Wall(TextureRegion texture){
    super(texture);
}

    @Override
    public void update(int x, int y,Enemy[] masEnemy) {

    }
}