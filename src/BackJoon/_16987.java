package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16987 {

    public static int N;
    public static int answer;
    public static int[] eggD, eggW;
    public static void checking(int point){
        if(point==N){
            int count=0;
            for (int a = 0; a < N; a++) {
                if(eggD[a]<=0) count++;

            }
            answer=Math.max(count,answer);
            return;
        }
        if (eggD[point]<=0){
            checking(point+1);
        }
        else{
            boolean flag=false;
            for (int a = 0; a < N; a++) {
                if(a==point || eggD[a]<=0) continue;
                flag=true;
                eggD[a]-=eggW[point];
                eggD[point]-=eggW[a];
                checking(point+1);
                eggD[a]+=eggW[point];
                eggD[point]+=eggW[a];
            }
            if(!flag){
                checking(point+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        eggD=new int[N];
        eggW=new int[N];
        answer=0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            eggD[i]=Integer.parseInt(st.nextToken());
            eggW[i]=Integer.parseInt(st.nextToken());
        }
        checking(0);
        System.out.println(answer);
    }
}
