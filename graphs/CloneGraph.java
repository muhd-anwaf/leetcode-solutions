/*
 * LeetCode #133 - Clone Graph
 * Difficulty: Medium
 * Topic: Graphs / BFS / HashMap
 *
 * Approach:
 * 1. Use a HashMap to map each original node to its clone.
 * 2. Use BFS to visit every node in the graph.
 * 3. For each neighbor, create its clone if it does not exist.
 * 4. Connect the cloned current node to the cloned neighbor.
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */
import java.util.*;
class Solutions {
    public Node cloneGraph(Node node) {

        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        Node clone = new Node(node.val);
        map.put(node, clone);
        q.offer(node);

        while (!q.isEmpty()) {
            Node current = q.poll();

            for (Node neighbor : current.neighbors) {
                if (!map.containsKey(neighbor)) {
                    Node newNode = new Node(neighbor.val);
                    map.put(neighbor, newNode);
                    q.offer(neighbor);
                }

                map.get(current).neighbors.add(map.get(neighbor));
            }
        }

        return clone;
    }
}
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