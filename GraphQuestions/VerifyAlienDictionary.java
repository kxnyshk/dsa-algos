import java.util.HashMap;

public class VerifyAlienDictionary {
    
    // https://leetcode.com/problems/verifying-an-alien-dictionary/
    // LeetCode solution -> class Solution {..}

    class Solution {
        
        public boolean isAlienSorted(String[] words, String order) {
            Map.clear(); map(order);
            return check(words);
        }
        
        private static HashMap<Character, Integer> Map = new HashMap<>();
        
        private static boolean check(String[] words){
            for(int i=0; i<(words.length - 1); i++){
                String w1 = words[i]; String w2 = words[i + 1];
                if(!comp(w1, w2)){
                    return false;
                }
            } return true;
        }
        
        private static boolean comp(String w1, String w2){
            int len1 = w1.length(); int len2 = w2.length(); 
            int size = Math.min(len1, len2);
            
            for(int i=0; i<size; i++){
                if(Map.get(w1.charAt(i)) > Map.get(w2.charAt(i))){
                    return false;
                } else if (Map.get(w1.charAt(i)) == Map.get(w2.charAt(i))){
                    continue;
                } else{
                    return true;
                }
            } return (len1 <= len2) ? true : false;
        }
        
        private static void map(String order){
            for(int i=0; i<order.length(); i++){
                Map.put(order.charAt(i), i);
            }
        }
    }
}