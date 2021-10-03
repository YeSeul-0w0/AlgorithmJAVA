package Programmers;

public class _211006 {

    public int solution(String s)
    {
        int answer = 1;

        int len=s.length();

        int[][] dp=new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i]=1;
            if (i<len-1 && s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=1;
            }
        }

        for (int i = 2; i < len; i++) {
            for (int j = 1; j < i+1; j++) {
                if(s.charAt(i)==s.charAt(i-j) && dp[i-j+1][i-1]==1){
                    dp[i-j][i]=1;
                    answer=Math.max(answer,j+1);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        _211006 test=new _211006();

        test.solution("abcdcba");
    }
}
