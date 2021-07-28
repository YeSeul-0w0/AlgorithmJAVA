package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class _2668 {
    public static ArrayList<Integer> answer;
    public static int[] number;
    public static boolean[] visited;

    public static void dfs(int current, int target){
        if(!visited[number[current]]){
            visited[number[current]]=true;
            dfs(number[current], target);
            visited[number[current]]=false;
        }
        if (number[current]==target){
            answer.add(target);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        number=new int[N+1];
        for (int a = 1; a < N+1; a++) {
            number[a]=Integer.parseInt(br.readLine());
        }

        visited=new boolean[N+1];

        answer=new ArrayList<>();

        for (int i = 1; i < N+1; i++) {
            visited[i]=true;
            dfs(i,i);
            visited[i]=false;
        }

        Collections.sort(answer);

        System.out.println(answer.size());
        for (int z = 0; z < answer.size(); z++) {
            System.out.println(answer.get(z));
        }
    }
}
