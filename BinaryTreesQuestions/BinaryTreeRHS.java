import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRHS {
    
    // https://leetcode.com/problems/binary-tree-right-side-view/
    // https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1
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
        
        public List<Integer> rightSideView(TreeNode root) {
            return RHS(root);
        }
        
        private static List<Integer> RHS(TreeNode Node){
            List<Integer> L = new ArrayList<>();
            if(Node == null){
                return L;
            } ArrayDeque<TreeNode> q = new ArrayDeque<>(); q.add(Node);
            
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0; i<size; i++){
                    TreeNode temp = q.pop();
                    if(temp.left != null){
                        q.add(temp.left);
                    } if(temp.right != null){
                        q.add(temp.right);
                    } if(i == (size - 1)){
                        L.add(temp.val);
                    }
                }
            } return L;
        }
    }
}