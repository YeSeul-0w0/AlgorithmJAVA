package Programmers;


public class _211201 {

    public static int MOD = 20170805;
    public static int solution(int m, int n, int[][] cityMap) {
        int[][][] dp=new int[m][n][2];
        int answer = 0;
        if(cityMap[0][0]==1){
            return 0;
        }

        dp[0][0][0]=1;
        dp[0][0][1]=1;

        // 0: 세로 , 1 : 가로
        for (int i = 1; i < m; i++) {
            if(cityMap[i][0]!=1){ // 최단거리로 이동하는 방법의 수 구하기
                dp[i][0][0]=dp[i-1][0][0];
            }
        }
        for (int j = 1; j < n; j++) {
            if(cityMap[0][j]!=1){ // 최단거리로 이동하는 방법의 수 구하기
                dp[0][j][1]=dp[0][j-1][1];
            }
        }

        for (int a = 1; a < m; a++) {
            for (int b = 1; b < n; b++) {
                // 1. 세로검사
                if(cityMap[a-1][b]!=1){
                    if(cityMap[a-1][b]==2){ // 아래로 오는 것만 얻을 수 있음
                        dp[a][b][0]=dp[a-1][b][0];
                    }
                    else{ // 왼쪽 + 아래 둘다 가능
                        dp[a][b][0]=(dp[a-1][b][0]+dp[a-1][b][1])%MOD;
                    }
                }

                // 2. 가로검사
                if(cityMap[a][b-1]!=1){
                    if(cityMap[a][b-1]==2){ // 왼쪽으로 오는 것만 얻을 수 있음음
                         dp[a][b][1]=dp[a][b-1][1];
                    }
                    else{
                        dp[a][b][1]=(dp[a][b-1][0]+dp[a][b-1][1])%MOD;
                    }
                }
            }
        }

        answer=(dp[m-1][n-1][0]+dp[m-1][n-1][1])%MOD;
        return answer;
    }



    public static void main(String[] args) {
        _211201 test=new _211201();
        System.out.println(test.solution(3,3,new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
    }
}
