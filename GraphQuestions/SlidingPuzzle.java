import java.util.ArrayDeque;
import java.util.HashSet;

public class SlidingPuzzle {

    // https://leetcode.com/problems/sliding-puzzle/
    // LeetCode solution -> class Solution {..}
 
    class Solution {

        public int slidingPuzzle(int[][] board) {
            return bfs(board, getString(board));
        }
        
        private static int[][] Array = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        private static String Result = "123450";
        
        private static int bfs(int[][] board, String og){
            ArrayDeque<String> q = new ArrayDeque<>();
            HashSet<String> Set = new HashSet<>();
            
            q.add(og); Set.add(og); int Res = 0;
            
            while(!q.isEmpty()){
                int size = q.size();
                
                while(size > 0){
                    String s = q.poll();
                    if(s.equals(Result)){
                        return Res;
                    }
    
                    int ogIdx = s.indexOf('0'); int i = 0;
                    while(i < Array[ogIdx].length){
                        String swapped = getSwapped(s, ogIdx, i); i++;
                        if(Set.contains(swapped)){
                            continue;
                        } else{
                            q.add(swapped); Set.add(swapped);
                        }
                    } size--;
                } Res++;
            } return -1;
        }
        
        private static String getSwapped(String s, int ogIdx, int i){
            char[] charArr = s.toCharArray();
            int spIdx = Array[ogIdx][i];
            
            char temp = charArr[ogIdx];
            charArr[ogIdx] = charArr[spIdx];
            charArr[spIdx] = temp;
            return new String(charArr);
        }
        
        private static String getString(int[][] board){
            String og = ""; 
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[i].length; j++){
                    og += board[i][j];
                }
            } return og;
        }
    }
}