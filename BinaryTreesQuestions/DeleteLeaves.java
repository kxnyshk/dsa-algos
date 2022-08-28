public class DeleteLeaves {
    
    // https://leetcode.com/problems/cousins-in-binary-tree/
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
        
        public TreeNode removeLeafNodes(TreeNode root, int target) {
            return Remove(root, target);
        }
        
        private static TreeNode Remove(TreeNode Node, int T){
            if(Node == null){
                return null;
            } Node.left = Remove(Node.left, T); Node.right = Remove(Node.right, T);
             if((Node.left == null) && (Node.right == null) && (Node.val == T)){
                return null;
            } return Node;
        }
    }
}