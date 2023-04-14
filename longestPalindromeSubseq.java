/******************************************************************************

Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting 
some or no elements without changing the order of the remaining elements.

 

Example 1:
Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".

Working:
1 2 3 3 4
  1 2 2 3
    1 1 3
      1 1
        1

Example 2:
Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".

*******************************************************************************/

import java.util.*;

public class Main
{
    
    public static int longestPalindromeSubseq(String s){
    int[][] m=new int[s.length()][s.length()];
    for(int i=s.length()-1;i>=0;i--){
        m[i][i]=1;
        for(int j=i+1;j<s.length();j++){
        if(s.charAt(i)==s.charAt(j))
        m[i][j]=m[i+1][j-1]+2;
        else m[i][j]=Math.max(m[i+1][j],m[i][j-1]);
        }
    }
    return m[0][s.length()-1];
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String s=x.nextLine();
	System.out.println(longestPalindromeSubseq(s));
	}
}
