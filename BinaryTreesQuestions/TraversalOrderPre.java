import java.util.ArrayList;
import java.util.List;

public class TraversalOrderPre {

    // https://leetcode.com/problems/binary-tree-preorder-traversal/
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

        public List<Integer> preorderTraversal(TreeNode root) {
            L.clear(); TraversalOrderPre(root); 
            return L;
        }
        
        private static List<Integer> L = new ArrayList<>();
        
        private static void TraversalOrderPre(TreeNode root){
            if(root != null){
                L.add(root.val);
                TraversalOrderPre(root.left); TraversalOrderPre(root.right);
            }
        }
    }
}