package thirdweek;

import util.Node;

import java.util.*;

public class CloneGraph {

        public Node cloneGraph(Node node) {

            if (node == null) {
                return null;
            }

            Set<Node> visited = new HashSet<>();
            Queue<Node> remainingNodes = new ArrayDeque<>();
            Map<Node, Node> cloneNodes = new HashMap<>();
            Node aux = new Node();

            cloneNodes.put(node, aux);
            remainingNodes.add(node);

            Node originalNode;
            while (!remainingNodes.isEmpty()) {

                originalNode = remainingNodes.poll();
                if (!visited.add(originalNode)) {
                    continue;
                }
                aux = cloneNodes.get(originalNode);
                aux.val = originalNode.val;
                List<Node> auxNeighbours = new ArrayList<>();
                for (Node neighbour : originalNode.neighbors) {
                    remainingNodes.add(neighbour);
                    if (!cloneNodes.containsKey(neighbour)) {
                        cloneNodes.put(neighbour, new Node(neighbour.val));
                    }
                    auxNeighbours.add(cloneNodes.get(neighbour));
                }
                aux.neighbors = auxNeighbours;
            }

            return cloneNodes.get(node);
        }
}
