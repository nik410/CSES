import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int nums[] = new int[n - 1];

        for(int i = 0; i < n - 1; i ++){
            nums[i] = sc.nextInt();
        }

        // Using Math
        // We know that sum of natural number (1 to Infinity and Beyond) for a range [1, n]
        // sum = n  * (n + 1) / 2
        
        // So we can leverage this formula to find sum of all the number form 1 to n
        // Then find sum of the array and substract totalSum  to the arraySum 
        // Giving us the missing number

        // long totalSum = ((n +  1) * (n + 2)) / 2;

        // long arraySum = Arrays.stream(nums).sum();
        
        // long missingNumber = totalSum - arraySum;

        // System.out.println(missingNumber);
        
    // -----------------------------------------------------

        //       -
        //      ---
        //     ----- 
        //      0 0
        //       ~
        // Using Bitwise Operator
        
        // We can take into the XOR bitwise operator  properties to find the missing value
        // It is known that for any value n ; (n ^ n) = 0

        // So if we XOR all the values in the array and numbers till n + 1
        // We can prove that except the missing number we will have two values of all the other numbers

        int missing = 0;

        for(int i = 0; i < n - 1; i ++){
                missing ^= nums[i];
                missing ^= i + 1;
           
        }

        missing ^= n;

        System.out.println(missing);

        // Then theres using a freq array to store frequency 
        // if the frequency is zero that is the culprit


        
    }


}