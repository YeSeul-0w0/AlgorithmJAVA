package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10830 {
    public static int N;
    public static long B;
    public static int[][] arr;

    public static int[][] matrix(int[][] t, long value){
        if (value==1){
            return t;
        }

        long mid=value/2;

        int[][] result=matrix(t, mid);
        result=multiply(result,result);

        if (value%2==1){
            result=multiply(result,arr);
        }

        return result;
    }

    public static int[][] multiply(int[][] arr1, int[][]arr2){
        int[][] temp=new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    temp[i][j]+=arr1[i][k] * arr2[k][j];
                    temp[i][j]%=1000;
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        B=Long.parseLong(st.nextToken());
        
        arr=new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer arrSt=new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j]=Integer.parseInt(arrSt.nextToken())%1000;
            }
        }

        int answer[][]=matrix(arr,B);

        String string="";
        for (int a = 0; a < N; a++) {
            for (int b = 0; b < N; b++) {
                string+=String.valueOf(answer[a][b]);
                string+=" ";
            }
            string+="\n";
        }
        System.out.println(string);
    }
}
