/**
 * Created by Александр on 22.03.2015.
 */

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import Game.TDGame;

public class Main {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "TD";
        cfg.useGL30=false;
        //cfg.useGL20 = false;
        cfg.width = 600;
        cfg.height = 600;
        new LwjglApplication(new TDGame(), cfg);
    }
}
