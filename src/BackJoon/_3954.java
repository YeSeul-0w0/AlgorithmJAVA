package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _3954 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());

        for (int a=0; a<N; a++){

            String temp=br.readLine();
            String[] number=temp.split(" ");

            if((Integer.parseInt(number[0])<=Integer.parseInt(number[1]))||
                    (Integer.parseInt(number[0])<=Integer.parseInt(number[2]))){
                //over || under 플로우
                break;
            }
            String[] brain=br.readLine().split("");
            String[] input=br.readLine().split("");

            int[] input_num=new int[Integer.parseInt(number[0])];

            for(int b=0; b<input.length; b++){
                char change=input[b].charAt(0);
                int change_num=(int)change;
                input_num[b]=change_num;
                System.out.println(input_num[b]);
            }


            Stack<Integer> pair=new Stack<>();

            int index=0;
            for (int i=0; i<brain.length; i++){
                switch (brain[i]){
                    case "+":
                        input_num[index]++;
                        break;
                    case "-":
                        input_num[index]--;
                        break;
                    case ">":
                        index++;
                        if (index>=Integer.parseInt(number[0])) index=0;
                        break;
                    case "<":
                        index--;
                        if (index<0) index=Integer.parseInt(number[0]);
                        break;
                    case "[":
                        pair.add(i);
                        break;

                }
            }



        }
    }
}
