package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4963{
    public static int W,H;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx={-1,1,0,0,1,1,-1,-1};
    public static int[] dy={0,0,-1,1,1,-1,1,-1};
    public static int count;
    
    public static void bfs(int x, int y){
        Queue<Pair> que=new LinkedList<>();
        que.add(new Pair(x,y));
        visited[x][y]=true;
        while (!que.isEmpty()) {
            Pair values=que.poll();
            int px=values.x;
            int py=values.y;
            for (int i = 0; i < 8; i++) {
                int nx=px+dx[i];
                int ny=py+dy[i];
                if (nx<0 || ny<0 || nx>=H || ny>=W) continue;
                if (!visited[nx][ny] && map[nx][ny]==1){
                    visited[nx][ny]=true;
                    que.add(new Pair(nx,ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true){
            st=new StringTokenizer(br.readLine());
            W=Integer.parseInt(st.nextToken());
            H=Integer.parseInt(st.nextToken());
            if (W==0 && H==0){
                break;
            }

            else{
                map=new int[H][W];
                visited=new boolean[H][W];
                count=0;
                for (int i = 0; i < H; i++) {
                    st=new StringTokenizer(br.readLine());
                    for (int j = 0; j < W; j++) {
                        map[i][j]=Integer.parseInt(st.nextToken());
                    }
                }
                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        if (!visited[i][j] && map[i][j]==1){
                            bfs(i,j);
                            count++;
                        }
                    }
                }
                System.out.println(count);
            }

        }
    }

    public static class Pair{
        int x,y;
        Pair(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}
