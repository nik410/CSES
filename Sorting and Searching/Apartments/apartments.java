import java.util.*;
import java.io.*;

public class apartments{

    public static void main(String[] args){
        FastReader sc = new FastReader();

        int n, m, k;
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        ArrayList<Integer> desires = new ArrayList<>();
        ArrayList<Integer> apartments = new ArrayList<>();
        

        for(int i = 0; i < n; i ++){
            desires.add(sc.nextInt());
        }
        
        for(int i = 0; i < m; i ++){
           apartments.add(sc.nextInt());
        }

        Collections.sort(desires);
        Collections.sort(apartments);

        int i = 0;
        int j = 0;

        int ans = 0;

        while(i < n && j < m){
            
            int desire =desires.get(i);
            int apartment = apartments.get(j);
            
            if(Math.abs(desire - apartment) <= k){
                ans ++;
                i ++;
                j ++;
            }
            else if(desire > apartment){
                j ++;
            }
            else if(desire < apartment){
                i ++;
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