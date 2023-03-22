🕵️‍/******************************************************************************


Count the number of possible triangle....

You are given a positive integer n representing n cities numbered from 1 to n. 
You are also given a 2D array roads where roads[i] = [ai, bi, distancei] indicates 
that there is a bidirectional road between cities ai and bi with a distance equal 
to distancei. The cities graph is not necessarily connected.

The score of a path between two cities is defined as the minimum distance 
of a road in this path.

Return the minimum possible score of a path between cities 1 and n.

Note:

A path is a sequence of roads between two cities.
It is allowed for a path to contain the same road multiple times, and you
can visit cities 1 and n multiple times along the path.
The test cases are generated such that there is at least one path between 1 and n.

Input: n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]] m=4 // considering m as no of roads
Output: 5

Input: n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]] m=3 // considering m as no of roads
Output: 2

*******************************************************************************/

import java.util.*;

class edge{
    int node,dist;
    edge(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}

class Main{
    
    public static int minScore(int[][] roads,int n){
    
    // refer path of every node in the graph
    List<List<edge>> graph=new ArrayList<List<edge>>(); 
    
    // list the elements that are connected to the node 
    for(int i=0;i<n+1;i++)
    graph.add(new ArrayList<edge>()); 
    
    
    // finding path of each and every roads
    for(int i=0;i<roads.length;i++){
    graph.get(roads[i][0]).add(new edge(roads[i][1],roads[i][2]));
    graph.get(roads[i][1]).add(new edge(roads[i][0],roads[i][2]));
    }
    
    // make a queue to traverse edges
    Queue<edge> q=new LinkedList<edge>();
    
    // make initial value of starting edge 
    q.add(new edge(1,Integer.MAX_VALUE));
    
    // make initial value as false for every node 
    boolean[] visited=new boolean[n+1];
    int res=Integer.MAX_VALUE; // as assign as maximum value 
    
    // until Queue is Empty find smallest distance 
    while(!q.isEmpty()){
        edge p=q.poll();
        visited[p.node]=true;
        res=Math.min(res,p.dist);
        for(edge e:graph.get(p.node)) 
        if(!visited[e.node]) q.add(e);
    }
    return res;
    }
    
	public static void main(String[] args){
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	int m=x.nextInt();
	int[][] roads=new int[m][3];
	for(int i=0;i<m;i++)
	for(int j=0;j<3;j++) roads[i][j]=x.nextInt();
	System.out.print(minScore(roads,n));
	}
	
}
