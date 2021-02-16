import java.util.Scanner;

public class BackJoon15990 {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        int N=scanner.nextInt();
        int[] number=new int[N];

        int[][] dp=new int[N+2][4];

        for(int a=0; a<N;a++){
            int temp=scanner.nextInt();
            for(int i=1; i<=temp; i++){
                if(i>3){
                    dp[i][1]=dp[i-1][2]+dp[i-1][3];
                    dp[i][2]=dp[i-1][1]+dp[i-1][3];
                    dp[i][3]=dp[i-1][1]+dp[i-1][2];
                }
                else if(i==1){
                    dp[i][1]=1;
                }
                else if(i==2){
                    dp[i][2]=1;
                }
                else if(i==3){
                    dp[i][3]=1;
                }


            }

        }




        scanner.close();
    }

}
