public class DiameterOfTree {
    
    // https://leetcode.com/problems/diameter-of-binary-tree/
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
        
        public int diameterOfBinaryTree(TreeNode root) {
            D = Integer.MIN_VALUE; Height(root);
            return D;
        }
        
        private static int D;
        
        private static int Height(TreeNode Node){
            if(Node == null){
                return 0;
            } int LH = Height(Node.left); int RH = Height(Node.right); D = Math.max(D, (LH + RH));
            return (Math.max(LH, RH) + 1);
        }
    }
}