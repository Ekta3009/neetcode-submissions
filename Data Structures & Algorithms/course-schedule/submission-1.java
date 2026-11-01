class Solution {
    public boolean canFinish(int n, int[][] arr) {
        int i;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (i = 0; i < arr.length; i++) {
            int u = arr[i][0];
            int v = arr[i][1];

            adj.get(u).add(v);
        }

        int vis[] = new int[n];
        int pathVisited[] = new int[n];

        for (i = 0; i < n; i++) {
            if (vis[i] == 0) {
                if (detectCycle(i, vis, pathVisited, adj)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean detectCycle(
        int node, int vis[], int pathVisited[], ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        pathVisited[node] = 1;

        for (int adjNode : adj.get(node)) {
            if (vis[adjNode] == 1 && pathVisited[adjNode] == 1) {
                return true;
            } else if (vis[adjNode] == 0) {
                if (detectCycle(adjNode, vis, pathVisited, adj)) {
                    return true;
                }
            }
        }

        pathVisited[node] = 0;
        return false;
    }
}
