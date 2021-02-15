import java.util.Scanner;

public class BackJoon1932 {

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);

        int N=scan.nextInt();

        int[][] tran=new int[502][502];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++){
                tran[i][j]=scan.nextInt();
            }
        }

        int [][] dp=new int[502][502];
        dp[1][1]=tran[1][1];
        for(int a=2; a<=N; a++){
            for(int b=1; b<=a; b++){
                dp[a][b]=tran[a][b]+Math.max(dp[a-1][b], dp[a-1][b-1]);
            }
        }

        int max_num=0;
        for(int c=1; c<=N; c++){
            max_num=Math.max(max_num,dp[N][c]);
        }
        System.out.println(max_num);
    }
}
