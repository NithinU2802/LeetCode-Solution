/******************************************************************************

Given an array of integers nums which is sorted in ascending order, and an integer 
target, write a function to search target in nums. If target exists, then return 
its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

*******************************************************************************/

import java.util.*;

public class Main
{
    
    public static int search(int[] nums,int target){
        int s=0,e=nums.length;
        while(s<e){
            int m=(s+e)/2;
            if(nums[m]==target) return m;
            else if(nums[m]>target) e=m;
            else s=m+1;
        }
        return -1;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String[] s=x.nextLine().split(" ");
	int target=x.nextInt();
	int[] nums=new int[s.length];
	int n=0;
	for(String i: s) nums[n++]=Integer.parseInt(i);
	System.out.print(search(nums,target));
	}
}
