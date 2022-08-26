public class MaxDepth {
    
    // https://leetcode.com/problems/maximum-depth-of-binary-tree/
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
        public int maxDepth(TreeNode root) {
            if(root == null){
                return 0;
            } return (Math.max(DepthMax(root.left), DepthMax(root.right)) + 1);
        }
        
        private static int DepthMax(TreeNode Node){
            if(Node == null){
                return 0;
            } return (Math.max(DepthMax(Node.left), DepthMax(Node.right)) + 1);
        }
    }
}