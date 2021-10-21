package Programmers;

public class _211027 {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int size=brown+yellow;
        int point=size/2;
        for (int i = 1; i < point; i++) {
            int temp=size/i; //가로
            if (i>temp){
                continue;
            }
            if ((i-2) * (temp-2)==yellow){
                answer[0]=temp;
                answer[1]=i;
                return answer;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        _211027 test=new _211027();
        System.out.println(test.solution(10,2));
    }
}
