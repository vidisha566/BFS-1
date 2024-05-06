// Time Complexity : O(V + E), where V is the number of courses (vertices) and E is the number of prerequisites (edges) in the graph.
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



//Queue is used to store indep(Integer):dependent(List)
//Indegrees array is used to store all the courses that are dependent on the current course
//Queue stores all the courses that are currently independent


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] pr: prerequisites){ //Looping through each elem in an array
            indegrees[pr[0]]++; //Everytime you find the first elem in pr, you would increase it by 1. Better understanding by drawing the graph.
            if(map.containsKey(pr[1])){ //If map contains the first elem
                map.get(pr[1]).add(pr[0]); //Add it to the already created list
            } else{
                map.put(pr[1], new ArrayList<>()); //Otherwise create a list
                map.get(pr[1]).add(pr[0]); //Then add it
            }
        }
        Queue<Integer> queue = new LinkedList<>(); //Creates a queue
        for(int i = 0; i < indegrees.length; i++){
            if(indegrees[i] == 0){ //Adds all the 0's for indegrees array
                queue.add(i); //Add to the queue
            }
        }
        int count = 0;
        while(!queue.isEmpty()){ //As long the queue is not empty
            List<Integer> courses = map.get(queue.poll()); //Pop the queue elem and get the value from map and then store it as courses as it is a list
            count++;
            if(courses != null){ //As long as the list is not empty
                for(int course: courses){
                    indegrees[course]--; //Reduces the value by 1 for all the courses that were dependent on that queue.poll value
                    if(indegrees[course] == 0){
                        queue.add(course); ////Adds all the 0's for indegrees array
                    }
                }
            }
        }
        return count == numCourses;
    }
}