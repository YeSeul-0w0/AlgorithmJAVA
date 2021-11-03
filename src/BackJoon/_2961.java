package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2961 {

    public static int N;
    public static int[][] ph;
    public static int result;

    public static void testing(int index, int p, int h){
        if(index==N){
            if(h!=0){ // 처음 h가 0인데, 이게 유지된체로 index만 늘어나는 경우가 생김
                result=Math.min(result,Math.abs(p-h));
            }
            return;
        }
        testing(index+1,p*ph[index][0],h+ph[index][1]);
        testing(index+1,p,h);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        ph=new int[N][2];
        result=Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            ph[i][0]=Integer.parseInt(st.nextToken());
            ph[i][1]=Integer.parseInt(st.nextToken());
        }

        testing(0,1,0);
        System.out.println(result);
    }
}
