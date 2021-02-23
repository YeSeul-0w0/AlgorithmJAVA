import java.util.Scanner;

public class _1904 {

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int N=scan.nextInt();

        int[] dp=new int[10000001];

        dp[1]=1;
        dp[2]=2;

        for(int i=3; i<=N; i++){
            dp[i]=(dp[i-1]+dp[i-2])%15746;
        }

        System.out.println(dp[N]);
    }
}
