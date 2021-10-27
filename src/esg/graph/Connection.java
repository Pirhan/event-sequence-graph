package esg.graph;

public interface Connection<Node> {
    Node fromNode();

    Node toNode();

    double weight();
}
