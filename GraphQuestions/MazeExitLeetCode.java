import java.util.PriorityQueue;

public class MazeExitLeetCode {

    // https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
    
    public static void main(String[] args) {
        char[][] maze = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int[] entrance = {1,2};
        System.out.println(Dijkstra(maze, entrance));
    }

    private static class Pair implements Comparable<Pair>{
        int i, j, steps;
        Pair(int i, int j, int steps){
            this.i = i;
            this.j = j;
            this.steps = steps;
        }
        @Override
        public int compareTo(Pair o) {
            return (this.steps - o.steps);
        }
    }

    private static int Dijkstra(char[][] maze, int[] entrance) {
        boolean[][] Arr = new boolean[maze.length][maze[0].length];
        int[][] XY = {{0,-1},{-1,0},{0,1},{1,0}};
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(entrance[0], entrance[1], 0));

        int steps = -1;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(((p.i != entrance[0]) || (p.j != entrance[1])) && ((p.i  == 0) || (p.j == 0) || (p.i == (maze.length - 1)) || (p.j == (maze[0].length - 1)))){
                steps = p.steps; break;
            } if(Arr[p.i][p.j]){
                continue;
            } Arr[p.i][p.j] = true;

            for(int i=0; i<XY.length; i++){
                int x = (p.i + XY[i][0]), y = (p.j + XY[i][1]);
                if((x >= 0) && (y >= 0) && (x < maze.length) && (y < maze[0].length) && !Arr[x][y] && (maze[x][y] == '.')){
                    pq.add(new Pair(x, y, (p.steps + 1)));
                }
            }
        } return steps;
    }
}