    import java.util.*;
    import java.io.*;

    public class subarraySumI{

        public static void main(String[] args){
            FastReader sc = new FastReader();
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

            
            int n = sc.nextInt();
            int x = sc.nextInt();

            int arr[] = new int[n];

            for(int i = 0; i < n; i ++){
                arr[i] = sc.nextInt();
            }

            HashMap<Long, Integer> hm = new HashMap<>();

            hm.put(0l, 1);
            long count = 0;
            long currSum = 0;

            for(int i = 0; i < n; i ++){
                currSum += (long)arr[i];

                if(hm.containsKey(currSum - x)){
                    count += hm.get(currSum - x);
                }

                hm.put(currSum, hm.getOrDefault(currSum, 0) + 1);
            }

            out.println(count);
        
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