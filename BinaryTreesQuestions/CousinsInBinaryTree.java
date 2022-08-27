public class CousinsInBinaryTree {
    
    // https://leetcode.com/problems/cousins-in-binary-tree/
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
        
        public boolean isCousins(TreeNode root, int x, int y) {
            xDep = -1; yDep = -1; xPar = -1; yPar = -1;
            Cousins(root, -1, 0, x, y);
            return (xDep == yDep) ? ((xPar != yPar) ? true : false) : false;
        }
        
        private static int xDep; private static int yDep;
        private static int xPar; private static int yPar;
        
        private static void Cousins(TreeNode Node, int parent, int depth, int x, int y){
            if(Node == null){
                return;
            } if(Node.val == x){
                xDep = depth; xPar = parent;
            } if(Node.val == y){
                yDep = depth; yPar = parent;
            } if((xDep == -1) || (yDep == -1)){
                Cousins(Node.left, Node.val, (depth + 1), x, y); 
                Cousins(Node.right, Node.val, (depth + 1), x, y);
            }
        }
    }
}