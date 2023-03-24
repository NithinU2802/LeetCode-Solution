/******************************************************************************

There are n cities numbered from 0 to n - 1 and n - 1 roads such that there
is only one way to travel between two different cities (this network form a tree).
Last year, The ministry of transport decided to orient the roads in one direction 
because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] represents
a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many people 
want to travel to this city.

Your task consists of reorienting some roads such that each city can visit 
the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach city 0 after reorder.

 

Example 1:

Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such 
that each node can reach the node 0 (capital).


Example 2:

Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such 
that each node can reach the node 0 (capital).

in -> 0 - 1 
      2 - 1,3
      4 - 3
      
out -> 1 - 0,2
       3 - 2,4



Example 3:

Input: n = 3, connections = [[1,0],[2,0]]
Output: 0


in -> 


*******************************************************************************/

import java.util.*;

public class Main
{
    static int r=0;
    static List<Set<Integer>> in=new ArrayList<>();
    static List<Set<Integer>> out=new ArrayList<>();
    
    public static void dfs(int n){
        for(int i:in.get(n)){
            out.get(i).remove(n);
            dfs(i);
        }
        for(int i:out.get(n)){
            r++;
            in.get(i).remove(n);
            dfs(i);
        }
    }
    
    public static int minReorder(int n,int[][] connections){
        for(int i=0;i<n;i++){
            in.add(new HashSet<>());
            out.add(new HashSet<>());
        }
        r=0;
        for(int i=0;i<connections.length;i++){
            in.get(connections[i][1]).add(connections[i][0]);
            out.get(connections[i][0]).add(connections[i][1]);
        }
        dfs(0);
        return r;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	System.out.print("Enter Number of Nodes: ");
	int n=x.nextInt();
	int[][] connections=new int[n-1][2];
	for(int i=0;i<n-1;i++){
	    for(int j=0;j<2;j++) connections[i][j]=x.nextInt();
	}
	System.out.print(minReorder(n,connections));
	
	}
}
