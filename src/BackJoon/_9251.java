package BackJoon;

import java.util.Scanner;

public class _9251 {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);


        char[] A=scanner.nextLine().toCharArray();
        char[] B=scanner.nextLine().toCharArray();

        int[][] dp=new int[1002][1002];

        for(int i=1; i<=A.length; i++){
            for(int j=1; j<=B.length; j++){
                if(A[i-1]==B[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }

        System.out.println(dp[A.length][B.length]);
        scanner.close();
    }
}
