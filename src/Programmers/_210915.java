package Programmers;

import java.util.Arrays;

public class _210915 {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left=0;
        long right=(long)n * times[times.length-1]; //최악으로 걸리는 시간
        while (left<=right){
            long mid=(left+right)/2;
            long total=0;
            for (int i = 0; i < times.length; i++) {
                total+=mid/times[i];
            }
            if(total>=n) {
                right=mid-1;
                answer=mid;
            }
            else{
                left=mid+1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        _210915 test=new _210915();

        System.out.println(test.solution(6,new int[]{7,10}));
    }

}
