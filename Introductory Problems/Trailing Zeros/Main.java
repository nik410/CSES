import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // The trailing zeroes to any answer will be contributed by 10^ n values
        // (10 ^ n) = (2 ^ n) * (5 ^ n)
        // Using the legrande theorem to find the higest power of prime p in a factorial

        // Vp(n!) = Sum(k =1- Infinity)(Floor(n/p^k))

        // We have to chose min( V2(n!),  V5(n!))
        // As V5(n!) will always be lesser than V2(n!) 
        
        int ans = 0;

        int power = 5;

        for(int i = 0;; i ++){
            if(n/ power == 0){
                break;
            }
            else{
                ans += n / power;
                power *= 5;
            }
        }

        System.out.println(ans);
    
    }
}