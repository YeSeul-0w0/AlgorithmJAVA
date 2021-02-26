package BackJoon;

import java.util.Scanner;

public class _11053 {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int[] A=new int[N+2];
        for(int i=1; i<=N; i++){
            A[i]=scanner.nextInt();
        }

        int[] dp=new int[1002];
        dp[1]=1;

        for(int a=2; a<=N; a++){
            dp[a]=1;
            for(int b=a-1; b>=1; b--){
                if(A[a]>A[b]){
                    dp[a]=Math.max(dp[a],dp[b]+1);
                }
            }
        }
        int ans=0;
        for (int j=1; j<=N; j++){
            if(ans<dp[j]){
                ans=dp[j];
            }
        }
        System.out.println(ans);
    }
}
