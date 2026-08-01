class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int i,j,m=grid.length,n=grid[0].length;

        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(grid[i][j] == 0){
                    dijkstra(i,j,grid);
                }
            }
        }
    }

    private void dijkstra(int row, int col, int[][] grid){

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);
        pq.add(new Pair(0,row,col));

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        int m=grid.length,n=grid[0].length,i,j;

        while(!pq.isEmpty()){
            Pair p = pq.poll();

            int dist = p.dist;
            int r = p.row;
            int c = p.col;

            for(i=0;i<4;i++){
                int nrow = r + dr[i];
                int ncol = c + dc[i];

                if(isValid(nrow,ncol,m,n) && isLand(nrow,ncol,grid)){
                    if(grid[nrow][ncol] > (dist + Math.abs(nrow-r+ ncol-c))){
                        grid[nrow][ncol] = dist + Math.abs(nrow-r+ ncol-c);
                        pq.add(new Pair(grid[nrow][ncol], nrow, ncol));
                    }
                }
            }

        }
    }

    private boolean isValid(int r, int c, int m, int n){
        return r >= 0 && c >= 0 && r < m && c < n;
    }

    private boolean isLand(int row, int col, int[][] grid){
        return (grid[row][col] != -1 && grid[row][col] != 0);
    }
}

class Pair {
    int dist;
    int row;
    int col;

    Pair(int dist, int row, int col){
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}
