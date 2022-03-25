package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178 {
    public static int N,M;
    public static int[][] map;
    public static int[] dx={-1,1,0,0};
    public static int[] dy={0,0,-1,1};
    public static boolean[][] visited;
    public static void bfs(int x,int y){
        Queue<Pair> que=new LinkedList<>();
        que.add(new Pair(x,y));
        visited[x][y]=true;
        while (!que.isEmpty()){
            Pair values=que.poll();
            int px=values.x;
            int py=values.y;
            for (int i = 0; i < 4; i++) {
                int nx=px+dx[i];
                int ny=py+dy[i];
                if (nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if (map[nx][ny]==1 && visited[nx][ny]==false){
                    visited[nx][ny]=true;
                    que.add(new Pair(nx,ny));
                    map[nx][ny]+=map[px][py];
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new int[N][M];
        for (int i = 0; i < N; i++) {
            String word=br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j]=Integer.parseInt(String.valueOf(word.charAt(j)));
            }
        }
        visited=new boolean[N][M];
        bfs(0,0);
        System.out.println(map[N-1][M-1]);

    }
    public static class Pair{
        int x,y;

        Pair(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }

}
