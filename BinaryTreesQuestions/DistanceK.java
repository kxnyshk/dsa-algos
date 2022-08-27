import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class DistanceK {
    
    // https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
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
        
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            List<List<Integer>> L = new ArrayList<>();
            while(L.size() < 501){
                L.add(new ArrayList<>());
            } createGraph(root, L);
            return bfs(L, target.val, k);
        }
        
        private static class Pair {
            int Node, path;
            Pair(int Node, int path){
                this.Node = Node; this.path = path;
            }
        }
        
        private static List<Integer> bfs(List<List<Integer>> L, int T, int k){
            List<Integer> Res = new ArrayList<>();
            ArrayDeque<Pair> q = new ArrayDeque<>();
            boolean[] Arr = new boolean[501];
            
            q.add(new Pair(T, 0));
            while(!q.isEmpty()){
                Pair p = q.poll();
                if(p.path == k){
                    Res.add(p.Node);
                } if(Arr[p.Node]){
                    continue;
                } Arr[p.Node] = true;
                
                for(int E: L.get(p.Node)){
                    if(((p.path + 1) <= k) && (!Arr[E])){
                        q.add(new Pair(E, (p.path + 1)));   
                    }
                }
            } return Res;
        }
        
        private static void createGraph(TreeNode root, List<List<Integer>> L){
            ArrayDeque<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0; i<size; i++){
                    TreeNode Node = q.poll();
                    if(Node.left != null){
                        L.get(Node.val).add(Node.left.val); L.get(Node.left.val).add(Node.val);
                        q.add(Node.left);
                    } if(Node.right != null){
                        L.get(Node.val).add(Node.right.val); L.get(Node.right.val).add(Node.val);
                        q.add(Node.right);
                    }
                }
            }
        }
    }
}