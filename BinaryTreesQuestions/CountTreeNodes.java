public class CountTreeNodes {
    
    // https://leetcode.com/problems/count-complete-tree-nodes/
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
        public int countNodes(TreeNode root) {
            if(root == null){
                return 0;
            } if(root.left == null){
                return (NodeCount(root.right) + 1);
            } if(root.right == null){
                return (NodeCount(root.left) + 1);
            } return (NodeCount(root.left) + NodeCount(root.right) + 1);
        }
        
        private static int NodeCount(TreeNode Node){
            if(Node == null){
                return 0;
            } return (NodeCount(Node.left) + NodeCount(Node.right) + 1);
        }
    }
}