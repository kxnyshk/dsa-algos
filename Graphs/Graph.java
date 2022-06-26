import java.util.ArrayList;

public class Graph{

    public static void main(String[] args) {
        
        // Creating graph with 'V' vertices
        int V = 5;
        ArrayList<ArrayList<Integer>> AdjList = new ArrayList<ArrayList<Integer>>(V);

        for(int i=0; i<V; i++){
            AdjList.add(new ArrayList<Integer>());
        }

        // Adding edges on graph
        AddEdge(AdjList, 0, 1);
        AddEdge(AdjList, 0, 4);
        AddEdge(AdjList, 1, 2);
        AddEdge(AdjList, 1, 3);
        AddEdge(AdjList, 1, 4);
        AddEdge(AdjList, 2, 3);
        AddEdge(AdjList, 3, 4);

        // Printing graph
        PrintGraph(AdjList);
    }

    // Function to add an edge in an undirected graph
    private static void AddEdge(ArrayList<ArrayList<Integer>> AdjList, int u, int v){
        AdjList.get(u).add(v);
        AdjList.get(v).add(u);
    }

    // Function to print the graph as an adjacency list
    private static void PrintGraph(ArrayList<ArrayList<Integer>> AdjList){
        System.out.println();
        for(int i=0; i<AdjList.size(); i++){
            System.out.print("Vertex " + i + " : ");
            System.out.print("head");
            for(int j=0; j<AdjList.get(i).size(); j++){
                System.out.print(" -> " + AdjList.get(i).get(j));
            }
            System.out.println("\n");
        }
    }
}

// Ref : https://www.educative.io/edpresso/what-is-an-adjacency-list

// Time complexity :
    // 1) Adding edge : O(1)
    // 2) Adding vertex : O(1)
    // 3) Removing edge : O(V)
    // 4) Removing vertex : O(V + E)

// Space complexity
    // 1) Average case : O(V + E)
    // 2) Worst case : O(V^2)