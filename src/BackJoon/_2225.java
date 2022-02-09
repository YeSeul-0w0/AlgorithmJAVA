package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2225 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        long mod=1000000000;

        long[][] dp=new long[K+1][N+1];
        // K개의 숫자를 합쳐 N이 나오는 경우의 수

        for (int t = 0; t < N+1; t++) {
            dp[1][t]=1;
        }

        for (int i = 2; i < K+1; i++) {
            for (int j = 0; j < N+1; j++) {
                for (int z = 0; z < j+1; z++) {
                    dp[i][j]+=dp[i-1][z];
                }
                dp[i][j]%=mod;

            }
        }
        System.out.println(dp[K][N]);
    }
}
