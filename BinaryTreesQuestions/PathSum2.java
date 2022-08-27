import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    
    // https://leetcode.com/problems/path-sum-ii/
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
        
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            L.clear();
            if(root == null){
                return L;
            } PathSum(root, targetSum, root.val, new ArrayList<>());
            return L;
        } 
        
        private static List<List<Integer>> L = new ArrayList<>();
        
        private static void PathSum(TreeNode Node, int T, int S, List<Integer> tempL){
            tempL.add(Node.val);
            if((Node.left == null) && (Node.right == null)){
                if(S == T){
                    L.add(tempL);
                } return;
            } if(Node.left != null){
                PathSum(Node.left, T, (S + Node.left.val), new ArrayList<>(tempL));
            } if(Node.right != null){
                PathSum(Node.right, T, (S + Node.right.val), new ArrayList<>(tempL));
            }
        }
    }
}