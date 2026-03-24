    import java.util.*;
    import java.io.*;

    public class subarrayDivisibility{
        public static void main(String[] args){
            FastReader sc = new FastReader();
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

            int n = sc.nextInt();
  
            int nums[]= new int[n];

            for(int i = 0; i < n; i ++){
                nums[i] = sc.nextInt();
            }

            HashMap<Long, Integer> hm = new HashMap<>();
            long result = 0;

            hm.put(0l, 1);

            long sum = 0;

            for(int i: nums){
                if(i < 0){
                    sum += (long)(i + ((Math.abs(i) + n) / n) * n);
                }
                else{
                    sum += (long)(i);
                }
                                    
                if(hm.containsKey(sum % n)){
                   
                    result += (long)hm.get(sum % n);
                }

                hm.put(sum % n, hm.getOrDefault(sum % n, 0) + 1);
            }

            out.println(result);

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