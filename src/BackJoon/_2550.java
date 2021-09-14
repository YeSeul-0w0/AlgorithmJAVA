package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());

        int[] lightSwitch=new int [N];
        StringTokenizer stSwitch=new StringTokenizer(br.readLine());
        for (int a = 0; a < N; a++) {
            int temp=Integer.parseInt(stSwitch.nextToken());
            lightSwitch[temp]=a;
        }

        int[] light=new int [N];
        StringTokenizer stLight=new StringTokenizer(br.readLine());
        for (int b = 0; b < N; b++) {
            light[Integer.parseInt(stLight.nextToken())]=b;
        }

        for (int i = 0; i < N; i++) {
            System.out.println("전구 "+light[i]);
            System.out.println("스위치 "+lightSwitch[i]);
        }
    }
}
