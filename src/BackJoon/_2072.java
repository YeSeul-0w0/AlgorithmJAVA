package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2072 {

    public static int[][] board=new int[21][21];
    public static Boolean checking(int x, int y, int color){
        int c1=0;
        for (int i = 0; board[x+i][y]==color; i++) {
                c1++;
        }
        for (int i = 1; board[x-i][y]==color; i++) {
                c1++;
        }
        if (c1==5){
            return true;
        }

        int c2=0;
        for (int i= 0; board[x][y+i]==color; i++) {
                c2++;
        }
        for (int i = 1; board[x][y-i]==color; i++) {
                c2++;
        }
        if(c2==5){
            return true;
        }

        int c3=0;
        for (int i = 0; board[x+i][y+i]==color; i++) {
                c3++;
        }
        for (int i = 1; board[x-i][y-i]==color; i++) {
                c3++;

        }
        if(c3==5){
            return true;
        }

        int c4=0;
        for (int i = 0; board[x-i][y+i]==color; i++) {
                c4++;
        }
        for (int i = 1; board[x+i][y-i]==color; i++) {
                c4++;
        }
        if(c4==5){
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        int point=-1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (i % 2 == 0) {
                board[x][y] = 2; //백=2
            } else {
                board[x][y] = 1; //흑=1
            }

            if(checking(x,y,board[x][y])){
                point=i+1;
                break;
            }

        }
        System.out.println(point);
    }
}
