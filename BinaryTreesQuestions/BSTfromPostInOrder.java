import java.util.HashMap;

public class BSTfromPostInOrder {
    
    // https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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
        
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            Map.clear(); BuildMap(inorder); PostIndex = postorder.length - 1;
            return BuildTree(inorder, postorder, 0, inorder.length - 1);
        }
        
        private static HashMap<Integer, Integer> Map = new HashMap<>();
        private static int PostIndex;
        
        private static TreeNode BuildTree(int[] OrderIn, int[] OrderPost, int InStart, int InEnd){
            if(InStart > InEnd){
                return null;
            }
            
            TreeNode Root = new TreeNode();
            Root.val = OrderPost[PostIndex--];
            
            int InIndex = Map.get(Root.val);
            
            Root.right = BuildTree(OrderIn, OrderPost, InIndex + 1, InEnd);
            Root.left = BuildTree(OrderIn, OrderPost, InStart, InIndex - 1);
            
            return Root;
        }
        
        private static void BuildMap(int[] OrderIn){
            for(int i=0; i<OrderIn.length; i++){
                Map.put(OrderIn[i], i);
            }
        }
    }
}