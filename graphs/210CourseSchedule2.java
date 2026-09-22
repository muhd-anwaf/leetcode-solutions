import  java.util.*;
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer,List<Integer>> prereqMap = new HashMap<>();
        for(int[] prerequisite : prerequisites){
            List<Integer> prereqList = prereqMap.getOrDefault(prerequisite[0],new ArrayList<>());
            prereqList.add(prerequisite[1]);
            prereqMap.put(prerequisite[0],prereqList);
        }
        Set<Integer> cycle = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> order = new ArrayList<>();

        for(int i = 0; i<numCourses; i++) if(!dfs(i,prereqMap,cycle,visited,order)) return new int[0];

        int[] result = new int[numCourses];
        for(int i =0; i<numCourses ; i++ ) result[i]= order.get(i);
        return result;

    }
    private boolean dfs(int course , Map<Integer,List<Integer>> prereqMap , Set<Integer> cycle , Set<Integer> visited, List<Integer> order){
        if(cycle.contains(course)) return false;
        if(visited.contains(course)) return true;
        cycle.add(course);

        for(int prereq : prereqMap.getOrDefault(course,new ArrayList<>())){
            if(!dfs(prereq,prereqMap,cycle,visited,order)) return false;
        }
        visited.add(course);
        order.add(course);
        cycle.remove(course);
        return true;

    }
}