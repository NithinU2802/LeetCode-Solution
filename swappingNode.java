/******************************************************************************

    You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from
the beginning and the kth node from the end (the list is 1-indexed).

 

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]

*******************************************************************************/

import java.util.*;

class ListNode{
    int val=0;
    ListNode next=null;
    ListNode(int val){
        this.val=val;
    }
    ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }
}

class Solution{
    public ListNode swapNode(ListNode head,int k){
    ListNode second=head,first=head,last=head;
    int c=0;
    while(c<k-1){
        last=last.next;
        first=first.next;
        c++;
    }
    while(true){
        last=last.next;
        if(last==null) break;
        second=second.next;
    }
    c=first.val;
    first.val=second.val;
    second.val=c;
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
	ListNode prev=null,head=null;
	for(int i=0;i<n;i++){
	    a=x.nextInt();
	    if(i==0){
	        ListNode Node=new ListNode(a);
	        head=Node;
	        prev=Node;
	    }else{
	        ListNode Node=new ListNode(a);
	        prev.next=Node;
	        prev=Node;
	    }
	}
	int k=x.nextInt();
	Solution s=new Solution();
	head=s.swapNode(head,k);
	print(head);
	}
}
