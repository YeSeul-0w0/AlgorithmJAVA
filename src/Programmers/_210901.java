package Programmers;

public class _210901 {
    public static int[][] connection;
    public static int[][] dp;
    public static int answer;

    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        answer = 0;

        connection = new int[n + 1][n + 1];
        for (int a = 0; a < m; a++) {
            connection[edge_list[a][0]][edge_list[a][1]] = 1;
            connection[edge_list[a][1]][edge_list[a][0]] = 1;
        }

        dp = new int[k + 1][n + 1];


        int INF = 201;

        for (int b = 0; b < k + 1; b++) {
            for (int c = 0; c < n + 1; c++) {
                dp[b][c] = INF;
            }
        }

        dp[0][gps_log[0]] = 0;


        for (int i = 1; i < k; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                for (int z = 1; z < n + 1; z++) {
                    if (connection[j][z] == 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][z]);
                    }
                }
                if (j != gps_log[i]) {
                    dp[i][j]++;
                }
            }
        }
        if (dp[k - 1][gps_log[k - 1]] < INF) {
            return dp[k - 1][gps_log[k - 1]];
        } else {
            return -1;
        }
    }


    public static void main(String[] args) {
        _210901 test = new _210901();

        test.solution(7, 10, new int[][]{{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}},
                6, new int[]{1, 2, 3, 3, 6, 7});
    }
}

