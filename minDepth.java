/******************************************************************************

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root 
node down to the nearest leaf node.

Note: A leaf is a node with no children.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
 

Constraints:

The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000

*******************************************************************************/
import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val){
        this.val=val;
    }
    
    TreeNode(int val,TreeNode left, TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}


// Solution 
class Solution{
    
    public static int dfs(TreeNode node){
        if(node==null)
            return 0;
        if(node.left==null)
            return 1+dfs(node.right);
        if(node.right==null)
            return 1+dfs(node.left);
        return 1+Math.max(dfs(node.left),dfs(node.right));
    }
    
    public int minDepth(TreeNode root){
        return dfs(root);
    } 
}

public class Main
{
    public static TreeNode binaryTree(Integer[] elements){
        int n=elements.length;
        if(n==0 || elements[0]==null) 
            return null;
        TreeNode[] node=new TreeNode[n];
        for(int i=0;i<n;i++)
            if(elements[i]!=null)
                node[i]=new TreeNode(elements[i]);
        for(int i=0;i<n;i++)
            if(node[i]!=null){
                int left=i+1,right=i+2;
                if(left<n)
                    node[i].left=node[left];
                if(right<n)
                    node[i].right=node[right];
            }
        return node[0];
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String[] s=x.nextLine().split(" ");
	Integer[] elements=new Integer[s.length];
	for(int i=0;i<s.length;i++)
	if(s[i].equals("null")) elements[i]=null;
	else elements[i]=Integer.parseInt(s[i]);
	
	TreeNode head=binaryTree(elements);
	Solution solution=new Solution();
	System.out.println(solution.minDepth(head));
	}
}
