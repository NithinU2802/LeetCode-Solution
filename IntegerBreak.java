/******************************************************************************

Given an integer n, break it into the sum of k positive integers, where k >= 2, 
and maximize the product of those integers.

Return the maximum product you can get.

 

Example 1:

Input: n = 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.
Example 2:

Input: n = 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	int r=1;
	while(n>4){
	    n-=3;
	    r*=3;
	}
	System.out.println(n*r);
	}
}
