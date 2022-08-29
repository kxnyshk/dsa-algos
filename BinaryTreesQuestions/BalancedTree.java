public class BalancedTree {
    
    // https://leetcode.com/problems/balanced-binary-tree/
    // https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
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

        public boolean isBalanced(TreeNode root) {
            flag = true; Balanced(root);
            return flag;
        }
        
        private static boolean flag;
        
        private static int Balanced(TreeNode Node){
            if(Node == null){
                return 0;
            } int LH = Balanced(Node.left); int RH = Balanced(Node.right);
            
            if(Math.abs(LH - RH) > 1){
                flag &= false;
            } return (Math.max(LH, RH) + 1);
        }
    }
}