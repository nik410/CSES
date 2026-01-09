import java.util.*;
import java.io.*;

public class towers{

    public static void main(String[] args){
        FastReader sc = new FastReader();

        int n, sum;
        n = sc.nextInt();
       
        int arr[] = new int[n];

        for(int i = 0; i < n; i ++){
           arr[i] = sc.nextInt();
        }

        TreeMap<Integer, Integer> tm = new TreeMap<>();

        int countTowers = 0;

        for(int i = 0; i < n; i ++){
            int currVal = arr[i];
            if(tm.higherKey(currVal) != null){
                tm.put(currVal, tm.getOrDefault(currVal, 0) + 1);
                if(tm.get(tm.higherKey(currVal)) == 1){
                    tm.remove(tm.higherKey(currVal));
                }
                else{
                    tm.put(currVal, tm.getOrDefault(currVal, 0) - 1);
                }
            }
            else{
                tm.put(currVal, tm.getOrDefault(currVal, 0) + 1);
                countTowers ++;
            }
        }

        System.out.println(countTowers);


      
        

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