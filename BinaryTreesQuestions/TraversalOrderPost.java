import java.util.ArrayList;
import java.util.List;

public class TraversalOrderPost {

    // https://leetcode.com/problems/binary-tree-postorder-traversal/
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

        public List<Integer> postorderTraversal(TreeNode root) {
            L.clear(); TraversalOrderPost(root); 
            return L;
        }
        
        private static List<Integer> L = new ArrayList<>();
        
        private static void TraversalOrderPost(TreeNode root){
            if(root != null){
                TraversalOrderPost(root.left); TraversalOrderPost(root.right);
                L.add(root.val);
            }
        }
    }
}