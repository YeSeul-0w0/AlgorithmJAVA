
import java.util.Scanner;

public class BackJoon1003 {

    public static int[][] fibonacci=new int[41][2];
    public static int N;


    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        N = scan.nextInt();

        fibonacci[0][0]=1;
        fibonacci[1][1]=1;


        for (int a=2; a<41; a++){
            for (int b=0; b<2; b++){
                fibonacci[a][b]=fibonacci[a-1][b]+fibonacci[a-2][b];
            }
        }

        for (int j=0; j<N; j++){
            int temp = scan.nextInt();
            System.out.println(fibonacci[temp][0]+" "+fibonacci[temp][1]);
        }
        scan.close();
    }
}
