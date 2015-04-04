package Game;

import java.util.Random;

/**
 * Created by Александр on 24.03.2015.
 */

public class Generator {
    //0-дорога 1-стена 2-база, 3-враг, 4-башня
    private int size;
    private int[][] maze;

    public Generator(int size) {
        this.size = size;
        this.maze = new int[size][size];
        Random rand = new Random();

        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - 1; j++)
                this.maze[i][j] = -1;


        for (int i = 0; i <= size - 1; i++) {
            maze[0][i] = 1;
            maze[size - 1][i] = 1;

            maze[i][0] = 1;
            maze[i][size - 1] = 1;
        }

        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - 1; j++) {
                if (this.maze[i][j] == -1) {
                    createBlock(i, j, rand.nextInt(5) + 3);
                }
            }


        for (int i = 0; i <= size - 1; i++) {
            maze[0][i] = 1;
            maze[size - 1][i] = 1;

            maze[i][0] = 1;
            maze[i][size - 1] = 1;
        }


        maze[1][1] = 2;

        int baseCount=0;
        for (int i = size - 1; i > 0; i--)
            for (int j = size - 1; j > 0; j--) {
                if (maze[i][j]==0&&baseCount==0){
                    maze[i][j]=3;
                    baseCount++;
                    break;
                }
            }
    }

    private void createBlock(int x, int y, int sizeRoom) {
        Random random = new Random();
        int position=random.nextInt(10)%2;
                int height = x+sizeRoom;
                while (height>=size) height--;
                int width = y+2;
                while (width>=size)width--;
                switch (position){
                    case 0:
                        for (int i=x; i<height; i++)
                            for (int j = y; j<width; j++)
                                maze[i][j]=0;
                        for (int i=x+1; i<height; i++)
                            for (int j = y+1; j<width; j++)
                                maze[i][j]=1;
                        break;
                    case 1:
                        height = y+sizeRoom;
                        width = x+2;
                        while (height>=size) height--;
                        while (width>=size)width--;
                        for (int i=y; i<height; i++)
                            for (int j = x; j<width; j++)
                                maze[j][i]=0;
                        for (int i=y+1; i<height; i++)
                            for (int j = x+1; j<width; j++)
                                maze[j][i]=1;
                        break;
                }
    }


    private void createCoridor(int firstI, int firstJ, int lastI, int lastJ){
        if(firstI<lastI){
            for (int i=firstI; i<=lastI; i++) {
                maze[i][firstJ] = 0;
                maze[i][lastJ] = 0;
            }
        } else {
            for (int i=lastI; i<=firstI; i++) {
                maze[i][lastJ] = 0;
                maze[i][firstJ] = 0;
            }
        }

        if(firstJ<lastJ){
            for (int i=firstJ; i<=lastJ; i++) {
                maze[firstI][i] = 0;
                maze[lastI][i] = 0;
            }
        } else {
            for (int i=lastJ; i<=firstJ; i++) {
                maze[lastI][i] = 0;
                maze[firstI][i] = 0;
            }
        }
    }

    public int[][] getMaze() {

        return this.maze;
    }
}