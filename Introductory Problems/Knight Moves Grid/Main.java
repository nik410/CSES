import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int n = sc.nextInt();

        int visited[][] = new int[n][n];
        int moves[][] = new int[n][n];
        Queue<int[]> q = new LinkedList<>();


        q.offer(new int[]{0, 0, 0});
        visited[0][0] = 1;
        moves[0][0] = 0;

        int dir[][] = {  
            {2, 1},
            {2, -1},
            {-2, 1},
            {-2, - 1},
            {1, -2},
            {1, 2},
            {-1, 2},
            {-1, -2},
        };

        while(!q.isEmpty()){
            int siz = q.size();
            for(int i = 0; i < siz; i ++){
                int blockData[] = q.poll();

                // Check all 8 knight moves possible
                for(int d[]: dir){
                    int newX = d[0] + blockData[0];
                    int newY = d[1] + blockData[1];

                    if(newX >= 0 && newX < n && newY >= 0 && newY < n
                        && visited[newX][newY] == 0
                    ){  
                        q.offer(new int[]{newX, newY, blockData[2] + 1});
                        visited[newX][newY] = 1;
                        moves[newX][newY] = blockData[2] + 1;
                    }
                }
            }

        }

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                if(j != n - 1){
                    out.print(moves[i][j] + " ");
                }
                else{
                    out.print(moves[i][j]);
                }
            }
            out.println();
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









