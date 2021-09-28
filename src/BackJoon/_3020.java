package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int H=Integer.parseInt(st.nextToken());

        int[] bottom=new int[H+1];
        int[] top=new int[H+1];

        for (int i = 0; i < N; i++) {
            if (i%2==0){
                bottom[Integer.parseInt(br.readLine())]++;
            }
            else{
                top[Integer.parseInt(br.readLine())]++;
            }
        }

        for (int j = H-1; j > 0; j--) {
            bottom[j]+=bottom[j+1];
            top[j]+=top[j+1];
        }

        int min=N;
        int count=0;

        for (int z = 1; z <H+1 ; z++) {
            int temp=bottom[z]+top[H-z+1];
            if (min>temp){
                min=bottom[z]+top[H-z+1];
                count=1;
            }
            else if (min==temp){
                count++;
            }
        }

        System.out.println(min+" "+count);
     }
}
