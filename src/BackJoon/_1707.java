package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1707 {

    public static ArrayList<ArrayList<Integer>> graph;

    static int[] color;
    static int red=1;
    static String answer="";

    public static boolean bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start]=red;
        answer="YES";

        while (!queue.isEmpty()){
            int check=queue.poll();

            for(Integer i:graph.get(check)){
                if (color[check]==color[i]){

                    answer="NO";
                    return false;
                }

                if(color[i]==0){
                    color[i]=color[check]*-1;
                    queue.add(i);
                }
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int K=Integer.parseInt(br.readLine());

        for (int i=0; i<K; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());

            int V=Integer.parseInt(st.nextToken());
            int E=Integer.parseInt(st.nextToken());
            
            color=new int[V+1];
            graph=new ArrayList<>();

            for (int j = 0; j < V+1; j++) {
                graph.add(new ArrayList<>());
            }

            for (int z = 0; z < E; z++) {
                StringTokenizer save=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(save.nextToken());
                int b=Integer.parseInt(save.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            for (int w = 0; w < V; w++) {
                if(color[w]==0) {
                    if(!bfs(w)) break;
                }
            }
            System.out.println(answer);
        }
    }
}
