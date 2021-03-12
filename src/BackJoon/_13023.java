package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13023 {
    static int people;
    static int total;

    static int[][] relationship;
    static Boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer=new StringTokenizer(reader.readLine());

        people=Integer.parseInt(tokenizer.nextToken());
        total =Integer.parseInt(tokenizer.nextToken());

        relationship =new int[people][people];


        for(int i = 0; i< total; i++){
            tokenizer=new StringTokenizer(reader.readLine());
            int A=Integer.parseInt(tokenizer.nextToken());
            int B=Integer.parseInt(tokenizer.nextToken());
            relationship[A][B]=1;
        }

        visited=new Boolean[people][people];
        for(int a=0; a<people; a++){
            for(int b=0; b<people; b++){
                visited[a][b]=false;
            }
        }

        for (int p=0; p<people; p++){
            for(int q=0; q<people; q++){
                if (relationship[p][q]==1){

                }
            }
        }

    }
}
