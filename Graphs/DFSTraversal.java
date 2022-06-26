import java.util.ArrayList;

public class DFSTraversal {
    
    public static void main(String[] args) {
        
        int V = 4;
        ArrayList<ArrayList<Integer>> AdjList = new ArrayList<ArrayList<Integer>>(V);

        for(int i=0; i<V; i++){
            AdjList.add(new ArrayList<Integer>());
        }

        AddEdge(AdjList, 0, 1);
        AddEdge(AdjList, 0, 2);
        AddEdge(AdjList, 1, 2);
        AddEdge(AdjList, 2, 0);
        AddEdge(AdjList, 2, 3);
        AddEdge(AdjList, 3, 3);

        // DFS Traversal starting from Node - 2
        DFS(2, V, AdjList);
    }

    private static void DFS(int node, int vertices, ArrayList<ArrayList<Integer>> AdjList){
        boolean[] Visited = new boolean[vertices];
        DFSRecursive(node, Visited, AdjList);
    }

    private static void DFSRecursive(int currNode, boolean[] Visited, ArrayList<ArrayList<Integer>> AdjList){
        Visited[currNode] = true;
        VisitNode(currNode);
        for(int destNode : AdjList.get(currNode)){
            if (!Visited[destNode])
                DFSRecursive(destNode, Visited, AdjList);
        }
    }

    private static void VisitNode(int node){
        System.err.print(node + " ");
    }

    private static void AddEdge(ArrayList<ArrayList<Integer>> AdjList, int u, int v){
        AdjList.get(u).add(v);
    }
}

/* Ref : https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
         https://www.baeldung.com/java-depth-first-search#1-graph-dfs-with-recursion   */

// Time complexity : O(V + E)

// Space complexity : O(V)
