package BackJoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _15828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int que_size= Integer.parseInt(br.readLine());
        int check=0;
        Queue<Integer> queue=new LinkedList<>();

        while(check!=-1){
            check=Integer.parseInt(br.readLine());
            if(check==0){
                queue.poll();

            }
            else{
                if(check>0 && queue.size()<que_size) {
                    queue.offer(check);
                }
            }
        }
        if(queue.isEmpty()){
            System.out.println("empty");

        }
        else{
            while (!queue.isEmpty()){
                System.out.print(queue.poll()+" ");
            }
        }

    }
}
