package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int jimin=Integer.parseInt(st.nextToken());
        int hansu=Integer.parseInt(st.nextToken());

        ArrayList<Integer> tournament=new ArrayList<Integer>();
        for (int i = 1; i < N+1; i++) {
            tournament.add(i);
        }
        int count=1;
        int position=0;

        while (true){
            if(tournament.size()>1 && position+1<tournament.size()){
                int p1=tournament.get(position);
                int p2=tournament.get(position+1);
                if ((p1==jimin && p2==hansu)||(p1==hansu && p2==jimin)){
                    System.out.println(count);
                    break;
                }
                else if(p1==jimin || p2==jimin){
                    if (p1==jimin){
                        tournament.remove(position+1);
                    }
                    else{
                        tournament.remove(position);
                    }
                }
                else if(p1==hansu || p2==hansu){
                    if(p1==hansu){
                        tournament.remove(position+1);
                    }
                    else{
                        tournament.remove(position);
                    }
                }
                else{
                    tournament.remove(position);
                }

                position++;

            }
            else{
                if(tournament.size()>1 && position+1>=tournament.size()){
                    position=0;
                    count++;
                    continue;
                }
                else{
                    System.out.println(-1);
                    break;
                }
            }


        }

    }
}
