import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Temp {

//    static public int solutiton(int n) {
//        int answer = 0;
//        boolean[] eratosthenes = new boolean[n + 1];
//
//        for(int i=2;i<=n;i++) {
//            if(eratosthenes[i]==false){
//                answer++;
//                for(int j = i*2; j <= n;j += i){
//                    eratosthenes[j]=true;
//                }
//            }
//        }
//        return answer;
//    }


    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        System.out.println(solutiton(n));

        int[][] arr = {{1,2,3}, {4,6}, {20,10,5,5}};
        int sum = 0;
        int avg = 0;
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
            avg = sum / arr[i].length;
            System.out.println("합: " + sum + ", " + "평균: " + avg);
            sum = 0;
            avg= 0;
        }
    }

}
