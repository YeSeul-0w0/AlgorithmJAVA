package BackJoon;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _2565 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer=new StringTokenizer(reader.readLine());

        int N=Integer.parseInt(tokenizer.nextToken());

        int[][] num_list=new int[N][2];
        for(int i=0; i<N; i++){
            tokenizer=new StringTokenizer(reader.readLine());
            for(int j=0; j<2; j++){
                num_list[i][j]=Integer.parseInt(tokenizer.nextToken());
            }
        }

        Arrays.sort(num_list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] dp=new int[501];

        for(int i=0; i<N; i++){
            dp[i]=1;
            for(int j=0; j<i; j++){
                if(num_list[i][1]>num_list[j][1]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int ans=0;
        for(int z=0; z<N; z++){
            if(ans<dp[z]){
                ans=dp[z];
            }
        }

        System.out.println(N-ans);
    }
}
