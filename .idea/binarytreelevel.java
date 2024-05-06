// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue <TreeNode> queue = new LinkedList<>(); //Creates a queue to store the values from one level
        queue.add(root); //Add the root to the queue
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode tempNode = queue.poll(); //Remove the current elem from queue
                temp.add(tempNode.val); //Add it to the temp variable
                if(tempNode.left != null){
                    queue.add(tempNode.left); //If the child of temp is not null then add the elem to the queue
                }
                if(tempNode.right!=null){
                    queue.add(tempNode.right); //If the child of temp is not null then add the elem to the queue
                }
            }
            result.add(temp);
        }
        return result;
    }
}