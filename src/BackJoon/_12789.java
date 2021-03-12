package BackJoon;


import java.util.Scanner;
import java.util.Stack;

public class _12789 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int count=1;

        int[] t=new int[N+1];
        Stack<Integer> number_ticket=new Stack<>();

        for(int p=0; p<N; p++){
            t[p]=sc.nextInt();
        }
        for(int a=N-1; a>-1; a--){
            number_ticket.add(t[a]);
        }

        Stack<Integer> line=new Stack<>();
        Stack<Integer> temp=new Stack<>();

        while (true){
            if(!number_ticket.empty()){
                int comparison=number_ticket.peek();
                if(comparison!=count){
                    if (!temp.empty()){
                        int check=temp.peek();
                        if(check==count){
                            line.push(temp.pop());
                            count++;
                        }
                        else{
                            temp.push(number_ticket.pop());

                        }
                    }
                    else{
                        temp.push(number_ticket.pop());
                    }
                }
                else{
                    line.push(number_ticket.pop());
                    count++;
                }

            }
            else{
                if(!temp.empty()){
                    int check=temp.peek();
                    if (check==count){
                        line.push(temp.pop());
                        count++;
                    }
                    else{
                        break;
                    }
                }
                else{
                    break;
                }
            }



        }


        if(N==line.size()) System.out.println("Nice");
        else System.out.println("Sad");

    }
}
