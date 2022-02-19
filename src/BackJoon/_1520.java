package BackJoon;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1520 {

    public static int[] dx={-1,1,0,0};
    public static int[] dy={0,0,-1,1};

    public static int N,M;
    public static int[][] infoMap;
    public static int[][] dp;
    public static boolean[][] visited;

    public static void bfs(int x, int y, int h){
        PriorityQueue<Pair> que=new PriorityQueue<>();
        que.add(new Pair(x,y,h));
        visited[x][y]=true;
        while (!que.isEmpty()){
            Pair temp=que.poll();
            int px=temp.x;
            int py=temp.y;
            for (int i = 0; i < 4; i++) {
                int nx=px+dx[i];
                int ny=py+dy[i];
                if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
                if(infoMap[nx][ny]>=infoMap[px][py]) continue;
                dp[nx][ny]+=dp[px][py];
                if (visited[nx][ny]) continue;
                visited[nx][ny]=true;
                que.add(new Pair(nx,ny,infoMap[nx][ny]));
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        dp=new int[M][N];
        visited=new boolean[M][N];
        infoMap=new int[M][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer info=new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                infoMap[j][i]=Integer.parseInt(info.nextToken());
            }
        }
        dp[0][0]=1;
        bfs(0,0,infoMap[0][0]);

//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.println(dp[i][j]);
//            }
//        }
        bw.write(String.valueOf(dp[M-1][N-1]));
        br.close();
        bw.flush();
    }

    public static class Pair implements Comparable<Pair>{
        int x,y,height;
        Pair(int x, int y, int height){
            this.x=x;
            this.y=y;
            this.height=height;
        }

        @Override
        public int compareTo(Pair o) {
            return o.height-this.height;
        }
    }

}
