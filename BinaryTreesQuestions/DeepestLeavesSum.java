import java.util.ArrayDeque;

public class DeepestLeavesSum {
    
    // https://leetcode.com/problems/deepest-leaves-sum/
    // LeetCode solution -> class Solution {..}
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int deepestLeavesSum(TreeNode root) {
            ArrayDeque<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            
            int GLOB_SUM = 0;
            while(!q.isEmpty()){
                int size = q.size(); int CURR_SUM = 0;
                for(int i=0; i<size; i++){
                    TreeNode Node = q.poll();
                    if((Node.left == null) && (Node.right == null)){
                        CURR_SUM += Node.val;
                    } if(Node.left != null){
                        q.add(Node.left);
                    } if(Node.right != null){
                        q.add(Node.right);
                    }
                } GLOB_SUM = CURR_SUM;
            } return GLOB_SUM;
        }
    }
}