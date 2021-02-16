import java.util.Scanner;

public class BackJoon10844 {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        int N=scanner.nextInt();

        long[][] dp=new long[N+1][10];

        for(int i=1; i<10; i++){
            dp[1][i]=1;
        }

        for(int i=2; i<=N; i++){
            for(int j=0; j<=9; j++){
                if(j==0){
                    dp[i][j]+=dp[i-1][j+1];

                }
                else if(j==9){
                    dp[i][j]+=dp[i-1][j-1];

                }
                else{
                    dp[i][j]+=dp[i-1][j-1]+dp[i-1][j+1];

                }
                dp[i][j]%=1000000000;
            }
        }

        long ans=0;
        for(int i=0;i<10; i++){
            ans+=dp[N][i];
        }

        System.out.println(ans%1000000000);
        scanner.close();
    }
}
