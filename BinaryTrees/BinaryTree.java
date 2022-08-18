import java.util.ArrayDeque;
import java.util.Stack;

public class BinaryTree{

    private static class Node{
        int data; Node left, right;
        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Integer[] Arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        Node root = new Node(Arr[0], null, null);

        ConstructBinaryTree(Arr, root);                         // constructing a Binary Tree
        DisplayBinaryTree(root);                                // displaying a Binary Tree

        System.out.println("Size: " + Size(root));              // Size of Tree (No. of Nodes)
        System.out.println("Sum: " +  Sum(root));               // Sum of all Nodes
        System.out.println("Max: " + Max(root));                // Max of all Nodes
        System.out.println("Height: " + Height(root));          // Height of Tree (Node height)

        System.out.println("\nPreorder: ");
        TraversalOrderPre(root);                                // Preorder   (Root, Left, Right)
        System.out.println("\nInorder: ");
        TraversalOrderIn(root);                                 // Inorder    (Left, Root, Right)
        System.out.println("\nPostorder: ");
        TraversalOrderPost(root);                               // Postorder  (Left, Right, Root)
        System.out.println("\nLevelorder: ");
        TraversalOrderLevel(root);                              // Levelorder (L1, L2, L3, L4, L5)
    }

    private static void TraversalOrderLevel(Node root) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()){
            Node n = q.poll();
            System.out.print(n.data + " ");
            
            if(n.left != null){
                q.add(n.left);
            } if(n.right != null){
                q.add(n.right);
            }
        }
    }

    private static void TraversalOrderPre(Node node) {
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        TraversalOrderPre(node.left);
        TraversalOrderPre(node.right);
    }

    private static void TraversalOrderIn(Node node) {
        if(node == null){
            return;
        }
        TraversalOrderIn(node.left);
        System.out.print(node.data + " ");
        TraversalOrderIn(node.right);
    }

    private static void TraversalOrderPost(Node node) {
        if(node == null){
            return;
        }
        TraversalOrderPost(node.left);
        TraversalOrderPost(node.right);
        System.out.print(node.data + " ");
    }

    private static int Height(Node node) {
        if(node == null){
            return 0;   // return 0 (for Node height); return -1 (for Edge height)
        } return (Math.max(Height(node.left), Height(node.right)) + 1);
    }

    private static int Max(Node node) {
        if(node == null){
            return Integer.MIN_VALUE;
        } return Math.max(Math.max(Max(node.left), Max(node.right)), node.data);
    }

    private static int Sum(Node node) {
        if(node == null){
            return 0;
        } return (Sum(node.left) + Sum(node.right) + node.data);
    }

    private static int Size(Node node) {
        if(node == null){
            return 0;
        } return (Size(node.left) + Size(node.right) + 1);
    }

    private static void DisplayBinaryTree(Node node) {
        if(node == null){
            return;
        } String str = "";
        str += (node.left == null) ? "null" : node.left.data;
        str += " <- " + node.data + " -> ";
        str += (node.right == null) ? "null" : node.right.data;

        System.out.println(str);
        DisplayBinaryTree(node.left);
        DisplayBinaryTree(node.right);
    }

    private static class Pair{
        Node node; int State;
        Pair(Node node, int State){
            this.node = node;
            this.State = State;
        }
    }

    private static void ConstructBinaryTree(Integer[] Arr, Node root) {
        Stack<Pair> s = new Stack<>();
        s.add(new Pair(root, 1));

        int i = 0;
        while(!s.isEmpty()){
            Pair p = s.peek();
            if(p.State == 1){
                i++;
                if(Arr[i] != null){
                    p.node.left = new Node(Arr[i], null, null);
                    s.add(new Pair(p.node.left, 1));
                } else{
                    p.node.left = null;
                } p.State++;
            } else if(p.State == 2){
                i++;
                if(Arr[i] != null){
                    p.node.right = new Node(Arr[i], null, null);
                    s.add(new Pair(p.node.right, 1));
                } else{
                    p.node.right = null;
                } p.State++;
            } else if(p.State == 3){
                s.pop();
            }
        }
    }
}