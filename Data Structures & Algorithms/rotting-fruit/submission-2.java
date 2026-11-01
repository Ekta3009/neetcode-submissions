class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length, i, j, count = 0, fresh = 0;
        boolean rotten;
        Queue<Node> q = new LinkedList<>();

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Node(i, j));
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0){
            return 0;
        }

        int nrow[] = {1, 0, -1, 0};
        int ncol[] = {0, -1, 0, 1};

        while (!q.isEmpty()) {
            int size = q.size();
            rotten = false;
            for (i = 0; i < size; i++) {
                Node node = q.remove();

                for (int k = 0; k < 4; k++) {
                    if (isValid(node.row + nrow[k], node.col + ncol[k], grid)) {
                        Node adjNode = new Node(node.row + nrow[k], node.col + ncol[k]);
                        if (grid[adjNode.row][adjNode.col] == 1) {
                            grid[adjNode.row][adjNode.col] = 2;
                            q.add(adjNode);
                            rotten = true;
                            fresh--;
                        }
                    }
                }
            }

            if (rotten) {
                count++;
            }
        }

        return fresh != 0 ? -1 : count;
    }

    private boolean isValid(int row, int col, int[][] grid) {
        return (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length);
    }
}

class Node {
    int row;
    int col;

    Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
