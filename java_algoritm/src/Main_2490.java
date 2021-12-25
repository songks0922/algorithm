import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2490 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int cnt = 0;
        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            while(st.hasMoreTokens()) {
                if (st.nextToken().equals("0")) {
                    cnt++;
                }
            }
            switch(cnt) {
                case 1:
                    sb.append("A\n");
                    break;
                case 2:
                    sb.append("B\n");
                    break;
                case 3:
                    sb.append("C\n");
                    break;
                case 4:
                    sb.append("D\n");
                    break;
                default:
                    sb.append("E\n");
            }
            cnt = 0;
        }
        System.out.println(sb);
    }
}