import java.util.Scanner;

public class JumpGame {

    static int n;
    static int board [][] = new int[100][100];
    static int cache[][] = new int[100][100];


    static int jump(int y, int x){
        if(y>=n || x>= n){
            return 0;
        }
        if(y ==n-1 && x==n-1){
            return 1;
        }
        if(cache[y][x] != -1){
            return cache[y][x];
        }
        int jumpSize = board[y][x];
        return cache[y][x] = jump(y+jumpSize, x) | jump(y, x+jumpSize);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int tc = input.nextInt();

        while(tc>0){

            n = input.nextInt();
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    board[i][j] =input.nextInt();
                    cache[i][j] = -1;
                }
            }
            System.out.println (jump(0,0) !=0 ? "YES" : "NO");
            tc--;
        }
    }
}
