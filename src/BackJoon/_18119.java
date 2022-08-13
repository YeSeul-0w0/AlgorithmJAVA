package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18119 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] wordList = new String[N];

        for (int i = 0; i < N; i++) {
            wordList[i]= br.readLine();
        }

        // 알파벳을 모두 알고 있다고 가정
        int allAlphabet = ( 1 << 27 ) -1;

        int[] binWord = new int [N];
        for (int i = 0; i < N; i++) {
            for (char c: wordList[i].toCharArray()) {
                // 사용하고 있는 알파벳 추가 로직
                binWord[i] |= ( 1 << c-'a' );
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer command = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(command.nextToken());
            char alphabet = command.nextToken().charAt(0);

            if (number == 1){
                allAlphabet &= ~( 1 << alphabet-'a');
            }
            else {
                allAlphabet |= ( 1 << alphabet-'a');
            }

            int knowCount = 0;

            for (int j = 0; j < N; j++) {
                if ((allAlphabet & binWord[j]) >= binWord[j]){
                    knowCount++;
                }
            }
            System.out.println(knowCount);
        }
    }
}
