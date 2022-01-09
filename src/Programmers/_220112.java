package Programmers;

import javax.xml.stream.FactoryConfigurationError;

public class _220112 {

    public static int zeroCount=0;
    public static int oneCount=0;
    public static void checking(int[][] arr, int x, int y, int size){
        if (isAllSame(arr,x,y,size)){
            int point=arr[x][y];
            if (point==1) oneCount++;
            if (point==0) zeroCount++;
            return;
        }
        int mid=size/2;
        checking(arr,x+mid,y,mid);
        checking(arr,x+mid,y+mid,mid);
        checking(arr,x,y+mid,mid);
        checking(arr,x,y,mid);
    }

    public static boolean isAllSame(int[][] arr,int x, int y, int size){
        int flag=arr[x][y];
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (arr[i][j]!=flag) return false;
            }
        }
        return true;
    }

    public int[] solution(int[][] arr) {
        int[] answer = {0,0};
        int len=arr.length;
        checking(arr,0,0,len);
        answer[0]=zeroCount;
        answer[1]=oneCount;
//        System.out.println(answer[0]+" "+answer[1]);
        return answer;
    }

    public static void main(String[] args) {
        _220112 test=new _220112();
        test.solution(new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}});
    }
}
