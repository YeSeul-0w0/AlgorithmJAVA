package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2630 {
    public static int[][] board;
    public static int whiteCount;
    public static int blueCount;

    public static boolean colorChecking(int start, int end, int size){

        int color = board[start][end];

        for (int i = start; i < start+size; i++) {
            for (int j = end; j < end+size; j++) {
                if(board[i][j]!=color){
                    return false;
                }
            }
        }
        return true;
    }

    public static void searching(int start, int end, int size){
        if (colorChecking(start,end,size)){
            if(board[start][end]==0){
                whiteCount++;
            }
            else{
                blueCount++;
            }

            return;
        }

        int mid=size/2;
        searching(start,end,mid); // 2사분면
        searching(start,end+mid,mid); // 1사분면
        searching(start+mid,end,mid); // 3사분면
        searching(start+mid,end+mid,mid); //4사분면
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        board=new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        searching(0,0,N);

        System.out.println(whiteCount);
        System.out.println(blueCount);

    }
}
