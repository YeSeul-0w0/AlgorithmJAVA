package Programmers;

import java.util.LinkedList;
import java.util.Stack;

public class _211110 {
    public String solution(int n, int k, String[] cmd) {


        Stack<Integer> removeInfo=new Stack<>();
        int len=n;
        int cursor=k;
        for (int i = 0; i < cmd.length; i++) {
            char operation=cmd[i].charAt(0);
            if (operation=='D'){
                cursor+=Integer.parseInt(cmd[i].substring(2));
            }
            else if(operation=='U'){
                cursor-=Integer.parseInt(cmd[i].substring(2));
            }
            else if(operation=='C'){
                removeInfo.add(cursor);
                len--;
                if(cursor==len) cursor--;
            }
            else if(operation=='Z'){
                if(removeInfo.pop()<=cursor) cursor++;
                len++;
            }
        }

        StringBuilder strBuild=new StringBuilder();
        for (int j = 0; j < len; j++) {
            strBuild.append("O");
        }

        while(!removeInfo.isEmpty()){
            strBuild.insert(removeInfo.pop().intValue(), "X");
        }


        String answer = strBuild.toString();

//        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        _211110 test=new _211110();
        test.solution(8,2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"});
    }
}
