/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();

        if(node == null)
        return null;

        Node newNode = new Node(node.val);

        dfs(newNode, node, map);

        return newNode;

    }

    private void dfs(Node newNode, Node node, HashMap<Node, Node> map){

        map.put(node, newNode);

        for(Node adjNode : node.neighbors){
            if(map.containsKey(adjNode)){
                newNode.neighbors.add(map.get(adjNode));
            }
            else{
                Node newAdjNode = new Node(adjNode.val);
                map.put(adjNode, newAdjNode);
                newNode.neighbors.add(map.get(adjNode));
                dfs(newAdjNode, adjNode, map);
            }
        }
    }


}