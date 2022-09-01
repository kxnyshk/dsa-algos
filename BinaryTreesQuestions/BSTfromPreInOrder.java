import java.util.HashMap;

public class BSTfromPreInOrder {
    
    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    // https://practice.geeksforgeeks.org/problems/construct-tree-1/1
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

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map.clear(); BuildMap(inorder); PreIndex = 0;
            return BuildTree(preorder, inorder, 0, inorder.length - 1);
        }
        
        private static HashMap<Integer, Integer> Map = new HashMap<>();
        private static int PreIndex;
        
        private static TreeNode BuildTree(int[] OrderPre, int[] OrderIn, int InStart, int InEnd){
            if(InStart > InEnd){
                return null;
            }
            
            TreeNode Root = new TreeNode();
            Root.val = OrderPre[PreIndex++];
            
            int InIndex = Map.get(Root.val);
             
            Root.left = BuildTree(OrderPre, OrderIn, InStart, InIndex - 1);
            Root.right = BuildTree(OrderPre, OrderIn, InIndex + 1, InEnd);
            
            return Root;
        }
        
        private static void BuildMap(int[] OrderIn){
            for(int i=0; i<OrderIn.length; i++){
                Map.put(OrderIn[i], i);
            }
        }
    }
}