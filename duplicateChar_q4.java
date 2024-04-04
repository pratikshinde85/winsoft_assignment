import java.util.HashMap;
import java.util.*;

public class duplicateChar_q4 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        
       
        str = str.toLowerCase();
        
       
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
         
            if (ch != ' ') {
               
                charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
            }
        }
        
       
        System.out.println("Duplicate characters in the string:");
        for (char ch : charCountMap.keySet()) {
            if (charCountMap.get(ch) > 1) {
                System.out.println(ch);
            }
        }
    }
}
