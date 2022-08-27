public class PathSum {
    
    // https://leetcode.com/problems/path-sum/
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
        
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root == null){
                return false;
            } return PathSum(root, targetSum, root.val);
        }
        
        private static boolean PathSum(TreeNode Node, int T, int S){
            if((Node.left == null) && (Node.right == null)){
                return (S == T) ? true : false;
            } boolean left = false, right = false;
            if(Node.left != null){
                left = PathSum(Node.left, T, (S + Node.left.val));
            } if(Node.right != null){
                right = PathSum(Node.right, T, (S + Node.right.val));
            } return (left || right);
        }
    }
}