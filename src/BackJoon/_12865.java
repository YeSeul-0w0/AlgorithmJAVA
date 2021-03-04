package BackJoon;

import java.util.Scanner;

public class _12865 {

    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);

        int N=scanner.nextInt();
        int K=scanner.nextInt();

        int[] weight=new int[N+2];
        int[] value=new int[N+2];

        for(int a=1; a<=N; a++) {
            weight[a] = scanner.nextInt();
            value[a] = scanner.nextInt();
        }

        int[][] dp=new int[102][100002];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                if(j-weight[i]>=0){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                }
                else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
