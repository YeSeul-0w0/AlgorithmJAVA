package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st1.nextToken());
        int M=Integer.parseInt(st1.nextToken());

        StringTokenizer st2=new StringTokenizer(br.readLine());

        long left=0;
        long right=0;

        int[] numArray=new int[N];
        for (int i = 0; i < N; i++) {
            numArray[i]=Integer.parseInt(st2.nextToken());
            right+=numArray[i];
            if (left<numArray[i]){ //이거 넣는거랑 안넣는거랑 대체 뭔차이가 있는거야!
                left=numArray[i];
            }
        }
        
        while (left<=right){
            long mid=(left+right)/2;
            int count=0;
            int sum=0;

            for (int j = 0; j < N; j++) {
                if (sum+numArray[j]>mid){
                    count++;
                    sum=0;
                }
                sum+=numArray[j];
            }
            if (sum>0) count++;

            if (count>M) {
                left=mid+1;
            }
            else {
                right=mid-1;
            }

        }

        System.out.println(left);
    }
}
