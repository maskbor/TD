package Game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Александр on 25.03.2015.
 */
public class Base extends Cell {
    private boolean vrag;
    public Base(TextureRegion texture, boolean vrag){
        super(texture);
        this.vrag=vrag;
    }

    @Override
    public void update(int x, int y,Enemy[] masEnemy) {

    }
}
