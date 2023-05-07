/******************************************************************************

You want to build some obstacle courses. You are given a 0-indexed integer array
obstacles of length n, where obstacles[i] describes the height of the ith obstacle.

For every index i between 0 and n - 1 (inclusive), find the length of the longest
obstacle course in obstacles such that:

1. You choose any number of obstacles between 0 and i inclusive.
2. You must include the ith obstacle in the course.
3. You must put the chosen obstacles in the same order as they appear in obstacles.
4. Every obstacle (except the first) is taller than or the same height as the obstacle 
immediately before it.
5. Return an array ans of length n, where ans[i] is the length of the longest obstacle 
course for index i as described above.

 

Example 1:

Input: obstacles = [1,2,3,2]
Output: [1,2,3,3]
Explanation: The longest valid obstacle course at each position is:
- i = 0: [1], [1] has length 1.
- i = 1: [1,2], [1,2] has length 2.
- i = 2: [1,2,3], [1,2,3] has length 3.
- i = 3: [1,2,3,2], [1,2,2] has length 3.


Example 2:

Input: obstacles = [2,2,1]
Output: [1,2,1]
Explanation: The longest valid obstacle course at each position is:
- i = 0: [2], [2] has length 1.
- i = 1: [2,2], [2,2] has length 2.
- i = 2: [2,2,1], [1] has length 1.


Example 3:

Input: obstacles = [3,1,5,6,4,2]
Output: [1,1,2,3,2,2]
Explanation: The longest valid obstacle course at each position is:
- i = 0: [3], [3] has length 1.
- i = 1: [3,1], [1] has length 1.
- i = 2: [3,1,5], [3,5] has length 2. [1,5] is also valid.
- i = 3: [3,1,5,6], [3,5,6] has length 3. [1,5,6] is also valid.
- i = 4: [3,1,5,6,4], [3,4] has length 2. [1,4] is also valid.
- i = 5: [3,1,5,6,4,2], [1,2] has length 2.


// Read twice the below statement to understand the problem..

Problem Explanation:
   Here we are given with array consist of obstacles need to traverse and identify 
the small obstacle also avoid larger obstacle and collect the count of sequence of 
small obstacle and store in the resultant array...!

Solution:
   Here I am create an result array to load the count of sequence of obstacle small 
as the element in it.

   Now make an stack to load the largest sequence of array by below conditions..!
          1. if the peek of stack less then equal to element of array push element 
        in to the stack and load the stack size to the result/
          2. else we need to use binary search and identify the best area to load 
        the element to the stack and replace it. Then store the element in the 
        middle of the array.
    Hence the results are stored on res array now Return to Main inorder to 
print the values..!


*******************************************************************************/

import java.util.*;

class Solution{
    
    public int[] longestObstacleCourseAtEachPosition(int obstacles[]){
    int n=obstacles.length;
    
    // initialize the array res and stack...!
    int[] res=new int[n];
    int[] stack=new int[n];
    
    // core operations
    int top=-1;
    for(int i=0;i<n;i++){
        if(top==-1 || stack[top]<=obstacles[i]){ // load the element whether less or empty stack
            stack[++top]=obstacles[i];
            res[i]=top+1;
        }else{
            int s=0,e=top,m; // now use binary search to identify the location where I can store 
            while(s<e){
                m=(s+e)/2;
                if(stack[m]<=obstacles[i]) s=m+1;
                else e=m;
            }
            stack[e]=obstacles[i];
            res[i]=e+1;
        }
    }
    return res;
    }
}

public class Main
{
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	int[] a=new int[n];
	for(int i=0;i<n;i++)
	a[i]=x.nextInt();
	Solution s=new Solution();
	for(int i:s.longestObstacleCourseAtEachPosition(a))
	System.out.print(i+" ");
	}
}
