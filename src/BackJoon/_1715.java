package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        PriorityQueue<Long> card=new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            card.add(Long.parseLong(st.nextToken()));
        }

        long total=0;

        while (card.size()>1){
            long a=card.poll();
            long b=card.poll();
            long sum=a+b;
            total+=sum;
            card.add(sum);
        }

        System.out.println(total);
    }
}
