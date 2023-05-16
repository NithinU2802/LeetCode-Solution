/******************************************************************************

         Given a linked list, swap every two adjacent nodes and return its head.
You must solve the problem without modifying the values in the list's nodes (i.e.,only 
nodes themselves may be changed.)

 

Example 1:

Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]

*******************************************************************************/

import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val=val;
    }
    ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }
}

class Solution{
    
    public static void swap(ListNode f,ListNode s){
        int b=f.val;
        f.val=s.val;
        s.val=b;
    }
    
    public ListNode swapPairs(ListNode head){
        ListNode f=head,s=head;
        while(f!=null && s.next!=null){
            s=s.next;
            swap(f,s);
            f=f.next.next;
            s=s.next;
        }
        return head;
    }
}

public class Main
{
    public static void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt(),a;
	ListNode head=null,prev=null;
	for(int i=0;i<n;i++){
	    a=x.nextInt();
	    if(i==0){
	        head=new ListNode(a);
	        prev=head;
	    }else{
	        ListNode node=new ListNode(a);
	        prev.next=node;
	        prev=node;
	    }
	}
	Solution sol=new Solution();
	ListNode h=sol.swapPairs(head);
	print(head);
	}
}
