package esg.graph;

import java.util.List;

public interface Graph<Node> {
    List<Connection<Node>> getConnections(Node fromNode);
}
