import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int mod = (int)(1e9 + 7);
        int ans = 1;
        for(int i = 1; i <= n; i ++){
            ans *= 2;
            ans %= mod;
        }

        System.out.println(ans);

    
    }
}