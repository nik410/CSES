    import java.util.*;
    import java.io.*;

    public class Main{
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            if(n == 2 || n == 3){
                System.out.println("NO SOLUTION");
                return;
            }
            
            int even = 2;

            while(even <= n){
                System.out.print(even + " ");
                even += 2;
            }

            int odd = 1;
            
            while(odd <= n){
               System.out.print(odd + " ");
                odd += 2;
            }

        }
    }