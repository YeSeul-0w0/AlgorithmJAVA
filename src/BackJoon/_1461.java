package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _1461 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        LinkedList<Integer> minus=new LinkedList<>();
        LinkedList<Integer> plus=new LinkedList<>();
        StringTokenizer number=new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {

            int check=Integer.parseInt(number.nextToken());

            if (check<0){
                minus.add(-check);
            }
            else{
                plus.add(check);
            }
        }

        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus, Collections.reverseOrder());

        int ans=0;

        // 1. 제일 거리가 먼 것 뽑기
        if (!minus.isEmpty() && !plus.isEmpty()){
            if(minus.peek()>plus.peek()){
                ans+=minus.poll();
                for (int j = 0; j < M-1; j++) {
                    minus.poll();
                }
            }
            else{
                ans+=plus.poll();
                for (int j = 0; j < M-1; j++) {
                    plus.poll();
                }
            }
        }
        else{
            if(!minus.isEmpty() && plus.isEmpty()){
                ans+=minus.poll();
                for (int z = 0; z < M-1; z++) {
                    minus.poll();
                }
            }
            else if(minus.isEmpty() && !plus.isEmpty()){
                ans+=plus.poll();
                for (int z = 0; z < M-1; z++) {
                    plus.poll();
                }
            }
        }


        // 2. 나머지 거리 계산
        while (!plus.isEmpty()){
            ans+=(plus.poll()*2);
            for (int c = 0; c < M-1; c++) {
                plus.poll();
            }
        }

        while (!minus.isEmpty()){
            ans+=(minus.poll()*2);
            for (int c = 0; c < M-1; c++) {
                minus.poll();
            }
        }

        System.out.println(ans);

    }
}
