import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructItinerary {

    // https://leetcode.com/problems/reconstruct-itinerary/
    // LeetCode solution -> class Solution {..}
    
    class Solution {
    
        Map<String, PriorityQueue<String>> Map = new HashMap<>();
        List<String> Res = new ArrayList<>();
        
        public List<String> findItinerary(List<List<String>> tickets) {
            buildMap(tickets); dfs("JFK");
            return Res;
        }
        
        void dfs(String Node){
            PriorityQueue<String> Clone = Map.get(Node);
            while((Clone != null) && (!Clone.isEmpty())){
                dfs(Clone.poll());
            } Res.add(0, Node);
        }
        
        void buildMap(List<List<String>> tickets){
            for(List<String> L: tickets){
                PriorityQueue<String> Val = Map.getOrDefault(L.get(0), new PriorityQueue<>());
                Val.add(L.get(1)); Map.put(L.get(0), Val);
            } //System.out.println(Map);
        }
    }
}