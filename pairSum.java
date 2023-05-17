/******************************************************************************

In a linked list of size n, where n is even, the ith node (0-indexed) of the linked
list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin 
of node 2. These are the only nodes with twins for n = 4.

The twin sum is defined as the sum of a node and its twin.

Given the head of a linked list with even length, return the maximum twin sum of the linked list.

 

Example 1:


Input: head = [5,4,2,1]
Output: 6
Explanation:
Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
There are no other nodes with twins in the linked list.
Thus, the maximum twin sum of the linked list is 6. 
Example 2:


Input: head = [4,2,2,3]
Output: 7
Explanation:
The nodes with twins present in this linked list are:
- Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
- Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
Thus, the maximum twin sum of the linked list is max(7, 4) = 7. 
Example 3:


Input: head = [1,100000]
Output: 100001
Explanation:
There is only one node with a twin in the linked list having twin sum of 1 + 100000 = 100001.
 

Constraints:

The number of nodes in the list is an even integer in the range [2, 105].
1 <= Node.val <= 105



Solution:
      As we need to traverse the node from front to mid and last to mid it is 
Not possible where it is one way linkedlist hence I alter the arrangement form 
mid to front as reverse link order then 
            It is easy to traverse mid to front and.. 
            As we continue move from mid to last then it will work to 
calculate sum of pairs.

*******************************************************************************/

import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
    ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }
}

class Solution{
    public int pairSum(ListNode head){
    ListNode end=head,mid=head,pre=null,curr=null; // Initialize to store current and mid 
                                                   // node to exchange links 
    while(end!=null){
        end=end.next.next;   // Move faster to find the mid value
        curr=mid; // load the current value for change links 
        mid=mid.next;        // As I move slower the mid value we can calculate middle element until end 
        curr.next=pre;   // Exchange link to previous node 
        pre=curr;    // now load current to previous node 
    }
    int res=0;
    // Hence the pointer mid is middle element and curr is link towards the previous one as it moves to starting point 
    while(mid!=null){
        res=(res<mid.val+curr.val)?mid.val+curr.val:res;
        mid=mid.next;
        curr=curr.next;
    }
    return res;
    }
}

public class Main
{
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt(),a;
	ListNode pre=null,node=null,head=null;
	for(int i=0;i<n;i++){
	    a=x.nextInt();
	    if(i==0){
	        node=new ListNode(a);
	        head=node;
	        pre=node;
	    }else{
	        node=new ListNode(a);
	        pre.next=node;
	        pre=node;
	    }
	}
	Solution s=new Solution();
	System.out.println(s.pairSum(head));
	}
}
