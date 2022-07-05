package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1079 {
    public static int N;
    public static int[] guiltyValues;
    public static int[][] board;
    public static int mafia;
    public static boolean[] dead;
    public static int answer = 0;

    public static void whoNext(int time, int remain){
        // day (가장 죄가 있을 시민을 죽임)
        if (remain%2==1){
            int max=-1;
            int maxIdx=-1;
            for (int i = 0; i < N; i++) {
                if (!dead[i]){
                    if(max<guiltyValues[i]){
                        max=guiltyValues[i];
                        maxIdx=i;
                    }
                }
            }
            // 마피아의 죽음
            if (maxIdx==mafia){
                answer=Math.max(answer,time);
                return;
            }

            dead[maxIdx]=true;
            whoNext(time,remain-1);
            dead[maxIdx]=false;
        }
        else{
            // night (마피아가 사람을 한 명 죽임)
            // case 1. 시민 1명, 마피아 1명
            if(remain==2){
                answer=Math.max(answer,time+1);
                return;
            }
            // 아닌 경우, 마피아는 죽일 상대를 찾는다.
            for (int i = 0; i < N; i++) {
                if (i==mafia) continue;

                if (!dead[i]){
                    dead[i]=true;
                    // 유죄 지수 변경
                    for (int j = 0; j < N; j++) {
                        guiltyValues[j]+=board[i][j];
                    }

                    whoNext(time+1,remain-1);

                    // 유죄 지수 롤백
                    for (int h = 0; h < N; h++) {
                        guiltyValues[h]-=board[i][h];
                    }

                    dead[i]=false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        guiltyValues=new int[N];
        StringTokenizer guilty=new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            guiltyValues[i]=Integer.parseInt(guilty.nextToken());
        }

        board=new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer values=new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j]=Integer.parseInt(values.nextToken());
            }
        }

        mafia =Integer.parseInt(br.readLine());

        dead=new boolean[N];

        whoNext(0,N);
        System.out.println(answer);
    }
}
