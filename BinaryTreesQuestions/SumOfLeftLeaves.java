public class SumOfLeftLeaves {
    
    // https://leetcode.com/problems/sum-of-left-leaves/
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
        public int sumOfLeftLeaves(TreeNode root) {
            return LeafSum(root, 0);
        }
        
        private static int LeafSum(TreeNode Node, int dir){

            if(Node == null){
                return 0;
            } if((Node.left == null) && (Node.right == null) && (dir == -1)){
                return Node.val;
            } return (LeafSum(Node.left, -1) + LeafSum(Node.right, 1));
        }
    }
}