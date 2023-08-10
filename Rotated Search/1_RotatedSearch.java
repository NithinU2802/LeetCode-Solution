/******************************************************************************

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot
index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1],
..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7]
might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index 
of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104


*******************************************************************************/


class Solution { 

    private int binary(int[] a,int i,int j,int k){
        if(i<=j){
            int m=(i+j)/2;
            if(a[m]==k)
                return m;
            if(a[m]>k)
                return binary(a,i,m-1,k);
            else 
                return binary(a,m+1,j,k);
        }
        return -1;
    }

    private int pivort(int[] a,int i,int j,int n){
        if(i<=j){
            int m=(i+j)/2;
            if(a[n-1]<a[m])
                return pivort(a,m+1,j,n);
            else
                return pivort(a,i,m-1,n);
        }
        return i;
    }

    public int search(int[] nums, int target) {
        int n=nums.length;
        int p=pivort(nums,0,n-1,n);
        if(nums[p]==target)
            return p;
        if(nums[n-1]<target)
            return binary(nums,0,p-1,target);
        return binary(nums,p+1,n-1,target);
    }
}

public class 1_RotatedSearch{
    public static void main(String[] arg){
    int[] nums=new int[]{4,5,6,7,0,1,2};
    Solution solution=new Solution();
    System.out.println(solution.search(nums,0));
    }
}