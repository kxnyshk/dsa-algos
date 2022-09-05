import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MinCost {

    // https://leetcode.com/problems/min-cost-to-connect-all-points/
    // LeetCode solution -> class Solution {..}
    
    class Solution {

        private static class Edge{
            int v, w;
            Edge(int v, int w){
                this.v = v; this.w = w;
            }
        }
        
        public int minCostConnectPoints(int[][] points) {
            L.clear(); createGraph(points);
            return getMinCost();
        }
        
        private static List<List<Edge>> L = new ArrayList<>();
        
        private static class Pair implements Comparable<Pair>{
            int N, W;
            Pair(int N, int W){
                this.N = N; this.W = W;
            } @Override
            public int compareTo(Pair o) {
                return (this.W - o.W);
            }
        }
        
        private static int getMinCost(){
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            HashSet<Integer> Set = new HashSet<>();
            
            pq.add(new Pair(0, 0));
            int minCost = 0;
            
            while(Set.size() < L.size()){
                Pair p = pq.poll();
                if(Set.contains(p.N)){
                    continue;
                } Set.add(p.N); minCost += p.W;
                
                for(Edge E: L.get(p.N)){
                    if(!Set.contains(E.v)){
                        pq.add(new Pair(E.v, E.w));
                    }
                }
            } return minCost;
        }
        
        private static void createGraph(int[][] points){
            for(int i=0; i<points.length; i++){
                L.add(new ArrayList<>());
            } 
            
            for(int i=0; i<points.length; i++){
                for(int j=(i+1); j<points.length; j++){
                    int w = Math.abs(Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
                    L.get(i).add(new Edge(j, w)); L.get(j).add(new Edge(i, w));
                }
            }
        }
    }
}