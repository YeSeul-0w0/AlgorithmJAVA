package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _16198 {
    public static int N;
    public static ArrayList<Integer> numberList;
    public static int answer=0;
    public static void gatherEnergy(int multi){
        if(numberList.size()==2){
            answer=Math.max(answer,multi);
        }

        else{
            for (int a = 1; a < numberList.size()-1; a++) {
                int temp=numberList.get(a-1)*numberList.get(a+1);
                int point=numberList.get(a);
                numberList.remove(a);
                gatherEnergy(temp+multi);
                numberList.add(a,point);
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());

        numberList=new ArrayList<>();
        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numberList.add(Integer.parseInt(st.nextToken()));
        }


        gatherEnergy(0);
        for (int j = 1; j < N-1; j++) {

        }

        System.out.println(answer);



    }
}
