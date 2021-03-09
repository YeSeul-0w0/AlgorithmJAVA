package BackJoon;

import java.io.*;
import java.util.Stack;


public class _1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        Stack<Character> stack=new Stack<>();
        Stack<Character> temp=new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        for (int j = 0; j < N; j++) {
            String edit = br.readLine();
            char command = edit.charAt(0);
            switch (command) {
                case 'L':
                    if(!stack.empty()){
                        temp.push(stack.pop());
                    }
                    break;
                case 'D':
                    if(!temp.empty()){
                        stack.push(temp.pop());
                    }
                    break;
                case 'B':
                    if(!stack.empty()){
                        stack.pop();
                    }
                    break;
                case 'P':
                    stack.push(edit.charAt(edit.length()-1));
                default:
                    break;

            }
        }

        while (!temp.empty()){
            stack.push(temp.pop());
        }

        for(int z=0; z<stack.size(); z++){
            bw.write(stack.get(z));
        }



        bw.flush();
        bw.close();
    }
}

