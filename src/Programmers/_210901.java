package Programmers;

public class _210901 {
    public static int[][] connection;
    public static boolean [] visited;
    public static int answer;

    public int checking_load(int position){
        boolean flag=false;

        for (int i = 1; i < connection.length; i++) {
            if(visited[i]==false && connection[position][i]==1){
                visited[i]=true;
                answer++;
                flag=true;
                break;
            }
        }
        if (!flag){
            return -1;
        }
        else{
            return answer;
        }
    }

    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        answer = 0;
        
        connection=new int[n+1][n+1];
        for (int a = 0; a < m; a++) {
            connection[edge_list[a][0]][edge_list[a][1]]=1;
            connection[edge_list[a][1]][edge_list[a][0]]=1;
        }

        visited=new boolean[n+1];

        for (int i = 0; i < k-1; i++) {
            if(gps_log[i]!=gps_log[i+1] && connection[gps_log[i]][gps_log[i+1]]==1){
                visited[gps_log[i]]=true;
                continue;
            }
            else if(gps_log[i]!=gps_log[i+1] && connection[gps_log[i]][gps_log[i+1]]==0){

                if(checking_load(gps_log[i+1])==-1){
                    answer=-1;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        _210901 test=new _210901();

        test.solution(7,10, new int[][] {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}},
                6,new int[]{1, 2, 3, 3, 6, 7});
    }
}
