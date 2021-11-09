package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2502 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int day=Integer.parseInt(st.nextToken());
        int total=Integer.parseInt(st.nextToken());
        int[] values=new int[day];

        for (int i = 1; i < total/2; i++) {
            for (int j = i+1; j < total; j++) {
                values[0]=i;
                values[1]=j;
                for (int k = 2; k < day; k++) {
                    values[k]=values[k-1]+values[k-2];
                }
                if (values[day-1]==total){
                    System.out.println(values[0]);
                    System.out.println(values[1]);
                    System.exit(0);
                }
            }
        }
    }
}
