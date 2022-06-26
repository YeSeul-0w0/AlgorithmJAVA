package Programmers;

public class _220629 {
    public int[] dx = {0, 0, 1, -1};
    public int[] dy = {1, -1, 0, 0};

    public int answer;
    public int max = 10_000_000;

    public class checkResult { // 승패 판단
        boolean win;
        int count;

        public checkResult(boolean win, int count) {
            this.win = win;
            this.count = count;
        }
    }

    public checkResult dfs(int[][] board, int[] aloc, int[] bloc, int turn, int move) {
        int ax = aloc[0];
        int ay = aloc[1];

        int bx = bloc[0];
        int by = bloc[1];

        // a 턴일 때 a가 짐 || b턴인데 b가 짐 (패배조건이라는데 잘 모르겠음)
        if (turn > 0 && board[ax][ay] == 0 || (turn < 0 && board[bx][by] == 0)) {
            return new checkResult(false, move);
        }

        int winner = max;
        int loser = 0;

        for (int i = 0; i < 4; i++) {
            if (turn > 0) {
                int nax = ax + dx[i];
                int nay = ay + dy[i];

                // index of out range
                if (nax < 0 || nax >= board.length || nay < 0 || nay >= board[0].length) continue;

                // 발판 없음
                if (board[nax][nay] == 0) continue;

                board[ax][ay] = 0;

                // 왜 -turn 하는지 모르겠음
                checkResult nextTurn = dfs(board, new int[]{nax, nay}, bloc, -turn, move + 1);

                if(nextTurn.win==false){
                    winner=Math.min(winner,nextTurn.count);
                }
                else{
                    loser=Math.max(loser, nextTurn.count);
                }

                board[ax][ay]=1;
            }
            // Turn b
            else{
                int nbx=bx+dx[i];
                int nby=by+dy[i];

                if(nbx<0 || nbx>=board.length || nby<0 || nby>=board[0].length) continue;

                if (board[nbx][nby]==0) continue;

                board[bx][by]=0;

                checkResult nextTurn = dfs(board, aloc, new int[] {nbx,nby},-turn, move+1);

                if (nextTurn.win==false){
                    winner=Math.min(winner, nextTurn.count);
                }
                else{
                    loser=Math.max(loser, nextTurn.count);
                }

                board[bx][by]=1;
            }
        }

        // 더는 움직일 수 없을때 현재까지 움직인 값 반환
        if (winner==max && loser==0){
            return new checkResult(false, move);
        }

        // 이겼을 때 최저값 반환
        else if (winner != max){
            return new checkResult(true, winner);
        }

        // 졌을 때 최대값 반환
        else{
            return new checkResult(false,loser);
        }
    }

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        checkResult result = dfs(board, aloc, bloc, 1, 0);
        return result.count;
    }
}
