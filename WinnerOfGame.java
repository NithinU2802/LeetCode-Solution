/******************************************************************************
 
There are n pieces arranged in a line, and each piece is colored either by 'A' or
by 'B'. You are given a string colors of length n where colors[i] is the color of
the ith piece.

Alice and Bob are playing a game where they take alternating turns removing pieces 
from the line. In this game, Alice moves first.

Alice is only allowed to remove a piece colored 'A' if both its neighbors are also 
colored 'A'. She is not allowed to remove pieces that are colored 'B'.
Bob is only allowed to remove a piece colored 'B' if both its neighbors are also 
colored 'B'. He is not allowed to remove pieces that are colored 'A'.

Alice and Bob cannot remove pieces from the edge of the line.
If a player cannot make a move on their turn, that player loses and the other player wins.
Assuming Alice and Bob play optimally, return true if Alice wins, or return false if Bob wins.

 

Example 1:

Input: colors = "AAABABB"
Output: true
Explanation:
AAABABB -> AABABB
Alice moves first.
She removes the second 'A' from the left since that is the only 'A' whose neighbors are both 'A'.

Now it's Bob's turn.
Bob cannot make a move on his turn since there are no 'B's whose neighbors are both 'B'.
Thus, Alice wins, so return true.
Example 2:

Input: colors = "AA"
Output: false
Explanation:
Alice has her turn first.
There are only two 'A's and both are on the edge of the line, so she cannot move on her turn.
Thus, Bob wins, so return false.
Example 3:

Input: colors = "ABBBBBBBAAA"
Output: false
Explanation:
ABBBBBBBAAA -> ABBBBBBBAA
Alice moves first.
Her only option is to remove the second to last 'A' from the right.

ABBBBBBBAA -> ABBBBBBAA
Next is Bob's turn.
He has many options for which 'B' piece to remove. He can pick any.

On Alice's second turn, she has no more pieces that she can remove.
Thus, Bob wins, so return false.
 

Constraints:

1 <= colors.length <= 105
colors consists of only the letters 'A' and 'B'

******************************************************************************/

import java.util.*;

class WinnerOfGame {
    public boolean winnerOfGame(String colors) {
    int a=0,b=0,c=0,i=0;
    while(i<colors.length()){
        if(colors.charAt(i)=='A'){
            c=0;
            while(i<colors.length() && colors.charAt(i)=='A'){
                c++;
                i++;
            }
            if(c>2)
                a+=(c-2);
        }else{
            c=0;
             while(i<colors.length() && colors.charAt(i)=='B'){
                c++;
                i++;
            }
            if(c>2)
                b+=(c-2);
        }
    }
    int f=0;
    while(a>=0 || b>=0){
        if(f==0){
            if(a<=0)
                return false;
            else
                a--;
            f=1;
        }else{
            if(b<=0)
                return true;
            else
                b--;
            f=0;
        }
    }
    return false;
    }
}

public class Main
{
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String s=x.nextLine();
	Solution solution=new Solution();
	System.out.println(solution.winnerOfGame(s));
	}
}
