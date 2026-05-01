import java.util.*;
import java.io.*;

public class countingRooms{

    // public static boolean dfsRecursion(char cArr[][] , int i, int j, int visited[][]){

    //     // Mark as visited
    //     visited[i][j] = 1;

    //     int directions[][] = {
    //         {-1, 0},
    //         {0, -1},
    //         {1, 0},
    //         {0, 1}
    //     };

    //     for(int direction[]: directions){
    //         int newX = i + direction[0];
    //         int newY = j + direction[1];

    //         if(newX >= 0 && newX < cArr.length && newY >= 0 && newY < cArr[0].length
    //             && visited[newX][newY] == 0 && cArr[newX][newY] == '.'){
    //                 dfsRecursion(cArr, i, j, visited)(cArr, newX, newY, visited);
    //         }
    //     }

    //     return true;
    // }

    public static boolean dfsIterative(char cArr[][], int i, int j, int visited[][]){
        Stack<int[]> st = new Stack<>();

        int direction[][] = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1}
        };

        st.push(new int[]{i, j});
        visited[i][j] = 1;

        while(!st.isEmpty()){

            int node[] = st.pop();

            for(int direc[]: direction){
                int newX = node[0] + direc[0];
                int newY = node[1] + direc[1];

                if(newX >= 0 && newX < cArr.length && newY >= 0 && newY < cArr[0].length
                    && visited[newX][newY] == 0 && cArr[newX][newY] == '.'){
                        visited[newX][newY] = 1;
                        st.push(new int[]{newX, newY});
                    }
            }
        }
        
        return true;
    }

    public static boolean bfs(char cArr[][], int i, int j, int visited[][]){
        Queue<int[]> q = new LinkedList<>();

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

            for(int direc[]: direction){
                int newX = node[0] + direc[0];
                int newY = node[1] + direc[1];

                if(newX >= 0 && newX < cArr.length && newY >= 0 && newY < cArr[0].length
                    && visited[newX][newY] == 0 && cArr[newX][newY] == '.'){
                        visited[newX][newY] = 1;
                        q.offer(new int[]{newX, newY});
                }
            }
        }
        
        return true;
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

       // Count Rooms using dfs - recursive, dfs - iterative, bfs
       int roomCount = 0;
       int visited[][] = new int[n][m];

    //    for(int i = 0; i < n; i ++){
    //     for(int j = 0; j < m; j ++){
    //         if(cArr[i][j] == '.' && visited[i][j] == 0){
    //             if(bfs(cArr, i, j, visited)){
    //                 roomCount ++;
    //             };
    //         }
    //     }
    //    }

    // Using a disjoint set union

    DSU disjointSet = new DSU(n * m);
       for(int i = 0; i < n; i ++){
        for(int j = 0; j < m; j ++){
            if(cArr[i][j] == '.' ){
                
                int flattenedInd = i * m + j;

                if(i + 1 < n && j < m && cArr[i + 1][j] == '.'){
                    disjointSet.union(flattenedInd, (i + 1) * m + j);
                }
                if(i < n && j + 1 < m && cArr[i][j + 1] == '.'){
                    disjointSet.union(flattenedInd, i * m + (j + 1));
                }
            }
            else{
                disjointSet.setParentAsNegative(i * m +  j);
            }
        }
       }

       Set<Integer> uniqueComponents = new HashSet<>();

       for(int i = 0; i < n * m; i ++){

            int row = i / m;
            int col = i % m;

            if(cArr[row][col] == '.'){
                uniqueComponents.add(disjointSet.find(i));
            }
       }

       out.println(uniqueComponents.size());

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