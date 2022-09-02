import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class BusRoutes {

    // https://leetcode.com/problems/bus-routes/
    // LeetCode solution -> class Solution {..}
    
    class Solution {
        
        public int numBusesToDestination(int[][] routes, int source, int target) {
            HashMap<Integer, ArrayList<Integer>> Map = new HashMap<>();
            createMap(routes, Map);
            return bfs(routes, Map, source, target);
        }
        
        private static int bfs(int[][] routes, HashMap<Integer, ArrayList<Integer>> Map, int S, int T){
            HashSet<Integer> BusStops = new HashSet<>();
            HashSet<Integer> BusNumbs = new HashSet<>();
            
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.add(S);
            
            int buses = 0;
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0; i<size; i++){
                    int busStop = q.poll();
                    if(busStop == T){
                        return buses;
                    } ArrayList<Integer> busNum = Map.get(busStop);
                    
                    for(int j=0; j<busNum.size(); j++){
                        int busNumber = busNum.get(j);
                        if(!BusNumbs.contains(busNumber)){
                            for(int k=0; k<routes[busNumber].length; k++){
                                if(!BusStops.contains(routes[busNumber][k])){
                                    q.add(routes[busNumber][k]);
                                    BusStops.add(routes[busNumber][k]);
                                }
                            }
                        } BusNumbs.add(busNumber);
                    }
                } buses++;
            } return -1;
        }
        
        private static void createMap(int[][] Arr, HashMap<Integer, ArrayList<Integer>> Map){
            for(int i=0; i<Arr.length; i++){
                for(int j=0; j<Arr[i].length; j++){
                    ArrayList<Integer> L = Map.getOrDefault(Arr[i][j], new ArrayList<Integer>());
                    L.add(i); Map.put(Arr[i][j], L);
                }
            }
        }
    }
}