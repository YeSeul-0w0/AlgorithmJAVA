package Programmers;

public class _230322_2 {
    public int answer = 0;
    public void dfs(int sum, int point, int end, int[] number, int target){
        if (point == end){
            if (target == sum){
                answer++;
            }
        }
        else {
            dfs(sum + number[point], point + 1 , end, number, target);
            dfs(sum - number[point], point + 1 , end, number, target);
        }
        return;
    }
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers.length, numbers, target);
        return answer;
    }

    public static void main(String[] args) {
        _230322_2 test = new _230322_2();
        System.out.println(test.solution(new int[]{1, 1, 1, 1, 1}, 3));
        test.answer = 0;
        System.out.println(test.solution(new int[]{4, 1, 2, 1}, 4));
    }
}
