from typing import List

class Solution:
    def shortestPalindrome(self, s: str) -> str:
        palindrome = list(s)
        palindromeAux = palindrome.copy()
        j= len(palindrome) -1
        while(not self.IsPalindrome(palindrome)):
            palindrome.pop(len(palindrome) -1)
        
        index = len(palindrome)
        i=index
        sizePalindrome = len(palindromeAux)
        while(i < sizePalindrome ):
            palindromeAux.insert(0, palindromeAux[i])
            i = i + 2
            sizePalindrome = len(palindromeAux)
        print(''.join(palindromeAux))
        return ''.join(palindromeAux)
        
    def IsPalindrome(self,lista) -> bool:
        j = len(lista) - 1
        for i in range(len(lista)//2):
            if (lista[i] != lista[j]):
                return False
            j = j-1
        return True