/* 100392. Time Taken to Mark All Nodes */
class TimeTaken {
    
    public static int bfs(List<List<Integer>> graph,int s){
        Queue<int[]> queue=new LinkedList<>();
        boolean[] visit=new boolean[graph.size()];
        queue.offer(new int[]{s,0});
        visit[s]=true;
        int max=-1;
        while(!queue.isEmpty()){
            int[] d=queue.poll();
            int node=d[0],time=d[1];
            max=Math.max(max,time);
            for(int i:graph.get(node))
                if(!visit[i]){
                    visit[i]=true;
                    int t=time+(i%2==0?2:1);
                    queue.offer(new int[]{i,t});
                }
        }
        return max;
    }
    
    public int[] timeTaken(int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();
        int n=edges.length+1;
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        for(int[] i:edges){
            int u=i[0],v=i[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] time=new int[n];
        for(int i=0;i<n;i++){
            time[i]=bfs(graph,i);
            if(time[i]==-1)
                break;
        }
        return time;
    }

    public static void main(String[] arg){
        // input values edges
    }
    
}
