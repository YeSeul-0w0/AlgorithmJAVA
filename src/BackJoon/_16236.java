package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16236 {

    public static int N;
    public static int total_count, eat_count;
    public static int[][] ocean,dist;
    public static int X_baby, Y_baby,S_baby;
    public static int X_min, Y_min, D_min;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void bfs(int x,int y){
        Queue<Coordinates> que=new LinkedList<>();

        que.add(new Coordinates(x,y));

        while (!que.isEmpty()){
            Coordinates check=que.poll();

            for (int a = 0; a < 4; a++) {
                int nx=check.x+dx[a];
                int ny=check.y+dy[a];

                if (nx<=N && ny<=N && nx>=1 && ny>=1){ //범위 밖으로 나갔는가?
                    if(ocean[nx][ny]<=S_baby && dist[nx][ny]==0){ // 아기상어가 지나갈 수 있는가?
                        dist[nx][ny]=dist[check.x][check.y]+1;

                        if(ocean[nx][ny]!=0 &&ocean[nx][ny]<S_baby){ // 아기 상어가 먹을 수 있는가?
                            if(D_min>dist[nx][ny]){ // 최소거리값이 현재 위치의 거리값보다 크면
                                D_min=dist[nx][ny];
                                X_min=nx;
                                Y_min=ny;
                            }
                            else if(D_min == dist[nx][ny]){ //최저 거리값이 현재의 위치와 같으면
                                if(X_min>nx){ // 위쪽이 우선권을 가지니 위쪽부터
                                    X_min=nx;
                                    Y_min=ny;
                                }
                                else if(X_min==nx){  // 같은 선상에 있으면
                                    if(Y_min>ny) { // 왼쪽이 우선권을 가지니 왼쪽 부터
                                        X_min = nx;
                                        Y_min = ny;
                                    }
                                }
                            }
                        }

                        que.add(new Coordinates(nx,ny));

                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());

        ocean=new int[N+1][N+1];
        dist=new int[N+1][N+1];

        S_baby=2;
        total_count=0;
        eat_count=0;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                ocean[i][j]=Integer.parseInt(st.nextToken());
                if (ocean[i][j]==9){
                    X_baby=i;
                    Y_baby=j;
                    ocean[i][j]=0;
                }
            }
        }

        while (true){
            dist=new int[N+2][N+2];
            X_min=23;
            Y_min=23;
            D_min=Integer.MAX_VALUE;

            bfs(X_baby,Y_baby); // 먹을 수 있는 곳을 찾아감

            if (X_min!=23 && Y_min!=23){
                eat_count++;
                ocean[X_min][Y_min]=0;
                X_baby=X_min;
                Y_baby=Y_min;
                total_count+=dist[X_min][Y_min];

                if(eat_count==S_baby){
                    S_baby++;
                    eat_count=0;
                }
            }

            else{
                break;
            }
        }

        System.out.println(total_count);

    }

    private static class Coordinates {
        private int x;
        private int y;

        private Coordinates(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
