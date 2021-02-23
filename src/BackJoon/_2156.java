import java.util.Scanner;

public class _2156 {

    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);

        int N=scanner.nextInt();

        int[] number=new int[N+2];
        for(int i=1; i<=N; i++){
            number[i]=scanner.nextInt();
        }

        int[] dp=new int[10002];
        dp[1]=number[1];
        dp[2]=Math.max(number[1]+number[2], number[2]);

        for(int i=3;i<=N;i++) {
            dp[i] = Math.max(dp[i-2] + number[i], dp[i-3] + number[i-1]+number[i]);
            dp[i]=Math.max(dp[i-1],dp[i]);
        }

        System.out.println(dp[N]);
    }
}
