package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2072 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        int[][] board=new int[20][20];
        int point=0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            if(i%2==0){
                board[x][y]=2; //백=2
            }
            else{
                board[x][y]=1; //흑=1
            }

            if(i>=8){
                int r_count=1; // 가로 카운트 B
                int c_count=1; // 세로 카운트 C
                int d_count=1; // 대각선 카운트
                int max_r=0;
                int max_c=0;
                int max_d=0;
                for (int a = 1; a < 20; a++) {
                    if(a+1<15){
                        if(board[a][a]!=0 && board[a][a]==board[a+1][a+1]){
                            d_count++;
                        }
                        else{
                            max_d=Math.max(d_count, max_d);
                            d_count=1;
                        }
                    }

                    for (int b = 1; b < 19; b++) {
                        if(board[a][b]!=0 && board[a][b]==board[a][b+1]){
                            r_count++;
                        }
                        else{
                            max_r=Math.max(r_count,max_r);
                            r_count=1;
                        }
                    }
                    for (int c = 1; c < 19; c++) {
                        if(board[c][a]!=0 && board[c][a]==board[c+1][a]){
                            c_count++;
                        }
                        else{
                            max_c=Math.max(c_count,max_c);
                            c_count=1;
                        }
                    }
                }
                if(max_d==5||max_r==5 || max_c==5){
                    point=i+1;
                    break;
                }
            }
        }

        if(point==0){
            System.out.println(-1);
        }
        else{
            System.out.println(point);
        }
    }
}
