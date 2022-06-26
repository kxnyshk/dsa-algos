import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BFSTraversal {
    
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

        // BFS Traversal starting from Node - 2
        BFS(2, V, AdjList);
    }

    private static void BFS(int currNode, int vertices, ArrayList<ArrayList<Integer>> AdjList){
        LinkedList<Integer> Queue = new LinkedList<Integer>();
        boolean[] Visited = new boolean[vertices];

        Visited[currNode] = true;
        Queue.add(currNode);
        
        while (Queue.size() != 0){
            currNode = Queue.poll();
            VisitNode(currNode);
            
            Iterator<Integer> I = AdjList.get(currNode).listIterator();
            while(I.hasNext()){
                int nextNode = I.next();
                if(!Visited[nextNode]){
                    Visited[nextNode] = true;
                    Queue.add(nextNode);
                }
            }
        }
    }

    private static void VisitNode(int node){
        System.err.print(node + " ");
    }

    private static void AddEdge(ArrayList<ArrayList<Integer>> AdjList, int u, int v){
        AdjList.get(u).add(v);
    }
}

/* Ref : https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
         https://www.geeksforgeeks.org/iterators-in-java/#:~:text=use%20method%20names.-,3.%20ListIterator,-It%20is%20only  */

// Time complexity : O(V + E)

// Space complexity : O(V)
