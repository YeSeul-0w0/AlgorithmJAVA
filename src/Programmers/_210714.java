package Programmers;

import java.util.HashMap;

public class _210714 {
    static String[] str;
    static HashMap<Character,Integer> map ;
    static boolean[] visited;
    static int[] result;
    static int answer;

    public int solution(int n, String[] data) {
        str = data;
        map = new HashMap<>();
        visited = new boolean[8];
        result = new int[8];
        answer = 0;
        map.put('A',0);
        map.put('C',1);
        map.put('F',2);
        map.put('J',3);
        map.put('M',4);
        map.put('N',5);
        map.put('R',6);
        map.put('T',7);
        dfs(0);
        return answer;
    }

    public static void dfs(int index){
        if(index == 8){
            if(check()) answer++;
        }
        else{
            for(int i=0;i<8;i++){
                if(!visited[i]){
                    visited[i] = true;
                    result[index] = i;
                    // index= 알파벳의 위치
                    // i = 알파벳 고유의 value 값
                    dfs(index + 1);
                    visited[i] = false;
                }
            }
        }
    }


    public static boolean check(){
        int a,b,diff;
        char sign;
        for(String s : str){
            a = result[map.get(s.charAt(0))]; // 영문자
            b = result[map.get(s.charAt(2))]; // 영문자

            sign = s.charAt(3); // = < >
            diff = s.charAt(4)-'0' + 1; // 숫자

            if(sign == '='){
                if(Math.abs(a-b)!=diff) return false;
            }
            else if(sign == '>'){
                if(Math.abs(a-b) <= diff) return false;
            }
            else {
                if(Math.abs(a-b) >= diff) return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        _210714 test=new _210714();

        test.solution(2, new String[]{"N~F=0", "R~T>2"});
    }
}
