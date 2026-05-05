import java.util.*;
import java.io.*;

public class buildingRoads{

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int node, BitSet visited){
        visited.set(node);

        for(int neighbour: adj.get(node)){
            if(!visited.get(neighbour)){
                dfs(adj, neighbour, visited);
            }
        }
        return;
    }

    public static void dfsIterative(ArrayList<ArrayList<Integer>> adj, int node, BitSet visited){
        Stack<Integer> st = new Stack<>();

        st.push(node);
       
        while(!st.isEmpty()){
            int n = st.pop();

            if(visited.get(n))continue;

            visited.set(n);

            for(int neigh: adj.get(n)){
                if(!visited.get(neigh)){
                    st.push(neigh);
                    
                }
            }
        }

        return;
    }

    public static void bfs(ArrayList<ArrayList<Integer>> adj, int node, BitSet visited){
        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.offer(node);
        visited.set(node);
        
        while(!q.isEmpty()){
            int n = q.poll();

            for(int neigh: adj.get(n)){
                if(!visited.get(neigh)){
                    q.offer(neigh);
                    visited.set(neigh);
                }
            }
        }

        return;
    }

    public static void main(String[] args){
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

       int n, m;
       n = sc.nextInt();
       m = sc.nextInt();

       int paths[][] = new int[m][2];

       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       for(int i = 0; i <= n; i ++){
        adj.add(new ArrayList<>());
       }

       for(int i = 0; i < m; i ++){
        int u = sc.nextInt();
        int v = sc.nextInt();

        paths[i][0] = u;
        paths[i][1] = v;

        adj.get(u).add(v);
        adj.get(v).add(u);
       }

    //    int countComponents = 0;

    //    BitSet visited = new BitSet(n);

    //    ArrayList<Integer> newRoads= new ArrayList<>();
       
    //    for(int i = 1; i <= n; i ++){
    //         if(!visited.get(i)){
    //             dfsIterative(adj, i, visited);
    //             countComponents ++;
    //             newRoads.add(i);
    //         }
    //    }

    //    out.println(countComponents - 1);
    //    for(int i = 0; i < newRoads.size() - 1; i ++){
    //     out.println(newRoads.get(i) + " " + newRoads.get(i + 1)); 
    //    }

       DSU d = new DSU(n + 1);
       
       for(int i = 0; i < m; i ++){
            int u = paths[i][0];
            int v = paths[i][1];

            d.union(u, v);
       }

        ArrayList<Integer> newRoads = d.getUniqueParents();

        // out.println("al: " + newRoads);

        out.println(newRoads.size() - 1);

        for(int i = 0; i < newRoads.size() - 1; i ++){
            out.println(newRoads.get(i) + " " + newRoads.get(i + 1));
        }


        out.flush();
        out.close();  

    }

    static class DSU{
        int parent[];
        int rank[];
        DSU(int totalNodes){
            parent = new int[totalNodes];
            rank = new int[totalNodes];
            for(int i = 0; i < totalNodes; i ++){
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public ArrayList<Integer> getUniqueParents(){
            TreeSet<Integer> unique = new TreeSet<>();
            ArrayList<Integer> al = new ArrayList<Integer>();

            for(int i = 1; i < parent.length; i ++){
                int p = find(parent[i]);
                if(!unique.contains(p)){
                    unique.add(p);
                }
            }

            for(int i: unique){
                al.add(i);
            }

            return al;

        }

        void union(int node1, int node2){
            int root1 = find(node1);
            int root2 = find(node2);

            if(root1 != root2){
                if(rank[root1] < rank[root2]){
                    parent[root1] = root2;
                }
                else if(rank[root1] > rank[root2]){
                    parent[root2] = root1;
                }
                else{
                    parent[root1] = root2;
                    rank[root2] ++;
                }
                
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