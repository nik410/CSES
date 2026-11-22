import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = sc.nextInt();

        int grid[][] = new int[n][n];

        // // Brute Force
        // mexGridConstructionBruteForce(n, grid);
        // printMexGrid(n, grid, out);

        // Optimised XOR approach mostly observational
        mexGridConstructionXor(n, grid);
        printMexGrid(n, grid, out);
        

        out.close();
    }

    //Print Grid
    public static void printMexGrid(int n, int grid[][], PrintWriter out){
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                if(j == n- 1){
                    out.print(grid[i][j]);
                }
                else
                out.print(grid[i][j] + " ");
            }
            out.println();
        }
    }

    // Xor approach
    public static void mexGridConstructionXor(int n, int grid[][]){
        
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                grid[i][j] = (i ^ j);
            }
        }
    }
        
    // Brute force approach
    public static void mexGridConstructionBruteForce(int n, int grid[][]){
            TreeSet<Integer> valueStore = new TreeSet<>();

            for(int i = 0; i <= 3 * n; i ++){
                valueStore.add(i);
            }


            for(int i = 0; i < n; i ++){
                for(int j = 0; j < n; j ++){

                    TreeSet<Integer> storeForCurrEle = new TreeSet<>(valueStore);

                    // Calculate left side
                    for(int k = 0; k < j; k ++){
                        storeForCurrEle.remove(grid[i][k]);
                    }

                    // Calculate upper side
                    for(int k = 0; k < i; k ++){
                        storeForCurrEle.remove(grid[k][j]);
                    }

                    grid[i][j] = storeForCurrEle.first();
                }
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