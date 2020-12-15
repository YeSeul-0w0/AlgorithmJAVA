import javax.xml.stream.FactoryConfigurationError;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BackJoon2468 {

    static int[][] zone;
    static int size, max, min;
    static Boolean[][] visited;
    static ArrayList<Integer> numList;

    public static Boolean ZoneNum(int x, int y){
        if (x<=-1 || x>=size || y<=-1|| y>=size)
            return false;
        if (visited[x][y]==false){
            visited[x][y]=true;
            ZoneNum(x-1,y);
            ZoneNum(x+1,y);
            ZoneNum(x,y-1);
            ZoneNum(x,y+1);
            return true;
        }
        else
            return false;
    }

    // MAIN 시작
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer=new StringTokenizer(reader.readLine());

        size=Integer.parseInt(tokenizer.nextToken());

        zone=new int[size][size];
        for(int i=0; i<size; i++){
            tokenizer=new StringTokenizer(reader.readLine());
            for(int j=0; j<size; j++){
                zone[i][j]=Integer.parseInt(tokenizer.nextToken());
            }
        }

        min=zone[0][0];
        max=zone[0][0];

        for (int a=0; a<size; a++){
            for (int b=1; b<size; b++){
                if(min>zone[a][b])
                    min=zone[a][b];
                if(max<zone[a][b])
                    max=zone[a][b];
            }
        }

        visited=new Boolean[size][size];

        numList=new ArrayList<>();

        int point=max;
        while (point>min){


            for(int z=0; z<size; z++){
                for(int v=0; v<size; v++){
                    zone[z][v]-=point;
                }
            }

            for(int q=0; q<size; q++){
                for(int p=0; p<size; p++){
                    if(zone[q][p]<=0)
                        visited[q][p]= true;
                    else
                        visited[q][p]=false;
                }
            }



            int result=0;
            for (int g=0; g<size; g++){
                for(int h=0; h<size; h++){
                    if (ZoneNum(g,h)== true){
                        result++;
                    }
                }
            }
            numList.add(result);

            point--;



        }


        System.out.println(numList);
    }
}
