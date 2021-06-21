package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2800 {

    static StringBuilder sb=null;
    static Set<String> answer=null;
    static String str=null;
    static Boolean[] check=null;
    static int[] pair=null;

    public static void dfs(int pointNow, int point){
        if (pointNow==point){
            answer.add(sb.toString());
            return;
        }
        char ch=str.charAt(pointNow);

        if(ch=='('){
            check[pointNow]=true;
            dfs(pointNow+1,point);
            check[pointNow]=false;
        }

        if(ch==')' && check[pair[pointNow]]){ //쌍인 괄호 지워지는지 체크
            check[pointNow]=true;
            dfs(pointNow+1, point);
            check[pointNow]=false;
        }
        else{ //괄호 안지우거나 숫자인 경우
            sb.append(ch);
            dfs(pointNow+1,point);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack=new Stack<>();

        sb=new StringBuilder();
        answer=new HashSet<>();
        str=br.readLine();
        pair=new int[str.length()]; //괄호 쌍 저장
        check=new Boolean[str.length()]; // 나와 쌍인 괄호 지울건지 고민고민

        for (int i=0; i<str.length(); i++){
            char temp=str.charAt(i);
            if(temp=='('){
                stack.push(i);
            }
            else if(temp==')'){
                pair[i]=stack.peek();
                pair[stack.peek()]=i;
                stack.pop();
            }
        }

        dfs(0,str.length());

        answer.remove(str); // 괄호를 아에 제거하지 않는 경우, 기존 문자열과 같기 때문에 없애줌
        ArrayList<String> list=new ArrayList<>(answer);
        Collections.sort(list);
        for(String s:list){
            sb.append(s).append("\n");
        }
        System.out.print(sb.toString());
    }
}
