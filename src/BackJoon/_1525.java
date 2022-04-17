package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1525 {

    public static int[] dx=new int[]{-1,0,1,0};
    public static int[] dy=new int[]{0,-1,0,1};
    public static StringBuilder info;
    public static Map<String, Integer> count;

    public static void bfs(){
        Queue<String> deque=new LinkedList<>();
        count=new HashMap<>();
        deque.offer(info.toString());
        // Map.put("key","values)
        count.put(info.toString(),0);

        while (!deque.isEmpty()){
            String current=deque.poll();
            // 빈칸 위치 찾기
            int location9=current.indexOf("9");
            int px=location9/3;
            int py=location9%3;

            for (int i = 0; i < 4; i++) {
                int nx=dx[i]+px;
                int ny=dy[i]+py;
                int move=nx*3+ny;

                if (nx<0 || ny<0 || nx>=3 || ny>=3) continue;

                StringBuilder next=new StringBuilder(current);
                char temp=next.charAt(move);
                // location9 위치에 temp 넣기
                next.setCharAt(location9,temp);
                next.setCharAt(move,'9');
                String nextStr=next.toString();
                if(!count.containsKey(nextStr)){
                    deque.offer(nextStr);
                    count.put(nextStr,count.get(current)+1);
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        info=new StringBuilder();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                String temp=st.nextToken();
                if (temp.equals("0")) info.append("9");
                else info.append(temp);
            }
        }

        bfs();
        if (count.containsKey("123456789")){
            System.out.println(count.get("123456789"));
        }
        else{
            System.out.println(-1);
        }

    }
}
