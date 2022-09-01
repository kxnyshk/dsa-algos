import java.util.ArrayDeque;

public class BottomLeftTree {
    
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
        
        public int findBottomLeftValue(TreeNode root) {
            return BottomLeft(root);
        }
        
        private static int BottomLeft(TreeNode root){
            ArrayDeque<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            
            int global = root.val;
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0; i<size; i++){
                    TreeNode temp = q.pop();
                    if(temp.left != null){
                        q.add(temp.left);
                    } if(temp.right != null){
                        q.add(temp.right);
                    } if(i == 0){
                        global = temp.val;
                    }
                }
            } return global;
        }
    }
}