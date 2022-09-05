import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kStopsLeetCode {

    // https://leetcode.com/problems/cheapest-flights-within-k-stops/
    // LeetCode solution -> class Solution {..}

    class Solution {
        
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            L.clear(); buildGraph(n, flights);
            return cheapPrice(n, src, dst, k);
        }
        
        private static List<List<int[]>> L = new ArrayList<>();
        
        private static class Pair implements Comparable<Pair>{
            int Node, Path, Stop;
            Pair(int Node, int Path, int Stop){
                this.Node = Node; this.Path = Path; this.Stop = Stop;
            } @Override
            public int compareTo(Pair o) {
                return (this.Path - o.  Path);
            }
        }
        
        private static int cheapPrice(int n, int S, int T, int K){
            int[] ArrPath = new int[n]; Arrays.fill(ArrPath, Integer.MAX_VALUE); ArrPath[S] = 0;
            int[] ArrStop = new int[n]; Arrays.fill(ArrStop, Integer.MAX_VALUE); ArrStop[S] = 0;
            
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.add(new Pair(S, 0, 0));
            
            while(!pq.isEmpty()){
                Pair p = pq.poll();
                if(p.Node == T){
                    return p.Path;
                } if(p.Stop > K){
                    continue;
                }
                
                for(int[] Arr: L.get(p.Node)){
                    if(((p.Path + Arr[1]) < ArrPath[Arr[0]]) || ((p.Stop + 1) < ArrStop[Arr[0]])){
                        ArrPath[Arr[0]] = p.Path + Arr[1];
                        ArrStop[Arr[0]] = p.Stop + 1;
                        pq.add(new Pair(Arr[0], (p.Path + Arr[1]), (p.Stop + 1)));
                    }
                }
            } return -1;
        }
        
        private static void buildGraph(int n, int[][] flights){
            for(int i=0; i<n; i++){
                L.add(new ArrayList<>());
            }
            for(int i=0; i<flights.length; i++){
                int u = flights[i][0], v = flights[i][1], w = flights[i][2];
                int[] Arr1 = new int[2];
                Arr1[0] = v; Arr1[1] = w;
                L.get(u).add(Arr1);
            }
        }
    }
}