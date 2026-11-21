import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int tc = sc.nextInt();

        for(int t = 0; t < tc; t ++){
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(a + b > n){
                out.println("NO");
                continue;
            }
            int winOnly = a + b;

            if((a == 0 || b == 0) && winOnly > 0){
                out.println("NO");
                continue;
            }

            out.println("YES");

            for(int i = 1; i <= n; i ++){
                out.print(i + " ");
            }
            out.println();

            for(int i = 1; i <= (winOnly); i ++){
                int val = i + a;
                if(val > winOnly) val -= (winOnly);
                out.print(val + " ");
            }

            for(int i = winOnly + 1; i <= n; i ++){
                out.print(i + " ");
            }

            out.println("");
        }

        out.close();
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