import java.util.Scanner;

public class BackJoon11052 {

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);

        int N=scan.nextInt();

        int[] card=new int[N+1];
        for(int i=1; i<=N; i++){
            card[i]=scan.nextInt();
        }

        int[] dp=new  int[N+1];

        for(int i=1; i<=N;i++){
            for(int j=1; j<=i; j++){
                dp[i]=Math.max(dp[i],dp[i-j]+card[j]);

            }
        }
        System.out.println(dp[N]);
    }
}
