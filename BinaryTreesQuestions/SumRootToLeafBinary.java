public class SumRootToLeafBinary {
    
    // https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
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
        
        public int sumNumbers(TreeNode root) {
            Sum = 0; PathSum(root, String.valueOf(root.val));
            return Sum;
        }
        
        private static int Sum;
        
        private static void PathSum(TreeNode Node, String currNum){
            if((Node.left == null) && (Node.right == null)){
                Sum += Integer.parseInt(currNum, 2);
            } if(Node.left != null){
                PathSum(Node.left, (currNum + String.valueOf(Node.left.val)));
            } if(Node.right != null){
                PathSum(Node.right, (currNum + String.valueOf(Node.right.val)));
            }
        }
    }
}