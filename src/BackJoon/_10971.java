package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10971 {
    public static int[][] city;
    public static int N;
    public static boolean[] visited;
    public static int result=Integer.MAX_VALUE;

    public static void path(int start,int idx, int pay, int count){
        if (count==N){
            if(city[idx][start]>0){
                pay+=city[idx][start];
                if(result>pay){
                    result=pay;
                }
            }
            return;
        }
        for (int z = 1; z < N+1; z++) {
            if(!visited[z] && city[idx][z]>0){
                visited[z]=true;
                path(start, z,pay+city[idx][z],count+1);
                visited[z]=false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        city=new int[N+1][N+1];
        for (int a = 1; a < N+1; a++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int b = 1; b < N+1; b++) {
                city[a][b]=Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N+1; i++) {
            visited=new boolean[N+1];
            visited[i]=true;
            for (int j = 1; j < N+1; j++) {
                if(!visited[j] && city[i][j]>0){
                    visited[j]=true;
                    path(i, j,city[i][j],2);
                }

            }
        }

        System.out.println(result);
    }
}
