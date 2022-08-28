public class ValidBST {
    
    // https://leetcode.com/problems/validate-binary-search-tree/
    // https://practice.geeksforgeeks.org/problems/check-for-bst/1
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
        
        public boolean isValidBST(TreeNode root) {
            return Valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
        
        private static boolean Valid(TreeNode Node, long MIN, long MAX){
            if(Node == null){
                return true;
            } if(!((Node.val > MIN) && (Node.val < MAX))){
                return false;
            } return (Valid(Node.left, MIN, Node.val) && Valid(Node.right, Node.val, MAX));
        }
    }
}