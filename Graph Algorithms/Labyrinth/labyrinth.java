import java.util.*;
import java.io.*;

public class labyrinth{

    // public static boolean dfsRecursion(char cArr[][] , int i, int j, int visited[][], StringBuilder stb, String[] shortestPath){
        
    //     if (cArr[i][j] == 'B') {
    //         if(shortestPath[0].length() > stb.length())
    //         shortestPath[0] = stb.toString();
    //     }

    //     visited[i][j] = 1;

    //     int direction[][] = {
    //         {-1, 0, (int)('U')},
    //         {0, -1, (int)('L') },
    //         {1, 0, (int)('D')},
    //         {0, 1, (int)('R')}
    //     };

    //     for(int direc[]: direction){
    //         int newX = i + direc[0];
    //         int newY = j + direc[1];

    //         char dir = (char)(direc[2]);

    //         if(newX >= 0 && newX < cArr.length && newY >= 0 && newY < cArr[0].length
    //             && visited[newX][newY] == 0){
    //                 if(cArr[newX][newY] != '#'){
    //                     stb.append(dir);
    //                     dfsRecursion(cArr, newX, newY, visited, stb, shortestPath);
                        
    //                     if(stb.length() > 0){
    //                         stb.deleteCharAt(stb.length() - 1);
    //                     }
    //                 }
    //         }
    //     }

    //     visited[i][j] = 0;
    //     return false; 
    // }

    // public static boolean dfsIterative(char cArr[][], int i, int j, int visited[][]){
    //     Stack<int[]> st = new Stack<>();

    //     int direction[][] = {
    //         {-1, 0},
    //         {0, -1},
    //         {1, 0},
    //         {0, 1}
    //     };

    //     st.push(new int[]{i, j});
    //     visited[i][j] = 1;

    //     while(!st.isEmpty()){

    //         int node[] = st.pop();

    //         for(int direc[]: direction){
    //             int newX = node[0] + direc[0];  
    //             int newY = node[1] + direc[1];

    //             if(newX >= 0 && newX < cArr.length && newY >= 0 && newY < cArr[0].length
    //                 && visited[newX][newY] == 0 && cArr[newX][newY] == '.'){
    //                     visited[newX][newY] = 1;
    //                     st.push(new int[]{newX, newY});
    //                 }
    //         }
    //     }
        
    //     return true;
    // }

    public static String bfs(char cArr[][], int i, int j, int visited[][]){
        Queue<int[]> q = new LinkedList<>();

        int parentPos[][][] = new int[cArr.length][cArr[0].length][2];
        int endX = -1;
        int endY = -1;
        boolean found = false;

        int direction[][] = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1}
        };

        q.offer(new int[]{i, j});

        visited[i][j] = 1;

        while(!q.isEmpty()){
            int node[] = q.poll();

            if (cArr[node[0]][node[1]] == 'B') {
                endX = node[0]; endY = node[1];
                found = true;
                break; 
            }

            for(int direc[]: direction){
                int newX = node[0] + direc[0];
                int newY = node[1] + direc[1];

                if(newX >= 0 && newX < cArr.length && newY >= 0 && newY < cArr[0].length
                    && visited[newX][newY] == 0 && cArr[newX][newY] != '#'){
                        visited[newX][newY] = 1;
                        q.offer(new int[]{newX, newY});

                        parentPos[newX][newY] = new int[]{node[0], node[1]};
                }
            }
        }

        if(!found)return "";


        StringBuilder path = new StringBuilder();
        int currX = endX;
        int currY = endY;

        while(currX != i || currY != j){
            int prev[] = parentPos[currX][currY];
            
            if (currX > prev[0]) path.append("D");
            else if (currX < prev[0]) path.append("U");
            else if (currY > prev[1]) path.append("R");
            else if (currY < prev[1]) path.append("L");

            currX = prev[0];
            currY = prev[1];
        }
        
        return path.reverse().toString();
    }

    public static void main(String[] args){
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

       int n, m;
       n = sc.nextInt();
       m = sc.nextInt();

       char cArr[][] = new char[n][m];

       for(int i = 0; i < n; i ++){
            String s = sc.next();
            cArr[i] = s.toCharArray();
       }

       // Count Rooms using dfs - recursive
       int roomCount = 0;
       int visited[][] = new int[n][m];
    //    StringBuilder stb = new StringBuilder();
    //    String path[] = { "" };


    //    for(int i = 0; i < n; i ++){
    //     for(int j = 0; j < m; j ++){
    //         if(cArr[i][j] == 'A' && visited[i][j] == 0){
    //             boolean steps = dfsRecursion(cArr, i, j, visited, stb, path);
                
    //         }
    //     }
    //    }
    // Very( Extreme ) bad approach as it is a exhaustibe search with backtracking it will take 3 ^(n + m)
    // Not a good approach 

    String path = "";

    for(int i = 0; i < n; i ++){
        for(int j = 0; j < m; j ++){
            if(cArr[i][j] == 'A' && visited[i][j] == 0){
                path = bfs(cArr, i, j, visited);
                
            }
        }
       }

       if(path.length() == 0){
        out.println("NO");
       }
       else{
        out.println("YES");
        out.println(path.length());
        out.println(path);
       }


       // Bitset can be used in place of a visited arrray
       // internally it is basically storing long[] where each  bit of a long value (64 bits)
       // is used. and mathematically we can get if that bit is flipped or not

       // BitSet visited = new BitSet(totalNodes);
       // Has the set and get methods

        // visited.set(index); 
        // if (visited.get(index)) { 
        //     // Already visited logic
        // }


        out.flush();
        out.close();  

    }

    static class DSU{
        int parent[];

        DSU(int totalNodes){
            parent = new int[totalNodes];
            for(int i = 0; i < totalNodes; i ++){
                parent[i] = i;
            }
        }

        // For case when the cell is a wall
        // optional we can just while counting the unique components at last only count the '.' components
        void setParentAsNegative(int node){
            parent[node] = -1;
        }

        void union(int node1, int node2){
            int root1 = find(node1);
            int root2 = find(node2);

            if(root1 != root2){
                parent[root1] = root2;
            }
        }

        public int find(int node){
            if(parent[node] == node) return node;
            return parent[node] = find(parent[node]);
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