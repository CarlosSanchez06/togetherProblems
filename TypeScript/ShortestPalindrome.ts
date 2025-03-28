function shortestPalindrome(s: string): string {
    let palindrome: string[] = s.split('');
    let palindromeAux: string[] = [...palindrome];
    let j= palindrome.length -1;

    while(!isPalindrome(palindrome))
    {
        palindrome.pop();
    }
    const index = palindrome.length;
    const posfix = palindromeAux.length - index;
    const initialSize = palindromeAux.length;
    for (let i = index; i <  palindromeAux.length; i=i+2)
    {
        palindromeAux.unshift(palindromeAux[i]);
    }
    
    return palindromeAux.join('');
}

function isPalindrome(list: string[]): boolean {
    let j: number = list.length - 1;
    for (let i = 0; i < Math.floor(list.length / 2); i++) {
        if (list[i] !== list[j])
            return false;
        j--;
    }
    return true;
}