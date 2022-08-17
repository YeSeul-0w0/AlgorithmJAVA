package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1285 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        char [][]coinList=new char[N][N];

        for(int i=0;i<N;i++){
            coinList[i]=br.readLine().toCharArray();
        }

        int answer = Integer.MAX_VALUE;
        for (int bit = 0; bit < (1<<N); bit++) {
            int sum=0;
            for(int j=0; j<N; j++) {
                int count = 0;
                //행
                for (int i = 0; i < N; i++) {
                    char curr = coinList[i][j];
                    if((bit & (1<<i)) != 0) {
                        // 1일 때 가로 뒤집기
                        curr = reverse(curr);
                    }
                    // 세로 줄에 T의 개수를 세고
                    if(curr == 'T')
                        count++;
                }
                // count = 현재 T의 개수
                // N-count = 현재 H의 개수 = 뒤집을 때 T의 개수
                // 둘 중 작은걸 select > 그리드
                // 즉 세로를 뒤집을 지 말지 결정
                sum += Math.min(count, N-count);
            }
            // 한 경우의 수에 대해 ( 001, 100 etc)
            // 최소로 나올 수 있는 T의 수
            answer = Math.min(answer, sum);
        }
        System.out.println(answer);
    }

    public static char reverse(char curr) {
        if(curr == 'T')
            return 'H';
        else
            return 'T';
    }
}