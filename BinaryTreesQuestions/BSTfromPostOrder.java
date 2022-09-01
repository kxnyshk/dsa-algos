public class BSTfromPostOrder {
    
    // https://practice.geeksforgeeks.org/problems/construct-bst-from-post-order/1
    // Gfg solution -> class Solution {..}
    
    // User function Template for Java
    static class Node{
        int data;
        Node left,right;
        Node(int d)
        {
            data=d;
            left=right=null;
        }
    }

    class GFG
    {
        public static Node constructTree(int post[],int n)
        {
            //Add your code here.
            PostIdx = post.length - 1;
            return Build(post, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        private static int PostIdx;
        
        private static Node Build(int[] post, int min, int max){
            if((PostIdx < 0) || (post[PostIdx] < min) || (post[PostIdx] > max)){
                return null;
            } Node Node = new Node(post[PostIdx--]);
            
            Node.right = Build(post, Node.data, max);
            Node.left = Build(post, min, Node.data);
            
            return Node;
        }
    }
}