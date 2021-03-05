package BackJoon;

import java.util.Scanner;

public class _1912 {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        int N=scanner.nextInt();

        int[] num_list=new int[N+2];
        for(int a=1; a<=N; a++){
            num_list[a]= scanner.nextInt();
        }

        long[] dp=new long[100002];
        dp[1]=num_list[1];
        for(int i=2; i<=N; i++){
            dp[i]=Math.max(num_list[i],dp[i-1]+num_list[i]);
        }

        long ans=-1001;
        for(int j=1; j<=N; j++){
            if(ans<dp[j]) ans=dp[j];
        }

        System.out.println(ans);
    }
}
