public class BinaryTreeTilt {
    
    // https://leetcode.com/problems/binary-tree-tilt/
    // https://practice.geeksforgeeks.org/problems/tilt-of-binary-tree/1
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

        public int findTilt(TreeNode root) {
            T = 0; Tilt(root);
            return T;
        }
        
        private static int T;
        
        private static int Tilt(TreeNode Node){
            if(Node == null){
                return 0;
            } int LT = Tilt(Node.left); int RT = Tilt(Node.right); T += Math.abs(LT - RT);
            return (LT + RT + Node.val);
        }
    }
}