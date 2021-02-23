import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2670 {

    static int N;
    static double[] num_list,dp;
    static double ans,mul;

    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer=new StringTokenizer(reader.readLine());

        N=Integer.parseInt(tokenizer.nextToken());

        num_list= new double[N];
        dp=new double[N+1];

        for(int i=0; i<N; i++){
            double A=Double.parseDouble(reader.readLine());
            num_list[i]=A;
        }

        ans=0;
        mul=0;

        for(int a=0; a<N; a++){
            mul=num_list[a];
            dp[a]=Math.max(dp[a],mul);
            for (int b=a+1;b<N;b++){
                mul *= num_list[b];
                dp[a]=Math.max(ans,dp[a]);
            }
        }


        System.out.println(String.format("%.3f", ans));
    }
}
