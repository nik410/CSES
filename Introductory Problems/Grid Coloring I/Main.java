import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = sc.nextInt();
        int m = sc.nextInt();

        char grid[][] = new char[n][m];

        for(int i = 0; i < n; i ++){
            String s = sc.next();
            grid[i] = s.toCharArray();
        }

        int adjacentIndex[][] = {
            {-1, 0},
            {0, -1}
            // {1, 0},
            // {0, 1}
        };

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                char curr = grid[i][j];

                int occur[] = {0, 0, 0, 0};
                occur[curr - 'A'] ++;

                for(int dir[]: adjacentIndex){
                    int newX = dir[0] + i;
                    int newY = dir[1] + j;

                    if(newX >= 0 && newX < n && newY >= 0 && newY < m){
                        occur[grid[newX][newY] - 'A'] ++;
                    }
                }

                for(int k = 0; k < 4; k ++){
                    if(occur[k] == 0){
                        grid[i][j] = (char)(k + 'A');
                        break;
                    }
                    if(k == 3 && occur[k] > 0){
                        out.print("IMPOSSIBLE");
                        return;
                    }
                }
                // out.println("i: "+ i + " j: " + j + " val: " + grid[i][j]);
            }
        }

        // out.println("--- Answer ---");

        printColorGrid(grid, out);

        out.close();
    }

    //Print Grid
    public static void printColorGrid(char grid[][], PrintWriter out){
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                out.print(grid[i][j]);
            }
            out.println();
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