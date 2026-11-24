class Solution {


    class Pair {

        int first;

        int second;

        public Pair(int a, int b) {
            first = a;
            second = b;
        }
    }

    public void bfs(char[][] grids, int[][] visit, int row, int col) {

        int n = grids.length;
        int c = grids[0].length;

        Queue<Pair> qu = new LinkedList<>();

        visit[row][col] = 1;

        qu.add(new Pair(row, col));

        int[] drow = {-1,0,1,0};

        int[] dcol = {0,1,0,-1};



        while(!qu.isEmpty()) {

            int currrow = qu.peek().first;
            int currcol = qu.peek().second;

            qu.remove();

            for (int i=0; i<4; i++) {

                int rindex = drow[i] + currrow;
                int cindex = dcol[i] + currcol;

                if (rindex >=0 && rindex < n && cindex>=0 && cindex < c &&
                grids[rindex][cindex] == '1' && visit[rindex][cindex] == 0) {
                    
                    visit[rindex][cindex] = 1;
                    qu.add(new Pair(rindex,cindex));
                }
            }
        }
        
    }


    public int numIslands(char[][] grid) {

        int rows = grid.length;

        int cols = grid[0].length;

        int visit[][] = new int[rows][cols];
        int count = 0;

        for (int i=0; i<rows;i++) {
            
            for (int j=0;j<cols;j++) {

                if (grid[i][j] == '1' && visit[i][j] == 0) {
                    count++;

                    bfs(grid, visit, i, j);
                }
            }
        }

        return count;
        
    }
}
