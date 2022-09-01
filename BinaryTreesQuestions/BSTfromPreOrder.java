public class BSTfromPreOrder {
    
    // https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
    // LeetCode solution -> class Solution {..}
    
    public static class TreeNode {
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
        public TreeNode bstFromPreorder(int[] preorder) {
            PreIdx = 0;
            return Build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        private static int PreIdx;
        
        private static TreeNode Build(int[] pre, int min, int max){
            if((PreIdx >= pre.length) || (pre[PreIdx] < min) || (pre[PreIdx] > max)){
                return null;
            } TreeNode Node = new TreeNode(pre[PreIdx++]);
            
            Node.left = Build(pre, min, Node.val);
            Node.right = Build(pre, Node.val, max);
            
            return Node;
        }
    }
}