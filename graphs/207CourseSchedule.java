class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> prerequisitesList = new ArrayList<>();
        boolean[] cycle = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for(int i =0; i<numCourses; i++) prerequisitesList.add(new ArrayList<>());
        for(int[] prereq : prerequisites) prerequisitesList.get(prereq[0]).add(prereq[1]);
        for(int i=0; i<numCourses; i++){ if(!dfs(i,cycle,visited,prerequisitesList)) return false;}
        return true;
    }
    private boolean dfs(int course,boolean[] cycle , boolean[] visited , List<List<Integer>> prereq){
        if(visited[course]) return true;
        if(cycle[course]) return false;
        cycle[course]=true;

        for(int pre : prereq.get(course)){
            if(!dfs(pre,cycle,visited,prereq)){

                return false;
            }
        }
        cycle[course]=false;
        visited[course] = true;
        return true;
    }
}