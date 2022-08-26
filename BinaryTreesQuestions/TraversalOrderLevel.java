import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class TraversalOrderLevel {
    
    // https://leetcode.com/problems/binary-tree-level-order-traversal/
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
        
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> L = new ArrayList<List<Integer>>();
            if(root == null){
                return L;
            } ArrayDeque<TreeNode> q = new ArrayDeque<>();
            
            q.add(root);
            while(!q.isEmpty()){
                List<Integer> tempL = new ArrayList<>(); int size = q.size();
                for(int i=0; i<size; i++){
                    TreeNode Node = q.poll(); tempL.add(Node.val);
                    if(Node.left != null){
                        q.add(Node.left);
                    } if(Node.right != null){
                        q.add(Node.right);
                    }
                } L.add(tempL);
            } return L;
        }
    }
}
