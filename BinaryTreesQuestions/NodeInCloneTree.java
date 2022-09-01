public class NodeInCloneTree {
    
    // https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
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
        
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            flag = false; refNode = new TreeNode();
            Path(cloned, target); return refNode;
        }
        
        private static boolean flag = false;
        private static TreeNode refNode = new TreeNode();
        
        private static void Path(TreeNode Node, TreeNode target){
            if(Node.val == target.val){
                flag = true; refNode = Node; return;
            } if(Node.left != null){
                Path(Node.left, target);
                if(flag){return;}
            } if(Node.right != null){
                Path(Node.right, target);
                if(flag){return;}
            }
        }
    }
}