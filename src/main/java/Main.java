/**
 * Created by Александр on 22.03.2015.
 */

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import Game.MyTestGame;

public class Main {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "test-game";
        cfg.useGL30=false;
        //cfg.useGL20 = false;
        cfg.width = 480;
        cfg.height = 320;
        new LwjglApplication(new MyTestGame(), cfg);
    }
}
