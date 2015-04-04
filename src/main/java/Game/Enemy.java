package Game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


import java.util.Random;

/**
 * Created by Александр on 25.03.2015.
 */
public class Enemy {
    private Sprite sprite;
    private int HP;
    private boolean alive;
    private int posX, posY;
    private double lastStepTime;
    private int lastStep;
    //0-лево 1-низ, 2-правл 3-вверх
    private int direction;

    public Enemy(TextureRegion texture, int posX, int posY) {
        this.sprite = new Sprite(texture);
        this.posX = posX;
        this.posY = posY;
        this.lastStepTime = 0;
        this.sprite.setSize(10, 10);
        this.alive = true;
        this.HP = 100;
        this.direction=2;
    }

    public void update(int left, int down, int rigth, int top, float velosity) {
        if (lastStepTime > 0.05) {
            lastStepTime = 0;
            Random random = new Random();
            int nextStep = -1;
            boolean found = false;
            //0-лево 1-низ, 2-правл 3-вверх
            switch (direction){
                case 0: if((rigth==1||rigth==2)&&(top==1||top==2)&&(down==1||down==2)) direction=-1;
                    break;
                case 1: if((rigth==1||rigth==2)&&(left==1||left==2)&&(top==1||top==2)) direction=-1;
                    break;
                case 2: if((left==1||left==2)&&(top==1||top==2)&&(down==1||down==2)) direction=-1;
                    break;
                case 3: if((rigth==1||rigth==2)&&(left==1||left==2)&&(down==1||down==2)) direction=-1;
                    break;
                default: break;
            }

            while (!found) {
                nextStep = random.nextInt(4);
                switch (nextStep) {
                    case 0:
                        if (direction != 0 &&
                                left == 0) {
                            goLeft();
                            found = true;
                        }
                        break;
                    case 1:
                        if (direction != 1 &&
                                down == 0) {
                            goDown();
                            found = true;
                        }
                        break;
                    case 2:
                        if (direction != 2 &&
                                rigth == 0) {
                            goRigth();
                            found = true;
                        }
                        break;
                    case 3:
                        if (direction != 3 &&
                                top == 0) {
                            goUp();
                            found = true;
                        }
                        break;
                    default:
                        break;
                }
            }
            //0-лево 1-низ, 2-правл 3-вверх
            switch (nextStep) {
                case 0:
                    direction = 2;
                    break;
                case 1:
                    direction = 3;
                    break;
                case 2:
                    direction = 0;
                    break;
                case 3:
                    direction = 1;
                    break;
                default:
                    break;
            }
            this.sprite.setPosition(posX, posY);
        } else lastStepTime += velosity;
    }

    private void goUp() {
        this.posY -= 10;
    }

    private void goDown() {
        this.posY += 10;
    }

    private void goLeft() {
        this.posX -= 10;
    }

    private void goRigth() {
        this.posX += 10;
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

    public void setHP(int value) {
        this.HP -= value;
        if (this.HP <= 0)
            alive = false;
    }

    public void draw(SpriteBatch batch, int x, int y) {

        //sprite.setPosition(x-SIZE_MAP/2-sprite.getWidth()/2, y-SIZE_MAP/2-sprite.getHeight()/2);
        sprite.setPosition(x, y);
        sprite.draw(batch);
    }
}
