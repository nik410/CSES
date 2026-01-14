import java.util.*;
import java.io.*;

public class concertTickets{

    public static void main(String[] args){
        FastReader sc = new FastReader();

        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();

        ArrayList<Integer> prices = new ArrayList<>();
        ArrayList<Integer> customerBids = new ArrayList<>();
        
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        for(int i = 0; i < n; i ++){
            prices.add(sc.nextInt());
            tm.put(prices.get(i), tm.getOrDefault(prices.get(i), 0) + 1);
        }
        
        for(int i = 0; i < m; i ++){
           customerBids.add(sc.nextInt());
        }
       
        int ans[] = new int[m];

        for(int i = 0; i < m; i ++){
            int bid = customerBids.get(i);

            if(tm.floorKey(bid) != null){
                int closePrice = tm.floorKey(bid);
                if(tm.get(closePrice) >= 1){
                    ans[i] = closePrice;
                    if(tm.get(closePrice) == 1){
                        tm.remove(closePrice);
                    }
                    else
                    tm.put(closePrice, tm.get(closePrice) - 1);
                }
                else{
                    ans[i] = -1;
                }
            }
            else{
                ans[i] = -1;
            }
        }

        for(int i: ans){
            System.out.println(i);
        }
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