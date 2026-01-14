import java.util.*;
import java.io.*;

public class sumOfTwoValues{

    public static void main(String[] args){
        FastReader sc = new FastReader();

        int n, sum;
        n = sc.nextInt();
        sum = sc.nextInt();

        int arr[] = new int[n];

        for(int i = 0; i < n; i ++){
           arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
      
        int index1 = -1;
        int index2 = -1;

        for(int i = 0; i < n; i ++){
            int val = arr[i];
            if(hm.containsKey(sum - val)){
                index1 = i;
                index2 = hm.get(sum - val);

                System.out.println((index1 + 1) + " " + (index2 +  1));
                break;
            }

            hm.put(val, i);
        }

        if(index1 == -1)
        System.out.println("IMPOSSIBLE");

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