/******************************************************************************

There is an undirected graph with n nodes, where each node is numbered between 0
and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes 
that node u is adjacent to. More formally, for each v in graph[u], there is an 
undirected edge between node u and node v. 

The graph has the following properties:
-> There are no self-edges (graph[u] does not contain u).
-> There are no parallel edges (graph[u] does not contain duplicate values).
-> If v is in graph[u], then u is in graph[v] (the graph is undirected).
-> The graph may not be connected, meaning there may be two nodes u and v such that 
there is no path between them.
-> A graph is bipartite if the nodes can be partitioned into two independent sets A
and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.

 

Example 1:
Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: There is no way to partition the nodes into two independent sets 
such that every edge connects a node in one and a node in the other.

Example 2:
Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.


Solution: 
       Here I am gonna use graph coloring problem that here I am goinng to color 
every node in the graph if  a node is already colored need to alter then the graph
become not bipartite because the node is in same set.. Otherwise continue this process
until the graph node..!

*******************************************************************************/
import java.util.*;

class Solution{
    public boolean isBipartite(int[][] graph){
    int n=graph.length;
    int[] color=new int[n];
    for(int i=0;i<n;i++){
        if(color[i]==0 && !dfs(graph,color,i,1)) return false;
    }
    return true;
    }
    
    private boolean dfs(int[][] graph,int[] color,int in,int f){
        if(color[in]!=0) return color[in]==f;
        color[in]=f;
        for(int i:graph[in])
        if(!dfs(graph,color,i,-f)) return false;
        return true;
    }
}

public class Main
{
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	Solution solution =new Solution();
	int r=x.nextInt();
	int[][] graph=new int[r][];
	for(int i=0;i<r;i++){
	int c=x.nextInt();
	graph[i]=new int[c];
	for(int j=0;j<c;j++) graph[i][j]=x.nextInt();
	}
	System.out.print(solution.isBipartite(graph));
	}
}
