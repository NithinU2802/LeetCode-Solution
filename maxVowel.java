/******************************************************************************

Given a string s and an integer k, return the maximum number of vowel letters in
any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.


*******************************************************************************/

import java.util.*;

public class Main
{
    public static boolean isVowel(char a){
        a=Character.toLowerCase(a);
        if(a=='a' || a=='e' || a=='i' || a=='o' || a=='u') 
        return true;
        return false;
    }
    
    public static int maxVowel(String s,int k){
    int r=0,res=0;
    
    for(int i=0;i<k;i++)
    if(isVowel(s.charAt(i))) r++;
    
    if(r>res) res=r;
    if(k==s.length()) return res;
    
    for(int i=k;i<s.length();i++){
    if(isVowel(s.charAt(i))) r++;
    if(isVowel(s.charAt(i-k))) r--;
    if(res<r) res=r;
    }
    return res;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String s=x.nextLine();
	int k=x.nextInt();
	System.out.println(maxVowel(s,k));
	
	}
}
