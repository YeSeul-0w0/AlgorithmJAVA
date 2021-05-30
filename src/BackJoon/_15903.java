package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _15903 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(tokenizer.nextToken());
        int frequency=Integer.parseInt(tokenizer.nextToken());

        StringTokenizer inputNum=new StringTokenizer(br.readLine());
        PriorityQueue<Long> numberCard = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            numberCard.offer(Long.parseLong(inputNum.nextToken()));
        }

        for(int j=0; j<frequency; j++){
            long min1=numberCard.poll();
            long min2=numberCard.poll();
            long newValue=min1+min2;
            numberCard.offer(newValue);
            numberCard.offer(newValue);
        }
        
        long ans=0;
        for(int z=0; z<N; z++){
            ans+=numberCard.poll();
        }

        System.out.println(ans);

    }
}
