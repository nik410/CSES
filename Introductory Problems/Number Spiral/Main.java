    import java.util.*;
    import java.io.*;

    public class Main{
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            for(int i = 0; i < n; i ++){
                long x = sc.nextLong();
                long y = sc.nextLong();

                long max = Math.max(x, y);

                // Do not use the inbuilt Math.pow functions its gives incorrect answer for larger values
                 

                long l = (max - 1) * (max - 1) +  1 ;
                long r = (max * max);

                long ans = 0;

                if(y == max){
                    if(y % 2 == 1){
                        ans = r - (x - 1);
                    }
                    else{
                        ans = l  + (x - 1);
                    }
                }
                else{
                    if(x % 2 == 0){
                        ans = r - (y - 1);
                    }
                    else{
                        ans = l + (y - 1);
                    }
                }

                System.out.println(ans);

            }

          
        }
    }