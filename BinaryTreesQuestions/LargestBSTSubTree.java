public class LargestBSTSubTree {
    
    // https://practice.geeksforgeeks.org/problems/largest-bst/1
    // Gfg solution -> class Solution {..}
    
    //User function Template for Java
    class Node  
    { 
        int data; 
        Node left, right; 
    
        public Node(int d)  
        { 
            data = d; 
            left = right = null; 
        } 
    }


    class Solution{
        
        // Return the size of the largest sub-tree which is also a BST
        static int largestBst(Node root)
        {
            // Write your code here
            size = 0; bst(root);
            return size;
        }
        
        private static int size;
        
        private static class Pair{
            int min, max, height; boolean isBST;
            Pair(){}
            Pair(int min, int max, int height, boolean isBST){
                this.min = min;
                this.max = max;
                this.height = height;
                this.isBST = isBST;
            }
        }
        
        private static Pair bst(Node Node){
            if(Node == null){
                return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
            } 
            
            Pair p1 = bst(Node.left); 
            Pair p2 = bst(Node.right);
            
            Pair p = new Pair();
            p.min = Math.min(p1.min, Node.data); 
            p.max = Math.max(p2.max, Node.data);
            
            p.height = (p1.height + p2.height + 1);
            p.isBST = (p1.isBST && p2.isBST) && (Node.data > p1.max) && (Node.data < p2.min);
            
            if(p.isBST){
                size = Math.max(size, p.height);
            } return p;
        }
    }
}

// Example figure
//         10
//        /  \ 
//       9    15
//      / \     \
//     1   8     7