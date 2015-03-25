package Game;

import java.util.Random;

/**
 * Created by Александр on 24.03.2015.
 */

public class Generator {
    //0-дорога 1-стена 2-база, 3-враг
    private int size;
    private int[][] maze;

    public Generator(int size) {
        this.size = size;
        this.maze = new int[size][size];
        Random rand = new Random();

        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - 1; j++)
                this.maze[i][j] = 1;


        for (int i = 0; i <= size - 1; i++) {
            maze[0][i] = 1;
            maze[size - 1][i] = 1;

            maze[i][0] = 1;
            maze[i][size - 1] = 1;
        }

        int predCenterRoomI=0, predCenterRoomJ=0;

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                int centerRoomI = i * 20 + rand.nextInt(10);
                int centerRoomJ = j * 20 + rand.nextInt(10);
                createRoom(centerRoomI, centerRoomJ, rand.nextInt(8) + 2, rand.nextInt(8) + 2);
                createCoridor(predCenterRoomI,predCenterRoomJ,centerRoomI,centerRoomJ);
                predCenterRoomI=centerRoomI;
                predCenterRoomJ=centerRoomJ;
            }
        maze[0][0]=2;
        maze[predCenterRoomI][predCenterRoomJ]=3;
    }

    private void createRoom(int centerI, int centerJ, int sizeI, int sizeJ) {
        int topLeftI = centerI - sizeI;
        while (topLeftI < 0) {
            topLeftI++;
        }
        int topLeftJ = centerJ - sizeJ;
        while (topLeftJ < 0) {
            topLeftJ++;
        }
        int downRightI = centerI + sizeI;
        while (downRightI >= size) {
            downRightI--;
        }
        int downRightJ = centerJ + sizeJ;
        while (downRightJ >= size) {
            downRightJ--;
        }


        for (int i = topLeftI; i < downRightI; i++)
            for (int j = topLeftJ; j < downRightJ; j++) {
                maze[i][j]=0;
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