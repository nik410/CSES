import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        while(n >= 1){
            System.out.println(n);

            if(n == 1)break;

            if((n & 1) == 1){
                n = n * 3 + 1;
            }
            else{
                n = n / 2; 
            }
        }
    }
}