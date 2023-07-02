/******************************************************************************

1601. Maximum Number of Achievable Transfer Requests


We have n buildings numbered from 0 to n - 1. Each building has a number of employees.
It's transfer season, and some employees want to change the building they reside in.

You are given an array requests where requests[i] = [fromi, toi] represents an employee's 
request to transfer from building fromi to building toi.

All buildings are full, so a list of requests is achievable only if for each building, 
the net change in employee transfers is zero. This means the number of employees leaving
is equal to the number of employees moving in. For example if n = 3 and two employees are 
leaving building 0, one is leaving building 1, and one is leaving building 2, there should
be two employees moving to building 0, one employee moving to building 1, and one employee
moving to building 2.

Return the maximum number of achievable requests.

 

Example 1:


Input: n = 5, k=5 requests = [[0,1],[1,0],[0,1],[1,2],[2,0],[3,4]]
Output: 5
Explantion: Let's see the requests:
From building 0 we have employees x and y and both want to move to building 1.
From building 1 we have employees a and b and they want to move to buildings 2 and 0 respectively.
From building 2 we have employee z and they want to move to building 0.
From building 3 we have employee c and they want to move to building 4.
From building 4 we don't have any requests.
We can achieve the requests of users x and b by swapping their places.
We can achieve the requests of users y, a and z by swapping the places in the 3 buildings.
Example 2:


Input: n = 3, k=3 requests = [[0,0],[1,2],[2,1]]
Output: 3
Explantion: Let's see the requests:
From building 0 we have employee x and they want to stay in the same building 0.
From building 1 we have employee y and they want to move to building 2.
From building 2 we have employee z and they want to move to building 1.
We can achieve all the requests. 
Example 3:

Input: n = 4, requests = [[0,3],[3,1],[1,2],[2,0]]
Output: 4
 

Constraints:
1 <= n <= 20
1 <= requests.length <= 16
requests[i].length == 2
0 <= from i, to i < n


Solution:

1. Create degree array in-order to track the whole requests towards the buildings.
2. Now make recursion process in order to alter the value of result that prefers 
the maximum changes on the degree of the buildings.
3. By the process of recursion make forward and backward process inorder to find 
the changes and make alteration in degree.
    i.   If the requests reaches the end then return to the function.
    ii.  Make Update on the result.
   Do the above process for each and every requests from towards end as twice given 
below -> Forward  -> Backward.
4. Now return changes occurs in result.


*******************************************************************************/
import java.util.*;


class Solution{
    int res=0;
    
    void maxReq(int[][] req,int[] deg,int n,int i,int c){
        if(i==req.length){
            for(int j=0;j<n;j++)
            if(deg[j]!=0)
            return;
            res=Math.max(res,c);
            return;
        }
        
        // forward propogation 
        deg[req[i][0]]--;
        deg[req[i][1]]++;
        maxReq(req,deg,n,i+1,c+1);
        
        // backward process 
        deg[req[i][0]]++;
        deg[req[i][1]]--;
        maxReq(req,deg,n,i+1,c);
    }
    
    int maximumRequest(int[][] requests,int n){
        
        // degree to find the changes occurs on the buildings
        int[] deg=new int[n];
        
        // Recursion for traverse requests and make change on degree and res 
        maxReq(requests,deg,n,0,0);
        return res;
    }
}

public class Main
{
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	
	// no of buildings
	int n=x.nextInt();
	
	// no of request 
	int k=x.nextInt();
	int[][] request=new int[k][2];
	for(int i=0;i<n;i++){
	    System.out.print("Request "+(i+1)+": ");
	    request[i][0]=x.nextInt();
	    request[i][1]=x.nextInt();
	}
	Solution solution=new Solution();
	System.out.println(solution.maximumRequest(request,n));
	}
}
