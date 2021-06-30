package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class _6198 {

    public static void main(String[] agrs) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        long[] height=new long[N+1];

        for(int i=0; i<N; i++){
            height[i]=Long.parseLong(br.readLine());
        }

        long answer=0;

        for (int a=0; a<N; a++){
            long count=0;
            for(int b=a+1; b<N; b++){
                if(height[a]>height[b]){
                    count++;
                }
                else{
                    break;
                }
            }
            answer+=count;
        }

        System.out.println(answer);
    }
}
