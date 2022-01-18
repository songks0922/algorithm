import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JumpGame {

    static int n;
    static int board [][] = new int[100][100];
    static int cache[][] = new int[100][100];


    static int jump(int y, int x){
        if(y>=n || x>= n) return 0;

        if(y ==n-1 && x==n-1) return 1;

        if(cache[y][x] != -1) return cache[y][x];

        int jumpSize = board[y][x];
        return cache[y][x] = jump(y+jumpSize, x) | jump(y, x+jumpSize);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(tc>0){

            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                Arrays.fill(cache[i], -1);
            }
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<n; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append(jump(0,0) !=0 ? "YES" : "NO").append("\n");
            tc--;
        }
        System.out.println(sb);
    }
}
