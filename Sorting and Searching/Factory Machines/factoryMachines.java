    import java.util.*;
    import java.io.*;

    public class factoryMachines{

        public static boolean checkFuntion(int arr[], int t, long time){
            long productMade = 0;

            for(int i: arr){
                long prodByMachineX = time / (long)i;  
                productMade += prodByMachineX;
                if(productMade > t)break;
            }

            if(productMade >= t)return true;
            return false;
        }
        public static void main(String[] args){
            FastReader sc = new FastReader();
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

            int n, t;
            n = sc.nextInt();
            t = sc.nextInt();
            
            int arr[]= new int[n];

            for(int i = 0; i < n; i ++){
                arr[i] = sc.nextInt();
            }

            int minTimeOneProduct = Integer.MAX_VALUE;
            int maxTimeOneProduct = Integer.MIN_VALUE;

            for(int i: arr){
                minTimeOneProduct = Math.min(minTimeOneProduct, i);
                maxTimeOneProduct = Math.max(maxTimeOneProduct, i);
            } 

            long l = 0;
            long r = (long)maxTimeOneProduct * t;

            while(l <= r){
                long mid = l + (r - l) / 2;

                if(checkFuntion(arr, t, mid)){
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }
            }

            System.out.println(l);
            

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