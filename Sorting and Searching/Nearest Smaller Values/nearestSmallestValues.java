    import java.util.*;
    import java.io.*;

    public class nearestSmallestValues{
        public static void main(String[] args){
            FastReader sc = new FastReader();
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

            int n = sc.nextInt();
           
            
            int nums[]= new int[n];

            for(int i = 0; i < n; i ++){
                nums[i] = sc.nextInt();
            }

            int ans[] = new int[n];

            Stack<Integer> st = new Stack<>();

            
            ans[0] = 0;

            for(int i = 0; i < n; i ++){
                while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                    st.pop();
                }

                if(st.isEmpty()){
                    ans[i] = 0;
                }
                else{
                    ans[i] = st.peek() + 1;
                }

                st.push(i);
            }

            for(int i: ans){
                out.print(i + " ");
            }

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