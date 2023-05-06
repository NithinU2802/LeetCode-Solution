/***************************************************************************************************

You are given an array of integers nums and an integer target.

Return the number of non-empty subsequences of nums such that the sum of the
minimum and maximum element on it is less or equal to target. Since the answer
may be too large, return it modulo 109 + 7.

 

Example 1:

Input: nums = [3,5,6,7], target = 9
Output: 4
Explanation: There are 4 subsequences that satisfy the condition.
[3] -> Min value + max value <= target (3 + 3 <= 9)
[3,5] -> (3 + 5 <= 9)
[3,5,6] -> (3 + 6 <= 9)
[3,6] -> (3 + 6 <= 9)
Example 2:

Input: nums = [3,3,6,8], target = 10
Output: 6
Explanation: There are 6 subsequences that satisfy the condition. (nums can have repeated numbers).
[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
Example 3:

Input: nums = [2,3,3,4,6,7], target = 12
Output: 61
Explanation: There are 63 non-empty subsequences, two of them do not satisfy the condition ([6,7], [7]).
Number of valid subsequences (63 - 2 = 61).


Problem Explanation:
we are given with an array and the target element our task to find the maximum subsequences that sum to get 
the value below the target ...!

Solution:
Firstly sort the array as we need to ignore beyond the target elements...!
        As per the statement we need to find the possible sequence over the range which is below the 
given formula, pow(2,start-end) to find range(start-end) and power to get possible sequence...!
        Now we need to grab the sequence as traverse with two pointers left(s) and right(e) the make
sum of these the return the value as result.


*******************************************************************************************************/

import java.util.*;

public class Main
{
    public static int numSubseq(int[] nums,int target){
    int s=0,e=nums.length-1,MOD=1000000007,c=0;
    int[] gp=new int[e+1]; // gp represent 1 2 4 8 16 32 64 as sequence..!
    gp[0]=1;
    for(int i=1;i<=e;i++)
    gp[i]=gp[i-1]*2;
    
    // load the result for the given array...
    while(s<=e){
        if(nums[s]+nums[e]>target){ 
            e--; // reduce end to find atmost range 
            continue;
        }
        c=(int)(c+(Math.pow(2,e-s)))%MOD; // As per the statement we may also get result beyond the range(long) so need to make it Integer 
        s++;  // increase the start as we grab the range and more to other possibility..!
    }
    return c;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt(),k=x.nextInt();
	int[] a=new int[n];
	for(int i=0;i<n;i++)
	a[i]=x.nextInt();
	System.out.println(numSubseq(a,k));
	}
}
