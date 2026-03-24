    import java.util.*;
    import java.io.*;

    public class nestedRangeCheck{

        public static void main(String[] args){
            FastReader sc = new FastReader();
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

            int n = sc.nextInt();
            int arr[][] = new int[n][3];

            for(int i = 0 ; i < n; i ++){
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
                arr[i][2] = i;
            }

            Arrays.sort(arr, (x, y) -> {
                if(x[0] == y[0]){
                    return y[1] - x[1];
                }
                return x[0] - y[0];
            });

            int contained[] = new int[n];
            
            int maxEndPoint = 0;

            for(int i = 0; i < n; i ++){
                int start = arr[i][0];
                int end = arr[i][1];

                if(end <= maxEndPoint){
                    contained[arr[i][2]] = 1;
                }

                maxEndPoint = Math.max(maxEndPoint, end);
            }

            int contains[] = new int[n];
            int minEndPoint = Integer.MAX_VALUE;

            for(int i = n - 1; i >= 0; i --){
                int start = arr[i][0];
                int end = arr[i][1];

                if(end >= minEndPoint){
                    contains[arr[i][2]] = 1;
                }

                minEndPoint = Math.min(minEndPoint, end);
            }

            for(int i: contains){
                out.print(i + " ");
            }

            out.println();

            for(int i: contained){
                out.print(i + " ");
            }

            out.println("");
            
            
            

            out.flush();
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