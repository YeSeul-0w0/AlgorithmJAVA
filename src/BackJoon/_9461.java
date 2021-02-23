import java.util.Scanner;

public class _9461 {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        long [] dp=new long[101];
        dp[1]=1;
        dp[2]=1;
        dp[3]=1;
        dp[4]=2;
        dp[5]=2;

        for(int a=0; a<N; a++){
            int number= scanner.nextInt();
            for(int b=6; b<=number; b++){
                dp[b]=dp[b-1]+dp[b-5];
            }
            System.out.println(dp[number]);
        }
    }
}
