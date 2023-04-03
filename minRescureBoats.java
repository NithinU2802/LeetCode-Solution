/******************************************************************************

You are given an array people where people[i] is the weight of the ith person, 
and an infinite number of boats where each boat can carry a maximum weight of 
limit. Each boat carries at most two people at the same time, provided the sum
of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

 

Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)


Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)


when we sort element then from first and last we traverse in order to find boats 
require. As j is maximum weighted person moving less a down if person is Maximum 
with less which means he cann't go anymore as per the limit.

As i is minimum weighted person moving higher if person add with max person 
he is eligible...

*******************************************************************************/

import java.util.*;

public class Main
{
    
    public static int numRescureBoats(int[] people,int limit){
        
        // make sort of people
        Arrays.sort(people);
        
        // two pointers i and j one moves forward other move backward from last 
        int i=0,j=people.length-1,res=0;
        // res represent count of boat required
        
        while(i<=j){
            if(people[i]+people[j]<=limit) i++; // if max+min is less than limit i++
            j--; // max will reduce doesn't care about condition
            res++;
        }
        return res;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	int[] people=new int[n];
	for(int i=0;i<n;i++) people[i]=x.nextInt();
	int limit=x.nextInt();
	System.out.print(numRescureBoats(people,limit));
	}
}
