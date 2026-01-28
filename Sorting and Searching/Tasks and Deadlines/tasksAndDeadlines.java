    import java.util.*;
    import java.io.*;

    public class tasksAndDeadlines{

        public static void main(String[] args){
            FastReader sc = new FastReader();
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

            int n;
            n = sc.nextInt();
            
            int taskInfo[][]= new int[n][2];

            for(int i = 0; i < n; i ++){
                taskInfo[i][0] = sc.nextInt();
                taskInfo[i][1] = sc.nextInt();
            }

            Arrays.sort(taskInfo, (x, y) -> {
               if(x[0] == y[0]){
                return x[1] - y[1];
               }
               return x[0] - y[0]; 
            });

            long currTime = 0;
            long ans = 0;

            for(int i[]: taskInfo){
                int duration = i[0];
                int deadline = i[1];
                currTime += duration;

                ans += (deadline - currTime);
            }

            out.println(ans);

            

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