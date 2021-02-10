import java.util.Scanner;

public class BackJoon9095 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int N=scan.nextInt();

        int[] dp=new int[12];

        for(int j=0; j<N; j++){
            int temp=scan.nextInt();
            dp[0]=1;
            dp[1]=1;
            dp[2]=2;
            dp[3]=4;
            for(int i=4; i<=temp; i++){
                dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
            }
            System.out.println(dp[temp]);
        }


    }
}
