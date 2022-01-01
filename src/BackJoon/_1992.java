package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1992 {

    public static int[][] quadTree;
    public static String answer;

    public static boolean zeroOne(int x, int y, int size){
        int point=quadTree[x][y];

        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (point!=quadTree[i][j]) return false;
            }
        }
        return true;
    }

    public static void checking(int x, int y, int size){
        if(zeroOne(x,y,size)){
            int zip=quadTree[x][y];
            answer+=String.valueOf(zip);
            return;
        }

        answer+="("; //재귀의 시작점, 여는 괄호로 시작
        int mid=size/2;
        checking(x,y,mid);
        checking(x,y+mid,mid);
        checking(x+mid,y,mid);
        checking(x+mid, y+mid, mid);
        answer+=")"; // 재귀의 끝, 닫는 괄호로 마무리

    }
    public static void main(String[] args) throws IOException {
        answer="";

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        quadTree=new int[N][N];

        for (int i = 0; i < N; i++) {
            String str=br.readLine();
            for (int j = 0; j < N; j++) {
                quadTree[i][j]=str.charAt(j)-'0'; // 숫자로 변환
            }
        }

        checking(0,0,N);
        System.out.println(answer);

    }
}
