/*

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter 
in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains 
lowercase letters separated by a single space.

 */
package wordpattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ali_hassan_syed
 */
public class WordPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println(wordPattern("abba", "dog cat cat fish")); //output false
        System.out.println(wordPattern("abba", "dog cat cat dog")); //output true
        System.out.println(wordPattern("abbd", "dog cat cat fish")); // output true
        System.out.println(wordPattern("abca", "dog cat fish dog")); // output true
    }
    
    public static boolean wordPattern(String pattern, String str) 
    {
        String[] splittedString = str.split(" ");
        if (splittedString.length != pattern.length())
            return false;
        
        Map<String, Character> map = new HashMap<>();
        Set<Character> seen = new HashSet<>();
        char p_char;
        
        for (int i=0; i<pattern.length(); i++)
        {
            p_char = pattern.charAt(i);
            if (map.get(splittedString[i]) == null && !seen.contains(p_char))
            {
                map.put(splittedString[i], p_char);
                seen.add(p_char);
            }
            else if (map.get(splittedString[i]) == null || p_char != map.get(splittedString[i]))
                return false;
        }
        
        return true;
    }
    
}
