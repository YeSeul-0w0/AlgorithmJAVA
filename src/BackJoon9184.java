import java.util.Scanner;

public class BackJoon9184 {
    public static int A,B,C;
    public static int[][][] dp=new int[21][21][21];

    public static int w(int a, int b, int c){
        if (0<=a && a<=20 && 0<=b && b<=20 && 0<=c && c<=20){
            if (dp[a][b][c]!=0)
                return dp[a][b][c];
        }
        if(a<=0 || b<=0 || c<=0)
            return 1;
        if(a>20 || b>20 || c>20)
            return dp[20][20][20]= w(20,20,20);
        if (a<b && b<c)
            return dp[a][b][c]=w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
        else
            return dp[a][b][c]=w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);

    }


    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while (true) {
            A=scan.nextInt();
            B=scan.nextInt();
            C=scan.nextInt();
            if (A==-1 && B==-1 && C==-1)
                break;
            else
                System.out.println("w("+A+", "+B+", "+C+") = "+w(A,B,C));
        }
        scan.close();
    }
}
