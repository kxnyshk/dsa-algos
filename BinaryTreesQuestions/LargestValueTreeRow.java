import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class LargestValueTreeRow {
    
    // https://leetcode.com/problems/find-largest-value-in-each-tree-row/
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
        
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> L = new ArrayList<>();
            if(root == null){
                return L;
            } ArrayDeque<TreeNode> q = new ArrayDeque<>();
            
            q.add(root);
            while(!q.isEmpty()){
                int size = q.size(); int MAX = Integer.MIN_VALUE;
                for(int i=0; i<size; i++){
                    TreeNode Node = q.poll(); MAX = Math.max(MAX, Node.val);
                    if(Node.left != null){
                        q.add(Node.left);
                    } if(Node.right != null){
                        q.add(Node.right);
                    }
                } L.add(MAX);
            } return L;
        }
    }
}