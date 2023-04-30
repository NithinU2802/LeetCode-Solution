/******************************************************************************

Given an integer array nums where the elements are sorted in ascending order, convert it to a 
height-balanced binary search tree.

 

Example 1:
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]  // 0 -10 -3 5 9
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:
Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

*******************************************************************************/

import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int n){
        this.val=n;
    }
}

public class Main{
    
    public static TreeNode binary(int[] a,int s,int e){
        if(s>e) return null;
        int m=(s+e)/2;
        TreeNode t=new TreeNode(a[m]);
        t.left=binary(a,s,m-1);
        t.right=binary(a,m+1,e);
        return t;
    }
    
    public static TreeNode sortedArrayToBst(int[] a){
        int n=a.length;
        if(n==0) return null;
        return binary(a,0,n-1);
    }
    
    public static void inOrder(TreeNode h){
        if(h==null){ 
            System.out.print("null ");
            return; 
        }
        System.out.print(h.val+" ");
        if(h.left==null && h.right==null) return;
        inOrder(h.left);
        inOrder(h.right);
        return;
    }
    
    public static void postOrder(TreeNode h){
        if(h==null){ 
            System.out.print("null ");
            return; 
        }
        System.out.print(h.val+" ");
        if(h.left==null && h.right==null) return;
        postOrder(h.left);
        postOrder(h.right);
        return;
    }
    
    public static void preOrder(TreeNode h){
        if(h==null){ 
            System.out.print("null ");
            return; 
        }
        System.out.print(h.val+" ");
        if(h.left==null && h.right==null) return;
        preOrder(h.left);
        preOrder(h.right);
        return;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	int[] a=new int[n];
	for(int i=0;i<n;i++)
	a[i]=x.nextInt();
	TreeNode t=sortedArrayToBst(a);
	System.out.print("inOrder: ");
	inOrder(t);
	System.out.print("\npreOrder: ");
	preOrder(t);
	System.out.print("\npostOrder: ");
	postOrder(t);
	}
}
