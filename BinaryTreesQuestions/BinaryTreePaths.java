import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    
    // https://leetcode.com/problems/binary-tree-paths/
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
        
        public List<String> binaryTreePaths(TreeNode root) {
            L.clear();
            if((root.left == null) && (root.right == null)){
                L.add(String.valueOf(root.val));
                return L;
            } return Paths(root, String.valueOf(root.val));
        }
        
        private static List<String> L = new ArrayList<>();
        
        private static List<String> Paths(TreeNode Node, String Path){
            if((Node.left == null) && (Node.right == null)){
                L.add(Path); return L;
            } if(Node.left != null){
                Paths(Node.left, (Path + "->" + String.valueOf(Node.left.val)));
            } if(Node.right != null){
                Paths(Node.right, (Path + "->" + String.valueOf(Node.right.val)));
            } return L;
        }
    }
}