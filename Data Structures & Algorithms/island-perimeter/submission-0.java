class Solution {
    public int islandPerimeter(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[] drows = {-1,0,1,0};
        int[] ccols = {0,1,0,-1};

        int perimeter = 0;

        for (int i=0; i<rows; i++) {

            for (int j=0; j<cols; j++) {

                if (grid[i][j] == 1) {

                    for (int k=0 ;k<4; k++) {

                        int nrow = i + drows[k];
                        int ncols = j + ccols[k];
                        
                        if (nrow < 0 || nrow >= rows || 
                        ncols < 0 || ncols >= cols || grid[nrow][ncols] == 0) {
                            perimeter++;
                        }
                    }
                }
            }
        }

        return perimeter;
        
    }
}