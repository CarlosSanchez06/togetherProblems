// You are given a string s. You can convert s to a palindrome by adding characters in front of it.
// Return the shortest palindrome you can find by performing this transformation. LeetCode - 214
import java.util.*;
import java.util.stream.Collectors;

public class ShortestPalindrome{
    public String ShortestPalindrome(String s) {
        char[] c = s.toCharArray();
        List<Character> palindrome = new ArrayList<>();
        for (char ch : c) {
            palindrome.add(ch); // Autoboxing de char a Character
        }
        List<Character> palindromeAux = new ArrayList<Character>(palindrome);
        int j= palindrome.size() -1;
        while(!IsPalindrome(palindrome))
        {
            palindrome.remove(palindrome.size() -1);
        }
        int index = palindrome.size();
        int posfix = palindromeAux.size() - index;
        int initialSize = palindromeAux.size();
        for (int i = index; i <  palindromeAux.size(); i=i+2)
        {
            palindromeAux.add(0, palindromeAux.get(i));
        }
        
        return palindromeAux.stream().map(Object::toString)
                        .collect(Collectors.joining(""));
    }

    public Boolean IsPalindrome(List<Character> list){
        int j= list.size() -1;
        for (int i = 0; i < list.size()/2; i++)
        {
            if (list.get(i) != list.get(j))
                return false;
            j--;
        }
        return true;
    }
}


