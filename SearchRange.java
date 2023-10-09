/******************************************************************************

    Given an array of integers nums sorted in non-decreasing order, find the starting
and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109



*******************************************************************************/
import java.util.*;

public class Main
{
    
    public static int[] searchRange(int[] nums,int target){
        int s=0,e=nums.length-1;
        int[] a=new int[2];
        Arrays.fill(a,-1);
        while( (s<nums.length && e>=0 ) && (a[0]==-1 || a[1]==-1)){
            if(a[0]==-1){
                if(nums[s]==target)
                    a[0]=s;
                s++;
            }
            if(a[1]==-1){
                if(nums[e]==target)
                    a[1]=e;
                e--;
            }
        }
        return a;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	int[] a=new int[n];
	for(int i=0;i<n;i++)
	    a[i]=x.nextInt();
	int k=x.nextInt();
	for(int i: searchRange(a,k))
	    System.out.print(i+" ");
	
	}
}
