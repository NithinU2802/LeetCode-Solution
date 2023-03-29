/******************************************************************************

Given a m x n grid filled with non-negative numbers, find a path from top left 
to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.


Example 1:

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.


Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12


Note:
for eg 1:

1 3 1 
1 5 1 
4 2 1 

1+3+1+1+1=7

*******************************************************************************/

import java.util.*;

public class Main
{
    
    public static int maxPath(int[][] a){
        
        // store the length of the array 
        int n=a.length,m=a[0].length;
        
        // calculate route from starting to specific node in row 
        for(int i=1;i<n;i++)
        a[i][0]+=a[i-1][0];
        
        // calculate route from starting to specific node in column
        for(int j=1;j<m;j++)
        a[0][j]+=a[0][j-1];
        
        // as we calculate row and column path calculate min path and add with itself
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++) a[i][j]=Math.min(a[i-1][j],a[i][j-1])+a[i][j];
        }
        
        return a[n-1][m-1]; // return destination which we calculate min path
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	int m=x.nextInt();
	int[][] a=new int[n][m];
	for(int i=0;i<n;i++)
	for(int j=0;j<m;j++)
	a[i][j]=x.nextInt();
	System.out.println(maxPath(a));
	}
}
