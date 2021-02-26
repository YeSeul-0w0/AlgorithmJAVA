package BackJoon;

import java.util.Scanner;

public class _11054 {

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);

        int N=s.nextInt();
        int[] number=new int[N+2];
        for (int i=1; i<=N; i++){
            number[i]=s.nextInt();
        }

        int[] dp_up=new int[1002];
        int[] dp_down=new int[1002];
        int[] dp_result=new int[1002];

        for (int i=1; i<=N; i++){
            dp_up[i]=1;
            for(int j=1; j<i; j++){
                if(number[i]>number[j]){
                    dp_up[i]=Math.max(dp_up[i],dp_up[j]+1);
                }
            }
        }

        for (int i=N; i>=1; i--){
            dp_down[i]=1;
            for(int j=N; j>i; j--){
                if(number[i]>number[j]){
                    dp_down[i]=Math.max(dp_down[i],dp_down[j]+1);
                }
            }
        }

        int ans=0;
        for(int z=0; z<=N; z++){
            dp_result[z]=dp_up[z]+dp_down[z];
            if(dp_result[z]>ans) ans= dp_result[z];
        }


        System.out.println(ans-1);
        s.close();
    }

}
