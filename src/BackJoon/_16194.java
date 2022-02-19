package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16194 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());

        int[] card=new int[N+1];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int a = 1; a < N+1; a++) {
            card[a]=Integer.parseInt(st.nextToken());
        }

        int[] dp=new int[N+1];
        for (int i = 1; i <= N; i++) {
            dp[i]=card[i];
            for (int j = 1; j <= i ; j++) {
                // 2장 사고 싶음 = 1장 2개 or 2장 1개
                // 3장 사고 싶음 = 1장 * 3개
                dp[i]=Math.min(dp[i],dp[i-j]+card[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
