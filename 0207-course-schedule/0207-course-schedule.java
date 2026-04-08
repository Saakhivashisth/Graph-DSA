class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p:prerequisites){
            adj.get(p[1]).add(p[0]);//b->a
        }
        boolean[] visited=new boolean[numCourses];
        boolean[] recPath=new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,recPath)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int node,List<List<Integer>> adj,boolean[] visited,boolean[] recPath){
        visited[node]=true;
        recPath[node]=true;

        for(int neighbor: adj.get(node)){
            if(!visited[neighbor]){
            if(dfs(neighbor,adj,visited,recPath))
                return true;
            }
            else if(recPath[neighbor]){
                return true;
            }
        }
        recPath[node]=false;
        return false;
    }
    }
