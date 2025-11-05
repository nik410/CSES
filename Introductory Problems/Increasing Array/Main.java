    import java.util.*;
    import java.io.*;

    public class Main{
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            int arr[] = new int[n];

            for(int i = 0; i < n ; i ++){
                arr[i] = sc.nextInt();
            }

            long minMoves = 0;

            for(int i = 1; i < n ; i ++){
                int prev = arr[i - 1];
                int curr = arr[i];
                if(prev > curr){
                    minMoves += prev - curr;
                    arr[i] = prev;
                }
            }

            System.out.println(minMoves);
        }
    }