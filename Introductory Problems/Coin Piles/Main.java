import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i ++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int min = Math.min(a, b);
            int max = Math.max(a, b);

            if((a + b) % 3 == 0){
                if(max > min * 2){
                    System.out.println("NO");
                }
                else
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }

            
        }
    
    }
}