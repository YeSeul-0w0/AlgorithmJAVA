package BackJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class _14501 {
    public static int N;
    public static int[][] timePay;
    public static int result;

    public static void checking(int t, int p){
        if(t>=N){
            result=Math.max(result,p);
            return;
        }
        if(t+timePay[t][0]<=N){
            checking(t+timePay[t][0],p+timePay[t][1]);
        }
        else{
            checking(t+timePay[t][0],p);
        }
        checking(t+1,p);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        timePay=new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            timePay[i][0]=Integer.parseInt(st.nextToken());
            timePay[i][1]=Integer.parseInt(st.nextToken());
        }

        result=0;
        checking(0,0);
        System.out.println(result);
    }
}
