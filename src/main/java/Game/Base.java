package Game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Александр on 25.03.2015.
 */
public class Base extends Cell {
    private boolean vrag;
    private boolean alive;

    public Base(TextureRegion texture, boolean vrag){
        super(texture);
        this.vrag=vrag;
        alive=true;
    }

    @Override
    public void update(int x, int y,Enemy[] masEnemy) {
        for(int i=0;i<masEnemy.length;i++){
            if(masEnemy[i]!=null&&getDistance(masEnemy[i].getPosX(),masEnemy[i].getPosY(), x, y)<20&&vrag==false){
                alive=false;
            }
        }

    }

    @Override
    public boolean getAlive() {
        return alive;
    }

    private double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt( Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2) );
    }
}
