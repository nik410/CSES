import java.util.*;
import java.io.*;

public class ferrisWheel{

    public static void main(String[] args){
        FastReader sc = new FastReader();

        int n, x;
        n = sc.nextInt();
        x = sc.nextInt();

        ArrayList<Integer> weights = new ArrayList<>();
       
        for(int i = 0; i < n; i ++){
            weights.add(sc.nextInt());
        }
        
        Collections.sort(weights);

        int ans = 0;

        int i = 0, j = n - 1;

        while(i <= j){
            int weightMin = weights.get(i);
            int weightMax = weights.get(j);

            if(weightMax + weightMin > x){
                ans ++;
                j --;
            }
            else{
                ans ++;
                i ++;
                j --;
            }
        }

        System.out.println(ans);
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