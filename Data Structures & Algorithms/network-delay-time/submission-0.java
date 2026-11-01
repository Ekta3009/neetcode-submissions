class Solution {
    public int networkDelayTime(int[][] arr, int n, int k) {
        int i,j;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> (a.cost - b.cost));
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();

        for(i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(i = 0;i < arr.length;i++){
            int u = arr[i][0] - 1;
            int v = arr[i][1] - 1;
            int cos = arr[i][2];

            adj.get(u).add(new Node(v,cos));
        }

        int cost[] = new int[n];

        for(i=0;i<n;i++){
            cost[i] = Integer.MAX_VALUE;
        }

        cost[k-1] = 0;
        pq.add(new Node(k-1,0));
    
        while(!pq.isEmpty()){
            Node node = pq.remove();

            for(Node adjNode : adj.get(node.u)){
                if(cost[adjNode.u] > node.cost + adjNode.cost){
                    cost[adjNode.u] = node.cost + adjNode.cost;
                    pq.add(new Node(adjNode.u, cost[adjNode.u]));
                }
            }
        }

        int max = -1;

        for(i=0;i<n;i++){
            max = Math.max(max,cost[i]);
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }
}

class Node{
    int u;
    int cost;

    Node(int u, int cost){
        this.u = u;
        this.cost = cost;
    }
}
