import java.util.*;
import java.io.*;

public class maxSubarraySum{

    // public static int maxSum(int arr[], int index){
    //     if(index >= arr.length){
    //         return 0;
    //     }


    //     int startNew = arr[index];
    //     int take = arr[index] + maxSum(arr, index + 1);

    //     return Math.max(take, startNew);

    // }

    public static void main(String[] args){
        FastReader sc = new FastReader();

        int n;
        n = sc.nextInt();
       
        int arr[] = new int[n];

        for(int i = 0; i < n; i ++){
           arr[i] = sc.nextInt();
        }

        long dp[] = new long[n];
        
        dp[0] = arr[0];

        long maxSum = dp[0];

        for(int i = 1; i < n; i ++){
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);

            if(dp[i] > maxSum){
                maxSum = dp[i];
            }
        }
        
        System.out.println(maxSum);
        

    }

     static class FastReader {
      
        // BufferedReader to read input
        BufferedReader b;
      
        // StringTokenizer to tokenize input
        StringTokenizer s; 

        // Constructor to initialize BufferedReader
        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        // Method to read the next token as a string
        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace(); 
                }
            }
            return s.nextToken();
        }

        // Method to read the next token as an integer
        int nextInt() { 
            return Integer.parseInt(next()); 
        }

        // Method to read the next token as a long
        long nextLong() { 
            return Long.parseLong(next()); 
        }

        // Method to read the next token as a double
        double nextDouble() { 
            return Double.parseDouble(next()); 
        }

        // Method to read the next line as a string
        String nextLine() {
            String str = "";
            try {
                if (s.hasMoreTokens()) {
                    str = s.nextToken("\n");
                } else {
                    str = b.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace(); 
            }
            return str;
        }
    }
}