package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _3954 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());

        int max_number=255;

        int loop=50000000;

        for (int a=0; a<N; a++){

            String temp=br.readLine();
            String[] number=temp.split(" ");

            int [] memory=new int[Integer.parseInt(number[0])];


            String[] brain=br.readLine().split(""); // +-,. ~~
            String[] input=br.readLine().split(""); // qwe

            int [] input_num=new int[input.length];
            for(int b=0; b<input.length; b++){
                char change=input[b].charAt(0);
                int change_num=(int)change;
                input_num[b]=change_num;
            } //입력받은 문자들 아스키 코드로 전환

            Stack<Integer> pair=new Stack<>();
            int[] position=new int[brain.length];

            for (int i=0; i<brain.length; i++){
                if (brain[i].equals("[")) pair.push(i);
                else if(brain[i].equals("]")){
                    int open=pair.pop();
                    position[i]=open;
                    position[open]=i;
                }
            }

            boolean finish=false;
            int code_index=0;
            int pointer_index=0; //포인터의 위치값
            int char_index=0;

            for (int i = 0; i < 2; i++) {
                int parentheses=0;
                int count=0; //명령어 실행횟수

                while (true) {
                    parentheses=Math.max(parentheses,code_index);
                    switch (brain[code_index]){
                        case "+":
                            if (memory[pointer_index]>=max_number) memory[pointer_index]=0;
                            else memory[pointer_index]++;
                            break;
                        case "-":
                            if(memory[pointer_index]<=0) memory[pointer_index]=255;
                            else memory[pointer_index]--;
                            break;
                        case "<":
                            if(pointer_index<=0) pointer_index=Integer.parseInt(number[0])-1;
                            else pointer_index--;
                            break;
                        case ">":
                            if(pointer_index>=Integer.parseInt(number[0])-1) pointer_index=0;
                            else pointer_index++;
                            break;
                        case ".":
                            break;
                        case ",":
                            if (char_index>=Integer.parseInt(number[2])) memory[pointer_index]=255;
                            else memory[pointer_index]=input_num[char_index++];
                            break;
                        case "[":
                            if (memory[pointer_index]==0){
                                code_index=position[code_index];
                            }
                            break;
                        case "]":
                            if(memory[pointer_index]!=0){
                                code_index=position[code_index];
                            }
                            break;
                    }

                    code_index++;
                    count++;

                    if (code_index==brain.length){
                        finish=true;
                        break;
                    }

                    if (count>=loop){
                        break;
                    }
                }

                if (finish){
                    System.out.println("Terminates");
                    break;
                }
                else{
                    if (i==1){
                        System.out.println("Loops "+position[parentheses]+" "+parentheses);
                    }
                }
            }
        }
    }
}
