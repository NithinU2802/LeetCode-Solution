/******************************************************************************

There are n computers numbered from 0 to n - 1 connected by ethernet cables
connections forming a network where connections[i] = [ai, bi] represents a 
connection between computers ai and bi. Any computer can reach any other 
computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain 
cables between two directly connected computers, and place them between any pair
of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the
computers connected. If it is not possible, return -1.

Example 1:

Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.


Example 2:

Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
Output: 2


Example 3:

Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
Output: -1
Explanation: There are not enough cables.


*******************************************************************************/

import java.util.*;

public class Main
{
    
    public static int makeConnection(int n,int[][] connections){
        
    // we know that n nodes has n-1 connections..
    if(n-1!=connections.length) return -1;
    
    // make a set within a list to track connection exartly..
    List<Set<Integer>> a=new ArrayList<>(); 
    for(int i=0;i<n;i++)
        a.add(new HashSet<>());
        
    // add connections to respective List which holds other end in set..
    for(int i=0;i<connections.length;i++){
        a.get(connections[i][0]).add(connections[i][1]);
        a.get(connections[i][1]).add(connections[i][0]);
    }
    int res=0;
    
    // track whether visited
    int[] visited=new int[n];
    for(int i=0;i<n;i++){
        if(visited[i]==0){
            res++;   // if not visited make a count..
            dfs(i,a,visited); // traverse from one to another
        }
    }
    
    // reduce value by -1 because of traversing every node in the connections
    return res-1;
    }
    
    public static void dfs(int n,List<Set<Integer>> a,int[] visited){
        if(visited[n]==1) return;
        visited[n]=1;
        for(int i:a.get(n)) dfs(i,a,visited); // traverse towards continous connections...
        return;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	System.out.print("Enter Number of Nodes: ");
	int n=x.nextInt();
	x.nextLine();
	String[] a=x.nextLine().split(" ");
	int[][] connections=new int[a.length/2][2];
	int k=0;
	for(int i=0;i<a.length;i+=2){
	    connections[k][0]=Integer.parseInt(a[i]);
	    connections[k++][1]=Integer.parseInt(a[i+1]);
	}
	System.out.print(makeConnection(n,connections));
	
	}
}
