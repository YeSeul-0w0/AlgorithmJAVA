package Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class _230322 {
    public boolean[] visited;
    public boolean bfs(int start, int n, int[][] computer){
        Deque<Integer> que = new ArrayDeque<>();
        que.add(start);
        visited[start] = true;
        while(!que.isEmpty()){
            int node = que.pop();
            for (int i = 0; i < n; i++) {
                if (node == i) continue;
                if (computer[node][i] == 1 && !visited[i]){
                    que.add(i);
                    visited[i] = true;
                }
            }
        }
        return true;
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n+1];

        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                bfs(i, n, computers);
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        _230322 test = new _230322();
        test.solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
    }
}
