package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;

public class _9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        String boom=br.readLine();
        Stack<Character> str_stack=new Stack<>();

        for(int a=0; a<str.length(); a++){
            str_stack.push(str.charAt(a));
            if(str_stack.size()>=boom.length()){
                Boolean flag= true;
                for(int i=0; i<boom.length(); i++){
                    if(str_stack.get(str_stack.size() - boom.length()+i)!=boom.charAt(i)){
                        flag=false;
                        break;
                    }
                }
                if (flag){
                    for(int b=0; b<boom.length(); b++){
                        str_stack.pop();
                    }
            }
            }
        }

        StringBuilder sb=new StringBuilder();

        for(int i=0; i<str_stack.size(); i++){
                sb.append(str_stack.get(i));
            }

        System.out.println(sb.length()>0 ? sb.toString() : "FRULA");


    }
}
