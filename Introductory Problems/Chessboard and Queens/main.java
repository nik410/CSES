import java.util.*;

public class main{

    static int rowD[] = new int[8];
    static int colD[] = new int[8];
    static int diagonal1[] = new int[16];
    static int diagonal2[] = new int[16];

    public static int placeQueens(char arr[][], int row){

        if(row == 8){
            return 1;
        }

        int count = 0;

        for(int col = 0; col < 8; col ++){
            
                
                if(arr[row][col] == '.' && rowD[row] == 0 && colD[col] == 0 && diagonal1[row - col + 7] == 0 && diagonal2[row + col] == 0){

                    arr[row][col] = 'Q';

                    rowD[row] = 1;
                    colD[col] = 1;
                    diagonal1[row - col + 7] = 1;
                    diagonal2[row + col] = 1;
                   
                    count += placeQueens(arr, row + 1);
                    
                    arr[row][col] = '.';

                    rowD[row] = 0;
                    colD[col] = 0;
                    diagonal1[row - col + 7] = 0;
                    diagonal2[col + row] = 0;
                    
                }
            
        }

        return count;

    }



      
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

       char arr[][] = new char[8][8];

       for(int i = 0; i < 8; i ++){
        arr[i] = sc.next().toCharArray();
       }

        long startTime = System.nanoTime();

        int ways = placeQueens(arr, 0);

        System.out.println(ways);
        
        long endTime = System.nanoTime();
        double totalTime = (double)(endTime - startTime)/ 1_000_000_000;
        // System.out.println("Total Time: "+ totalTime);

        // System.out.println(" Size: " + al.size());
    }
}
