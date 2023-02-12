package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1563 {
    // 처음 생각 로직
    // dp [1][0] > 1일 마지막 출결이 O
    // dp [1][1] > 1일 마지막 출결이 L
    // dp [1][2] > 1일 마지막 출결이 A
    public static int N;
    public static int[][][] dp;
    public static int mod =  1000000;

    public static int check(int day, int late, int absent){
        if (late >= 2 ||  absent >= 3){
            return 0;
        }

        if (day==N){
            return 1;
        }

        if (dp[day][late][absent] == 0){
            int attend = (check(day+1, late, 0) + check(day+1, late+1, 0) + check(day+1,late,absent+1)) % mod;
            // check(day+1, late, 0) = 정상 출결 결석 초기화
            // 왜 결석 초기화? 연속으로 3번인 경우를 세니까. 결석이 아닌 다른 출결을 할 경우 초기화
            // check(day+1, late+1, 0) = 지각, 결석 초기화
            // check(day+1, late, absent+1) = 결석
            dp[day][late][absent] = attend;
            return attend;
        }

        else{
            return dp[day][late][absent];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[1001][2][3];
        // index 1 > 날짜
        // index 2 > 지각 확인
        // index 3 > 결석 확인

        System.out.println(check(0,0,0) % mod);

    }
}
