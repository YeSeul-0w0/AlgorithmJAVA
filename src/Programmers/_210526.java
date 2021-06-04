package Programmers;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 이중우선순위큐
public class _210526 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minQue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());
        for (String op : operations) {
            StringTokenizer st = new StringTokenizer(op);
            String check = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            System.out.println(check+" "+value);

            if (minQue.size() < 1 && check.equals("D"))
                continue;

            if (check.equals("I")) {
                minQue.offer(value);
                maxQue.offer(value);
                continue;
            }

            if(value < 0) {
                int min = minQue.poll();
                maxQue.remove(min);
                continue;
            }

            int max = maxQue.poll();
            minQue.remove(max);
        }

        if(minQue.size() > 0 ) {
            answer[0] = maxQue.poll();
            answer[1] = minQue.poll();
        }
        return answer;
    }

    public static void main(String[] args){
        _210526 test=new _210526();
        System.out.println(test.solution(new String[]{"I 16", "D 1"}));
    }
}
