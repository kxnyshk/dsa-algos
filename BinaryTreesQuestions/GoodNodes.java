public class GoodNodes {

    // https://leetcode.com/problems/find-bottom-left-tree-value/
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
        
        public int goodNodes(TreeNode root) {
            count = 0; recur(root, Integer.MIN_VALUE);
            return count;
        }
        
        private static int count = 0;
        
        private static void recur(TreeNode Node, int max){
            if(Node == null){
                return;
            } if(Node.val >= max){
                count++;
            } recur(Node.left, Math.max(max, Node.val)); recur(Node.right, Math.max(max, Node.val));
        }
    }
}