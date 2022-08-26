import java.util.ArrayList;
import java.util.List;

public class TraversalOrderIn {

    // https://leetcode.com/problems/binary-tree-inorder-traversal/
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

        public List<Integer> inorderTraversal(TreeNode root) {
            L.clear(); TraversalOrderIn(root); 
            return L;
        }
        
        private static List<Integer> L = new ArrayList<>();
        
        private static void TraversalOrderIn(TreeNode root){
            if(root != null){
                TraversalOrderIn(root.left); L.add(root.val);
                TraversalOrderIn(root.right);
            }
        }
    }
}