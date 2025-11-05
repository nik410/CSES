    import java.util.*;
    import java.io.*;

    public class Main{
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();

            int lengthOfLongestRepetition = 0;

            char prev = 'Z';
            int currCount = 0;
            for(int i = 0; i < s.length(); i ++){
                char c = s.charAt(i);

                if(c == prev){
                    currCount ++;
                }
                else{
                    lengthOfLongestRepetition = Math.max(currCount, lengthOfLongestRepetition);
                    currCount = 1;
                    prev = c;
                }
            }

            lengthOfLongestRepetition = Math.max(currCount, lengthOfLongestRepetition);

            System.out.println(lengthOfLongestRepetition);
        
        }
    }