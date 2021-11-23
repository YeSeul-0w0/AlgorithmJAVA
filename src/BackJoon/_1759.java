package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1759 {
    static int L,C;
    static String[] types;
    static ArrayList<String> result=new ArrayList<>();
    
    public static void searching(int idx, int v, int c, String candi){
        if (candi.length()==L){
            if (v>=1 && c>=2){
                result.add(candi);
                return;
            }
            else{
                return;
            }
        }
        else{
            for (int j = idx; j < C; j++) {
                String check=types[j];
                if(check.equals("a") || check.equals("e") || check.equals("i") || check.equals("o") || check.equals("u")){
                    searching(j+1,v+1,c,candi+check);
                }
                else{
                    searching(j+1,v,c+1,candi+check);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer numbers=new StringTokenizer(br.readLine());

        L=Integer.parseInt(numbers.nextToken());
        C=Integer.parseInt(numbers.nextToken());

        types=new String[C];
        String str=br.readLine();
        types=str.split(" ");
        Arrays.sort(types);

        for (int i = 0; i < (C-L)+1; i++) {
            String candidate=types[i];
            switch (candidate){
                case "a": case "e": case"i": case "o": case"u":
                    searching(i+1,1,0,candidate);
                    break;
                default:
                    searching(i+1,0,1,candidate);
                    break;
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
