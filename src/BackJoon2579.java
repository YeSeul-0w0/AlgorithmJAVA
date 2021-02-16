import java.util.Scanner;

public class BackJoon2579 {

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);

        int N=scan.nextInt();

        int[] number=new int[N+2];
        for(int a=1; a<=N; a++){
            number[a]=scan.nextInt();
        }

        int[] dp=new int[302];
        dp[1]=number[1];
        dp[2]=Math.max(number[1]+number[2], number[2]);

        for(int i=3;i<=N;i++) {
            dp[i] = Math.max(dp[i-2] + number[i], dp[i-3] + number[i] + number[i-1]);
        }
        System.out.println(dp[N]);
    }
}
