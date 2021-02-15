import java.util.Scanner;

public class BackJoon1149 {

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);

        int N= scan.nextInt();

        int[][] dp=new int[1002][3];
        int[][] RGB=new int[N+2][4];
        for(int i=1; i<=N; i++){
            for(int j=0; j<3; j++){
                RGB[i][j]=scan.nextInt();
            }
        }


        for(int a=1; a<=N; a++){
            for(int b=0; b<3; b++){
                if(b==0){ //R
                    dp[a][b]=RGB[a][b]+Math.min(dp[a-1][1],dp[a-1][2]);
                }
                else if(b==1){ //G
                    dp[a][b]=RGB[a][b]+Math.min(dp[a-1][0],dp[a-1][2]);

                }
                else if(b==2){ //B
                    dp[a][b]=RGB[a][b]+Math.min(dp[a-1][0],dp[a-1][1]);
                }
            }
        }
        int ans=dp[N][0];
        for (int c=1; c<3; c++){
            if(ans>dp[N][c]){
                ans=dp[N][c];
            }
        }
        System.out.println(ans);


        scan.close();
    }
}
