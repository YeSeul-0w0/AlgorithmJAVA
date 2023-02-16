package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numList = new int[N+1];
        StringTokenizer num = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            if (i > 1){
                numList[i] = numList[i-1] + Integer.parseInt(num.nextToken());
            }
            else{
                numList[i] = Integer.parseInt(num.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer range = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(range.nextToken());
            int B = Integer.parseInt(range.nextToken());
            System.out.println(numList[B] - numList[A-1]);

        }
    }
}
