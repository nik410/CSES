    import java.util.*;
    import java.io.*;

    public class roomAllocation{

        public static void main(String[] args){
            FastReader sc = new FastReader();
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

            int n;
            n = sc.nextInt();
            
            int interval[][] = new int[n][3];
            TreeSet<Integer> roomsFree = new TreeSet<>();

            for(int i = 0; i < n; i ++){
                interval[i][0] = sc.nextInt();
                interval[i][1] = sc.nextInt();
                // Original Index is stored for future use
                interval[i][2] = i;
                roomsFree.add(i + 1);
            }

            // Sorting of the data needs to be done on the basis of start time
            // as we need to minimize the

            Arrays.sort(interval, (x, y) -> {
                if(x[0] == y[0]){
                    return x[1] - y[1];
                }
                else
                return x[0] - y[0];
            });
            
            PriorityQueue<Integer[]> roomInUse = new PriorityQueue<>((x, y) -> {
                if(x[1] == y[1]){
                    return x[0] - y[0];
                }
                else{
                    return x[1] - y[1];
                }
            });

            roomInUse.offer(new Integer[]{1, interval[0][1]});
            roomsFree.remove(1);
            int prevPersonExit = interval[0][1];

            int roomNumber[] = new int[n];
            roomNumber[interval[0][2]] = 1;

            for(int i = 1; i < n; i ++){
                int entryDay = interval[i][0];
                int exitDay = interval[i][1];
                int originalIndex = interval[i][2];

                if(!roomInUse.isEmpty()){
                    Integer earliestFreeRoom[] = roomInUse.peek();

                    if(earliestFreeRoom[1] < entryDay){
                        Integer currRoom[] = roomInUse.poll();
                        roomsFree.add(currRoom[0]);
                    }
                }

                if(entryDay > prevPersonExit){
                    int lowestRoom = roomsFree.first();

                    roomsFree.remove(lowestRoom);

                    roomInUse.offer(new Integer[]{lowestRoom, exitDay});

                    roomNumber[originalIndex] = lowestRoom;
                }
                else{
                    int lowestRoom = roomsFree.first();

                    roomsFree.remove(lowestRoom);

                    roomInUse.offer(new Integer[]{lowestRoom, exitDay});

                    roomNumber[originalIndex] = lowestRoom;
                }

                prevPersonExit = exitDay;
            }

            out.println(roomInUse.size());

            for(int i: roomNumber){
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