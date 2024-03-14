import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;


// Definition for a Node.
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

class Solution {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null)
            return null;

        if(visited.containsKey(node)){
            return visited.get(node);
        }

        Node dupNode = new Node(node.val, new ArrayList<>());
        visited.put(node, dupNode);
        for(Node neighbor: node.neighbors){
            dupNode.neighbors.add(cloneGraph(neighbor));
        }
        return dupNode;
    }
}

class Solution1{
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;

        Queue<Node> queue = new ArrayDeque<>();
        Map<Node, Node> visited_map = new HashMap<>();
        visited_map.put(node, new Node(node.val, new ArrayList<>()));
        queue.add(node);
        
        while(!queue.isEmpty()){
            Node n = queue.remove();

            for(Node neighbor : node.neighbors){
                if(!visited_map.containsKey(neighbor)){
                    visited_map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                visited_map.get(n).neighbors.add(visited_map.get(neighbor));
            }

        }
        
        return visited_map.get(node);
    }
}