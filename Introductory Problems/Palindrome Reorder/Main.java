import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int freq[] = new int[26];
        int oddCount = 0;
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);

            freq[c - 'A'] ++;
        }

        int count = 0;
        char c = '-';
        for(int i = 0; i < 26; i ++){
            if(freq[i] % 2 == 1){
                count ++;
                c = (char)(i + 'A');
                if(count == 2){
                    System.out.println("NO SOLUTION");
                    return;
                }
            }
        }

        StringBuilder stb = new StringBuilder();

        for(int i = 0; i < 26; i ++){

            for(int j = 1; j <= freq[i] / 2; j ++){
                stb.append((char)(i + 'A'));
            }
        }

        StringBuilder stbOrig = new StringBuilder(stb);
        
        String rev = stbOrig.reverse().toString();

        // System.out.println("Stb: " + stb + "Rev: " + rev);
    
        if(c != '-')
        stb.append(c);

        stb.append(rev);

        System.out.println(stb.toString());


    
    }
}