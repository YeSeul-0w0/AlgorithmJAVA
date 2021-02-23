import javax.xml.stream.FactoryConfigurationError;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class _2468 {

    static int[][] zone, working;
    static int size, max;
    static Boolean[][] visited;
    static ArrayList<Integer> numList;

    public static Boolean ZoneNum(int x, int y){
        if (x<=-1 || x>=size || y<=-1|| y>=size)
            return false;
        if (working[x][y]!=0 && visited[x][y]==false){
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

        working=new int[size][size];
        for(int t=0; t<size;t++){
            for(int y=0; y<size; y++){
                working[t][y]=zone[t][y];
            }
        }

        max=zone[0][0];

        for (int a=0; a<size; a++){
            for (int b=1; b<size; b++){
                if(max<zone[a][b])
                    max=zone[a][b];
            }
        }

        visited=new Boolean[size][size];

        numList=new ArrayList<>();

        int point=max;

        while (point>=0){

            for(int z=0; z<size; z++){
                for(int v=0; v<size; v++){
                    int temp=working[z][v]-point;
                    if (temp<0)
                        working[z][v]=0;
                    else
                        working[z][v]=temp;
                }
            }

            for(int q=0; q<size; q++){
                for(int p=0; p<size; p++){
                    if(working[q][p]==0)
                        visited[q][p]= true;
                    else
                        visited[q][p]=false;
                }
            }



            int result=0;
            for (int g=0; g<size; g++){
                for(int h=0; h<size; h++){
                    if(zone[g][h]!=0){
                        if(ZoneNum(g,h)==true){
                            result++;
                        }
                    }

                }
            }
            numList.add(result);
            for (int r=0; r<size; r++){
                for(int e=0; e<size; e++){
                    working[r][e]=zone[r][e];
                }
            }

            point--;




        }
        Collections.sort(numList);

        System.out.println(numList.get(numList.size()-1));

    }
}
