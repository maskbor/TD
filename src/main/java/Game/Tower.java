package Game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Александр on 25.03.2015.
 */
public class Tower extends Cell {
    private double R;
    private Enemy[] masEnemy;// = new Enemy[10];
    public Tower(TextureRegion texture){
        super(texture);
        R=30;
    }

    @Override
    public void update(int x, int y,Enemy[] masEnemy) {
        for(int i=0;i<masEnemy.length;i++){
                if(masEnemy[i]!=null&&getDistance(masEnemy[i].getPosX(),masEnemy[i].getPosY(), x, y)<R){
                    masEnemy[i].setHP(10);
                    //System.out.println(getDistance(masEnemy[i].getPosX(),masEnemy[i].getPosY(), x, y));
                }
            }

    }

    private double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt( Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2) );
    }

}
