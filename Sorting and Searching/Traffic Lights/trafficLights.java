import java.util.*;
import java.io.*;

public class trafficLights{

    public static void main(String[] args){
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int x, n;
        x = sc.nextInt();
        n = sc.nextInt();
       
        int arr[] = new int[n];

        for(int i = 0; i < n; i ++){
           arr[i] = sc.nextInt();
        }

        TreeSet<Integer> ts = new TreeSet<>();

        ts.add(0);
        ts.add(x);

        TreeMap<Integer, Integer> distanceFreq = new TreeMap<>();
        distanceFreq.put(x, 1);

        for(int i = 0; i < n; i ++){
            
            int lightPosition = arr[i];

            int closestToLeft = ts.lower(lightPosition);
            int closestToRight = ts.higher(lightPosition);

            //Remove the prev segment
            int segmentBeingIntersected = closestToRight - closestToLeft;

            if(distanceFreq.get(segmentBeingIntersected) == 1){
                distanceFreq.remove(segmentBeingIntersected);
            }
            else{
                distanceFreq.put(segmentBeingIntersected, distanceFreq.get(segmentBeingIntersected) - 1);
            }
     
            int passage1 = lightPosition - closestToLeft;
            int passage2 = closestToRight - lightPosition;

            //Adding new segments

            distanceFreq.put(passage1, distanceFreq.getOrDefault(passage1, 0) +  1);
            distanceFreq.put(passage2, distanceFreq.getOrDefault(passage2, 0) +  1);

            ts.add(lightPosition);

           out.println(distanceFreq.lastKey());

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