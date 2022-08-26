import java.util.ArrayDeque;

public class MaxLevelSum {
    
    // https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
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
        public int maxLevelSum(TreeNode root) {
            ArrayDeque<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            
            int CUR_LEVEL = 1;
            int GLO_LEVEL = CUR_LEVEL;
            int MAX_VALUE = Integer.MIN_VALUE;
            
            while(!q.isEmpty()){
                int size = q.size(); int sum = 0;
                for(int i=0; i<size; i++){
                    TreeNode Node = q.poll(); sum += Node.val;
                    if(Node.left != null){
                        q.add(Node.left);
                    } if(Node.right != null){
                        q.add(Node.right);
                    }
                } if(sum > MAX_VALUE){
                    MAX_VALUE = Math.max(MAX_VALUE, sum);
                    GLO_LEVEL = CUR_LEVEL;
                } CUR_LEVEL++;
            } return GLO_LEVEL;
        }
    }
}