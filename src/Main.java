import java.util.Scanner;

/**
 * Created by 47989768s on 30/01/17.
 */
public class Main {

    static int[][] chessMatrix = new int[8][8];

    public static void main(String[] args) throws InterruptedException {

        int initX = 0;
        int initY = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la coordenada X:");
        initX = sc.nextInt();
        System.out.println("Introduce la coordenada Y:");
        initY = sc.nextInt();

        System.out.println("Estamos en (" + initX + "," + initY + ")");

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                chessMatrix[x][y] = 0;
            }
        }

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                System.out.print(chessMatrix[x][y]);
            }
            System.out.println();
        }

        System.out.println("\n");

        jump(initX,initY);

    }

    private static void jump(int x, int y) throws InterruptedException {

        int nextX, nextY;

        nextX = x+2;
        nextY = y+1;
        checkJump(nextX,nextY);

        nextX = x+2;
        nextY = y-1;
        checkJump(nextX,nextY);

        nextX = x+1;
        nextY = y+2;
        checkJump(nextX,nextY);

        nextX = x-1;
        nextY = y+2;
        checkJump(nextX,nextY);

        nextX = x-2;
        nextY = y+1;
        checkJump(nextX,nextY);

        nextX = x-2;
        nextY = y-1;
        checkJump(nextX,nextY);

        nextX = x+1;
        nextY = y-2;
        checkJump(nextX,nextY);

        nextX = x-1;
        nextY = y-2;
        checkJump(nextX,nextY);

        System.out.println("Volvemos para atrás");
        print(x,y);
        //sleep(1000);
        return;
    }

    private static void print(int nextX, int nextY) {

        System.out.println("Saltamos a (" + nextX + "," + nextY + ")");

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                System.out.print(chessMatrix[x][y]);
            }
            System.out.println();
        }

        System.out.println("\n");

    }

    private static boolean canJump(int nextX, int nextY) {
        if(nextX < 8 && nextY < 8 && nextX >= 0 && nextY >= 0) {
            if(chessMatrix[nextX][nextY] == 0){
                return true;
            }
            return false;
        }
        else return false;
    }

    private static void checkJump(int nextX, int nextY) throws InterruptedException {
        if(canJump(nextX,nextY)) {
            chessMatrix[nextX][nextY] = 1;
            print(nextX,nextY);
            //sleep(1000);
            jump(nextX,nextY);
        }
    }

}
